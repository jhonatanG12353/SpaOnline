package co.edu.uco.spaonline.service.facade.concrete.tiposervicio;

import co.edu.uco.spaonline.crosscutting.exception.SpaOnlineException;
import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.spaonline.data.dao.daofactory.TipoDAOFactory;
import co.edu.uco.spaonline.service.businesslogic.concrete.tiposervicio.EliminarTipoServicioUseCase;
import co.edu.uco.spaonline.service.businesslogic.validator.concrete.tiposervicio.EliminarTipoServicioValidator;
import co.edu.uco.spaonline.service.domain.tiposervicio.TipoServicioDomain;
import co.edu.uco.spaonline.service.dto.TipoServicioDTO;
import co.edu.uco.spaonline.service.facade.Facade;
import co.edu.uco.spaonline.service.mapper.dto.concrete.TipoServicioDTOMapper;

public class EliminarTipoServicioFacade implements Facade<TipoServicioDTO>{

	@Override
	public void execute(final TipoServicioDTO dto) {
		final TipoServicioDomain domain = TipoServicioDTOMapper.convertToDomain(dto);
		EliminarTipoServicioValidator.ejecutar(domain);
		
		DAOFactory daofactory = DAOFactory.obtenerDAOFactory(TipoDAOFactory.POSTGRESQL);
		
		try {
			daofactory.iniciarTransaccion();
			var useCase = new EliminarTipoServicioUseCase(daofactory);
			useCase.execute(domain);
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
	}

}
