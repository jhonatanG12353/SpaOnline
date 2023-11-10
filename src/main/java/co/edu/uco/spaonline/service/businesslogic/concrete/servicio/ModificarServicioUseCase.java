package co.edu.uco.spaonline.service.businesslogic.concrete.servicio;

import java.util.Optional;
import java.util.UUID;

import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.data.dao.ServicioDAO;
import co.edu.uco.spaonline.data.dao.TipoServicioDAO;
import co.edu.uco.spaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.spaonline.data.entity.TipoServicioEntity;
import co.edu.uco.spaonline.service.businesslogic.UseCase;
import co.edu.uco.spaonline.service.domain.servicio.ServicioDomain;
import co.edu.uco.spaonline.service.mapper.entity.concrete.ServicioEntityMapper;

public class ModificarServicioUseCase implements UseCase<ServicioDomain> {

	private DAOFactory factoria;
	
	public ModificarServicioUseCase(DAOFactory factoria) {
		setFactoria(factoria);
	}
	
	@Override
	public void execute(ServicioDomain domain) {
		validarExistenciaRegistro(domain.getId());
		validarExistenciaTipoIdentificacion(domain.getTipoServicio().getId());
		modificar(domain);
	}
	
	private final void validarExistenciaRegistro(final UUID id) {
		final var resultados = getServicioDAO().consultarPorId(id);
		
		if(resultados.isEmpty()) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000014);
			throw ServiceSpaOnlineException.crear(mensajeUsuario);
		}
	}
	
	private final void validarExistenciaTipoIdentificacion(final UUID tipoServicio) {
		Optional<TipoServicioEntity> optional;
		optional = getTipoServicioDAO().consultarPorId(tipoServicio);
		
		if(!optional.isPresent()) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000018);
			throw ServiceSpaOnlineException.crear(mensajeUsuario);
		}
	}
	
	private void modificar(final ServicioDomain domain) {
		getServicioDAO().modificar(ServicioEntityMapper.convertToEntity(domain));
	}
	
	private final DAOFactory getFactoria() {
		return factoria;
	}
	
	private final void setFactoria(final DAOFactory factoria) {
		if(UtilObjeto.esNulo(factoria)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000018);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000019);
			throw ServiceSpaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		this.factoria = factoria;
	}
	
	private final ServicioDAO getServicioDAO() {
		return getFactoria().obtenerServicioDAO();
	}

	private final TipoServicioDAO getTipoServicioDAO() {
		return getFactoria().obtenerTipoServicioDAO();
	}

}
