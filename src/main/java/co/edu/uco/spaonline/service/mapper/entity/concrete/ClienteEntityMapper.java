package co.edu.uco.spaonline.service.mapper.entity.concrete;


import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;

import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.data.entity.ClienteEntity;
import co.edu.uco.spaonline.service.domain.ClienteDomain;
import co.edu.uco.spaonline.service.mapper.entity.EntityMapper;

public class ClienteEntityMapper implements EntityMapper<ClienteEntity, ClienteDomain>  {
	
	private static final EntityMapper<ClienteEntity, ClienteDomain> instancia = new ClienteEntityMapper();
	
	private ClienteEntityMapper() {
		super();
	}
	@Override
	public ClienteDomain toDomain(ClienteEntity entity) {
		if(UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000070);
			throw ServiceSpaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}	
		
		return ClienteDomain.crear(entity.getId(), entity.getTipoIdentificacion(),entity.getIdentificacion(), entity.getNombreCompleto(),
				entity.getCorreoElectronico(), entity.getNumeroTelefonoMovil());
	}

	
	@Override
	public ClienteEntity toEntity(ClienteDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000071);
			throw ServiceSpaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}
		return ClienteEntity.crear(domain.getId(), domain.getTipoIdentificacion(),domain.getIdentificacion(), domain.getNombreCompleto(),
				domain.getCorreoElectronico(), domain.getNumeroTelefonoMovil());
	}
	
	public static final ClienteDomain
	convertToDomain(final ClienteEntity entity) {
		return instancia.toDomain(entity);
	}
	public static final ClienteEntity
	convertToEntity(final ClienteDomain domain) {
		return instancia.toEntity(domain);
	}

}
