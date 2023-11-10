package co.edu.uco.spaonline.service.facade.concrete.tiposervicio;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.spaonline.crosscutting.exception.SpaOnlineException;
import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.spaonline.data.dao.daofactory.TipoDAOFactory;
import co.edu.uco.spaonline.service.businesslogic.concrete.tiposervicio.ConsultarTipoServicioUseCase;
import co.edu.uco.spaonline.service.businesslogic.validator.concrete.tiposervicio.ConsultarTipoServicioValidator;
import co.edu.uco.spaonline.service.domain.tiposervicio.TipoServicioDomain;
import co.edu.uco.spaonline.service.dto.TipoServicioDTO;
import co.edu.uco.spaonline.service.facade.FacadeF;
import co.edu.uco.spaonline.service.mapper.dto.concrete.TipoServicioDTOMapper;

public class ConsultarTipoServicioFacade implements FacadeF<TipoServicioDTO>{

	@Override
	public List<TipoServicioDTO> execute(final TipoServicioDTO dto) {
		final TipoServicioDomain domain = TipoServicioDTOMapper.convertToDomain(dto);
		ConsultarTipoServicioValidator.ejecutar(domain);
		List<TipoServicioDTO> resultados = new ArrayList<>();
		
		DAOFactory daofactory = DAOFactory.obtenerDAOFactory(TipoDAOFactory.POSTGRESQL);
		
		try {
			daofactory.iniciarTransaccion();
			var useCase = new ConsultarTipoServicioUseCase(daofactory);
			resultados = TipoServicioDTOMapper.convertToListDTO(useCase.execute(domain));
			daofactory.confirmarTransaccion();
		} catch (SpaOnlineException e) {
			daofactory.cancelarTransaccion();
			throw e;
		} catch (Exception e) {
			daofactory.cancelarTransaccion();
			final var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000013);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000013);
			throw ServiceSpaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		} finally {
			daofactory.cerrarConexion();
		}
		return resultados;
	}

}
