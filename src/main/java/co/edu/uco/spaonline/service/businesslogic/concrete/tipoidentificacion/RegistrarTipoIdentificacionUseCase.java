package co.edu.uco.spaonline.service.businesslogic.concrete.tipoidentificacion;

import java.util.List;

import java.util.Optional;
import java.util.UUID;


import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.spaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.spaonline.data.entity.TipoIdentificacionEntity;
import co.edu.uco.spaonline.service.businesslogic.UseCase;
import co.edu.uco.spaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.spaonline.service.mapper.entity.concrete.TipoIdentificacionEntityMapper;

public class RegistrarTipoIdentificacionUseCase implements UseCase<TipoIdentificacionDomain> {

	private  DAOFactory factoria;

	public RegistrarTipoIdentificacionUseCase(final DAOFactory factoria) {
		setFactoria(factoria);		
	}
	
	public final void execute(TipoIdentificacionDomain domain) {
		

		domain = obtenerTipoIdentificacionDomain( domain);

		validarNoExistenciaTipoIdentificacionConMismoCodigo(domain.getCodigo());

		validarNoExistenciaTipoIdentificacionConMismoNombre(domain.getNombre());

		registrarNuevoTipoIdentificacion(domain);
	}
	
	private void validarIntegridadTipoIdentificacion(final TipoIdentificacionDomain domain) {
		if (UtilObjeto.esNulo(domain)) {
		    var mensajeUsuario= "El objeto TipoIdentificacionDomain no puede ser nulo";
			throw  ServiceSpaOnlineException.crear(mensajeUsuario);
		}

		if (UtilObjeto.esNulooVacio(domain.getNombre())) {
			var mensajeUsuario= "El campo 'nombre' es obligatorio y no puede ser nulo o vacío";
		    throw  ServiceSpaOnlineException.crear(mensajeUsuario);
		}

		if (UtilObjeto.esNulooVacio(domain.getCodigo())) {
			var mensajeUsuario= "El campo 'codigo' es obligatorio y no puede ser nulo o vacío";
			throw  ServiceSpaOnlineException.crear(mensajeUsuario);
		}

		if (domain.getNombre().length() > 255) {
			var mensajeUsuario= "El campo 'nombre' no puede tener más de 255 caracteres";
			throw  ServiceSpaOnlineException.crear(mensajeUsuario);
		}

		if (domain.getCodigo().length() > 10) {
			var mensajeUsuario= "El campo 'codigo' no puede tener más de 10 caracteres";
			throw  ServiceSpaOnlineException.crear(mensajeUsuario);
		    }

	}
	
	private void registrarNuevoTipoIdentificacion(final TipoIdentificacionDomain domain) {
		var entity = TipoIdentificacionEntityMapper.convertToEntity(domain);
		getTipoIdentificacionDAO().crear(entity);
		
	}
	
	private final void validarNoExistenciaTipoIdentificacionConMismoNombre(final String nombre) {

		var domain = TipoIdentificacionDomain.crear(null, null, nombre, false);
		var entity = TipoIdentificacionEntityMapper.convertToEntity(domain);
		var resultados = getTipoIdentificacionDAO().consultar(entity);
		
		if(resultados.isEmpty()) {
			var mensajeUsuario = " ya existe un tipo de identificacion con el nombre"+ nombre;
			throw ServiceSpaOnlineException.crear(mensajeUsuario);
		}
	}
	private final void validarNoExistenciaTipoIdentificacionConMismoNombrePorMi(final String nombre) {
		TipoIdentificacionEntity entity = convertirTipoIdentificacionDomainAEntity(nombre);
	    List<TipoIdentificacionEntity> resultados = getTipoIdentificacionDAO().consultar(entity);

		if(resultados.isEmpty()) {
			lanzarExcepcionTipoIdentificacionExistentePorNombre(nombre);
		}
	}
	private final void validarNoExistenciaTipoIdentificacionConMismoCodigo(final String codigo) {
		var domain = TipoIdentificacionDomain.crear(null, codigo, null, false);
		var entity = TipoIdentificacionEntityMapper.convertToEntity(domain);
		var resultados = getTipoIdentificacionDAO().consultar(entity);
		
		if(resultados.isEmpty()) {
			var mensajeUsuario = " ya existe un tipo de identificacion con el mismo codigo"+ codigo;
			throw ServiceSpaOnlineException.crear(mensajeUsuario);
		}
	}
	private final void validarNoExistenciaTipoIdentificacionConMismoCodigoPorMi(final String codigo) {
		TipoIdentificacionEntity entity = convertirTipoIdentificacionDomainAEntity(codigo);
	    List<TipoIdentificacionEntity> resultados = getTipoIdentificacionDAO().consultar(entity);

		if(resultados.isEmpty()) {
			lanzarExcepcionTipoIdentificacionExistente(codigo);
		}
	}
	
	private final TipoIdentificacionDomain obtenerTipoIdentificacionDomain(TipoIdentificacionDomain domain) {
		
		Optional<TipoIdentificacionEntity> optional ;
		UUID uuid;
		do {
			uuid= UUID.randomUUID();			
			optional = getTipoIdentificacionDAO().consultarPorId(uuid);
			
		}while(!optional.isEmpty());
			
		return TipoIdentificacionDomain.crear(uuid, domain.getCodigo(),domain.getNombre(),domain.isEstado());
				}
	private final DAOFactory getFactoria() {
		return factoria;
	}
	
	private final void setFactoria(final DAOFactory factoria) {
		if(UtilObjeto.esNulo(factoria)) {
			var mensajeUsuario= CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000068);
			var mensajeTecnico= CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000069);
			 throw ServiceSpaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		this.factoria = factoria;
	}
	
	private final TipoIdentificacionDAO getTipoIdentificacionDAO() {
		return getFactoria().obtenerTipoIdentificacionDAO();
	}
	//Creada para mejorar 
	private TipoIdentificacionEntity convertirTipoIdentificacionDomainAEntity(String codigo) {
	    TipoIdentificacionDomain domain = TipoIdentificacionDomain.crear(null, codigo, null, false);
	    return TipoIdentificacionEntityMapper.convertToEntity(domain);
	}

	private void lanzarExcepcionTipoIdentificacionExistente(String codigo) {
	    String mensajeUsuario = "Ya existe un tipo de identificación con el mismo código: " + codigo;
	    throw ServiceSpaOnlineException.crear(mensajeUsuario);
	}
	private void lanzarExcepcionTipoIdentificacionExistentePorNombre(String nombre) {
	    String mensajeUsuario = "Ya existe un tipo de identificación con el mismo nombre: " + nombre;
	    throw ServiceSpaOnlineException.crear(mensajeUsuario);
	}

}
