package co.edu.uco.spaonline.service.facade.concrete.servicio;

import co.edu.uco.spaonline.crosscutting.exception.SpaOnlineException;
import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.spaonline.data.dao.daofactory.TipoDAOFactory;
import co.edu.uco.spaonline.service.businesslogic.concrete.servicio.ModificarServicioUseCase;
import co.edu.uco.spaonline.service.businesslogic.validator.concrete.servicio.ModificarServicioValidator;
import co.edu.uco.spaonline.service.domain.servicio.ServicioDomain;
import co.edu.uco.spaonline.service.dto.ServicioDTO;
import co.edu.uco.spaonline.service.facade.Facade;
import co.edu.uco.spaonline.service.mapper.dto.concrete.ServicioDTOMapper;

public class ModificarServicioFacade implements Facade<ServicioDTO> {
@Override
public void execute(final ServicioDTO dto) {
	final ServicioDomain domain = ServicioDTOMapper.convertToDomain(dto);
	ModificarServicioValidator.ejecutar(domain);
	
	DAOFactory daofactory = DAOFactory.obtenerDAOFactory(TipoDAOFactory.POSTGRESQL);
	
	try {
		daofactory.iniciarTransaccion();
		var useCase = new ModificarServicioUseCase(daofactory);
		useCase.execute(domain);
		daofactory.confirmarTransaccion();
	} catch (SpaOnlineException e) {
		daofactory.cancelarTransaccion();
		throw e;
	} catch (Exception e) {
		daofactory.cancelarTransaccion();
		final var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000018);
		final var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000019);
		throw ServiceSpaOnlineException.crear(mensajeUsuario, mensajeTecnico);
	} finally {
		daofactory.cerrarConexion();
	}
}

}
