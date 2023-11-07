package co.edu.uco.spaonline.service.businesslogic.concrete.tiposervicio;

import java.util.Optional;
import java.util.UUID;

import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.data.dao.TipoServicioDAO;
import co.edu.uco.spaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.spaonline.data.entity.TipoServicioEntity;
import co.edu.uco.spaonline.service.businesslogic.UseCase;
import co.edu.uco.spaonline.service.domain.tiposervicio.TipoServicioDomain;
import co.edu.uco.spaonline.service.mapper.entity.concrete.TipoServicioEntityMapper;

public class RegistrarTipoServicioUseCase implements UseCase<TipoServicioDomain> {
	
	private  DAOFactory factoria;
	
	public RegistrarTipoServicioUseCase(final DAOFactory factoria) {
		setFactoria(factoria);	
	}
	
	@Override
	public void execute(TipoServicioDomain domain) {

		domain = obtenerTipoServicioDomain( domain);

		validarNoExistenciaTipoServicioConMismoNombre(domain.getNombreTipoServicio());

		registrarNuevoTipoServicio(domain);
	}
	private void validarIntegridadTipoServicio(final TipoServicioDomain domain) {
		if (UtilObjeto.esNulo(domain)) {
		    var mensajeUsuario= "El objeto TipoServicioDomain no puede ser nulo";
			throw  ServiceSpaOnlineException.crear(mensajeUsuario);
		}

		if (UtilObjeto.esNulooVacio(domain.getNombreTipoServicio())) {
			var mensajeUsuario= "El campo 'nombre' es obligatorio y no puede ser nulo o vacío";
		    throw  ServiceSpaOnlineException.crear(mensajeUsuario);
		}

		if (UtilObjeto.esNulooVacio(domain.getId())) {
			var mensajeUsuario= "El campo 'Id' es obligatorio y no puede ser nulo o vacío";
			throw  ServiceSpaOnlineException.crear(mensajeUsuario);
		}

	}
	
	private void registrarNuevoTipoServicio(final TipoServicioDomain domain) {
		var entity = TipoServicioEntityMapper.convertToEntity(domain);
		getTipoServicioDAO().crear(entity);
		
	}
	private final void setFactoria(final DAOFactory factoria) {
		if(UtilObjeto.esNulo(factoria)) {
			var mensajeUsuario= CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000068);
			var mensajeTecnico= CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000069);
			 throw ServiceSpaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		this.factoria = factoria;
	}
	private final TipoServicioDAO getTipoServicioDAO() {
		return getFactoria().obtenerTipoServicioDAO();
	}
	private final DAOFactory getFactoria() {
		return factoria;
	}
	
	private final void validarNoExistenciaTipoServicioConMismoNombre(final String nombre) {

		var domain = TipoServicioDomain.crear(null,nombre);
		var entity = TipoServicioEntityMapper.convertToEntity(domain);
		var resultados = getTipoServicioDAO().consultar(entity);
		
		if(resultados.isEmpty()) {
			var mensajeUsuario = " ya existe un tipo de Servicio con el nombre"+ nombre;
			throw ServiceSpaOnlineException.crear(mensajeUsuario);
		}
	}

private final TipoServicioDomain obtenerTipoServicioDomain(TipoServicioDomain domain) {
		
		Optional<TipoServicioEntity> optional ;
		UUID uuid;
		do {
			uuid= UUID.randomUUID();			
			optional = getTipoServicioDAO().consultarPorId(uuid);
			
		}while(!optional.isEmpty());
			
		return TipoServicioDomain.crear(uuid, domain.getNombreTipoServicio());
				}


}
