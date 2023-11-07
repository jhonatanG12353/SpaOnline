package co.edu.uco.spaonline.service.mapper.entity.concrete;


import java.util.ArrayList;
import java.util.List;

import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;

import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.data.entity.ClienteEntity;
import co.edu.uco.spaonline.service.domain.cliente.ClienteDomain;
import co.edu.uco.spaonline.service.mapper.entity.EntityMapper;
import co.edu.uco.spaonline.service.mapper.entity.concrete.support.CorreoElectronicoClienteEntityMapper;
import co.edu.uco.spaonline.service.mapper.entity.concrete.support.NombreCompletoClienteEntityMapper;
import co.edu.uco.spaonline.service.mapper.entity.concrete.support.NumeroTelefonoMovilClienteEntityMapper;

public class ClienteEntityMapper implements EntityMapper<ClienteEntity, ClienteDomain> {

	private static final EntityMapper<ClienteEntity, ClienteDomain> instancia = new ClienteEntityMapper();
	
	private ClienteEntityMapper() {
		super();
	}
	
	@Override
	public final ClienteDomain toDomain(final ClienteEntity entity) {
		if(UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000074);
			throw ServiceSpaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		 
		return ClienteDomain.crear(
				entity.getId(),
				TipoIdentificacionEntityMapper.convertToDomain(entity.getTipoIdentificacion()),
				entity.getIdentificacion(),
				NombreCompletoClienteEntityMapper.convertToDomain(entity.getNombreCompleto()),
				CorreoElectronicoClienteEntityMapper.convertToDomain(entity.getCorreoElectronico()),
				NumeroTelefonoMovilClienteEntityMapper.convertToDomain(entity.getNumeroTelefonoMovil()),
				entity.getFechaNacimiento()
				);
	}

	@Override
	public final ClienteEntity toEntity(final ClienteDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000075);
			throw ServiceSpaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		return ClienteEntity.crear(
				domain.getId(),
				TipoIdentificacionEntityMapper.convertToEntity(domain.getTipoIdentificacion()),
				domain.getIdentificacion(),
				NombreCompletoClienteEntityMapper.convertToEntity(domain.getNombreCompleto()),
				CorreoElectronicoClienteEntityMapper.convertToEntity(domain.getCorreoElectronico()),
				NumeroTelefonoMovilClienteEntityMapper.convertToEntity(domain.getNumeroTelefonoMovil()),
				domain.getFechaNacimiento()
				);
	}

	public static final ClienteDomain convertToDomain(final ClienteEntity entity) {		 
		return instancia.toDomain(entity);
	}
	
	public static final ClienteEntity convertToEntity(final ClienteDomain domain) {
		return instancia.toEntity(domain);
	}
	
	public static final List<ClienteDomain>  convertToListDomain(final List<ClienteEntity> entity){
		List<ClienteDomain> resultados = new ArrayList<>();
		for (int i = 0; i < entity.size(); i++) {
			resultados.add(convertToDomain(entity.get(i)));
		}
		
		return resultados;
	}

}
