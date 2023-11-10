package co.edu.uco.spaonline.service.businesslogic.concrete.servicio;

import java.util.Optional;
import java.util.UUID;

import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.crosscutting.util.UtilUUID;
import co.edu.uco.spaonline.data.dao.ServicioDAO;
import co.edu.uco.spaonline.data.dao.TipoServicioDAO;
import co.edu.uco.spaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.spaonline.data.entity.ServicioEntity;
import co.edu.uco.spaonline.data.entity.TipoServicioEntity;
import co.edu.uco.spaonline.service.businesslogic.UseCase;
import co.edu.uco.spaonline.service.domain.informacionservicio.InformacionServicioDomain;
import co.edu.uco.spaonline.service.domain.servicio.ServicioDomain;
import co.edu.uco.spaonline.service.mapper.entity.concrete.ServicioEntityMapper;



public class RegistrarServicioUseCase implements UseCase<ServicioDomain> {

	private DAOFactory factoria;
	
	public RegistrarServicioUseCase(DAOFactory factoria) {
		setFactoria(factoria);
	}
	
	@Override
	public void execute(ServicioDomain domain) {
		validarNoExistenciaMismaInformacion(domain.getInformacionServicio());
		validarExistenciaTipoServicio(domain.getId());
		domain = obtenerIdentificadorCliente(domain);
		registrar(domain);
	}
	
	private final ServicioDomain obtenerIdentificadorCliente(ServicioDomain domain) {
		Optional<ServicioEntity> optional;
		UUID uuid;
		
		do {
			uuid = UtilUUID.generarUUIDAleatorio();
			optional = getServicioDAO().consultarPorId(uuid);
		} while (optional.isPresent());
		
		return ServicioDomain.crear(uuid,domain.getTipoServicio(), domain.getInformacionServicio(),domain.getPrecio(),domain.getDuracionHoraServicio());
	}
	
	private final void validarNoExistenciaMismaInformacion(final InformacionServicioDomain informacion) {
		final var domain = ServicioDomain.crear(null,null,informacion,null,null);
		final var entity = ServicioEntityMapper.convertToEntity(domain);
		final var resultados = getServicioDAO().consultar(entity);
		
		if(!resultados.isEmpty()) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000011);
			throw ServiceSpaOnlineException.crear(mensajeUsuario);
		}
	}

	private final void validarExistenciaTipoServicio(final UUID tipoServicio) {
		Optional<TipoServicioEntity> optional;
		optional = getTipoServicioDAO().consultarPorId(tipoServicio);
		
		if(!optional.isPresent()) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000014);
			throw ServiceSpaOnlineException.crear(mensajeUsuario);
		}
	}
	

	
	private void registrar(final ServicioDomain domain) {
		getServicioDAO().crear(ServicioEntityMapper.convertToEntity(domain));
	}
	
	private final DAOFactory getFactoria() {
		return factoria;
	}
	
	private final void setFactoria(final DAOFactory factoria) {
		if(UtilObjeto.esNulo(factoria)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000099);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000010);
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
