package co.edu.uco.spaonline.service.businesslogic.concrete.servicio;

import java.util.UUID;

import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.data.dao.ServicioDAO;
import co.edu.uco.spaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.spaonline.service.businesslogic.UseCase;
import co.edu.uco.spaonline.service.domain.servicio.ServicioDomain;

public class EliminarServicioUseCase implements UseCase<ServicioDomain> {

	private DAOFactory factoria;
	
	public EliminarServicioUseCase(DAOFactory factoria) {
		setFactoria(factoria);
	}
	
	@Override
	public void execute(ServicioDomain domain) {
		validarExistenciaRegistro(domain.getId());
		eliminar(domain.getId());
	}
	private final void validarExistenciaRegistro(final UUID id) {
		final var resultados = getServicioDAO().consultarPorId(id);
		
		if(resultados.isEmpty()) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000017);
			throw ServiceSpaOnlineException.crear(mensajeUsuario);
		}
	}
	
	private void eliminar(final UUID id) {
		getServicioDAO().eliminar(id);
	}
	
	private final DAOFactory getFactoria() {
		return factoria;
	}
	
	private final void setFactoria(final DAOFactory factoria) {
		if(UtilObjeto.esNulo(factoria)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000015);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000016);
			throw ServiceSpaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		this.factoria = factoria;
	}
	
	private final ServicioDAO getServicioDAO() {
		return getFactoria().obtenerServicioDAO();
	}

}
