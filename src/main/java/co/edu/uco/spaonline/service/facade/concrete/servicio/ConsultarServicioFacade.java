package co.edu.uco.spaonline.service.facade.concrete.servicio;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.spaonline.crosscutting.exception.SpaOnlineException;
import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.spaonline.data.dao.daofactory.TipoDAOFactory;
import co.edu.uco.spaonline.service.businesslogic.concrete.servicio.ConsultarServicioUseCase;
import co.edu.uco.spaonline.service.businesslogic.validator.concrete.servicio.ConsultarServicioValidator;
import co.edu.uco.spaonline.service.domain.servicio.ServicioDomain;
import co.edu.uco.spaonline.service.dto.ServicioDTO;
import co.edu.uco.spaonline.service.facade.FacadeF;
import co.edu.uco.spaonline.service.mapper.dto.concrete.ServicioDTOMapper;

public class ConsultarServicioFacade implements FacadeF<ServicioDTO>{

	@Override
	public List<ServicioDTO> execute(final ServicioDTO dto) {
		final ServicioDomain domain = ServicioDTOMapper.convertToDomain(dto);
		ConsultarServicioValidator.ejecutar(domain);
		List<ServicioDTO> resultados = new ArrayList<>();
		
		DAOFactory daofactory = DAOFactory.obtenerDAOFactory(TipoDAOFactory.POSTGRESQL);
		
		try {
			daofactory.iniciarTransaccion();
			var useCase = new ConsultarServicioUseCase(daofactory);
			resultados = ServicioDTOMapper.convertToListDTO(useCase.execute(domain));
			daofactory.confirmarTransaccion();
		} catch (SpaOnlineException e) {
			daofactory.cancelarTransaccion();
			throw e;
		} catch (Exception e) {
			daofactory.cancelarTransaccion();
			final var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000017);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000017);
			throw ServiceSpaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		} finally {
			daofactory.cerrarConexion();
		}
		return resultados;
	}

}
