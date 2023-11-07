package co.edu.uco.spaonline.service.mapper.entity.concrete.support;

import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.data.entity.support.NombreCompletoClienteEntity;
import co.edu.uco.spaonline.service.domain.nombrecompletocliente.NombreCompletoClienteDomain;
import co.edu.uco.spaonline.service.mapper.entity.EntityMapper;

public class NombreCompletoClienteEntityMapper implements EntityMapper<NombreCompletoClienteEntity, NombreCompletoClienteDomain> {

	private static final EntityMapper<NombreCompletoClienteEntity, NombreCompletoClienteDomain> instancia = new NombreCompletoClienteEntityMapper();
	
	private NombreCompletoClienteEntityMapper() {
		super();
	}
	
	@Override
	public final NombreCompletoClienteDomain toDomain(final NombreCompletoClienteEntity entity) {
		if(UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000082);
			throw ServiceSpaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		 
		return NombreCompletoClienteDomain.crear(entity.getPrimerNombre(), entity.getSegundoNombre(), entity.getPrimerApellido(), entity.getSegundoApellido());
	}

	@Override
	public final NombreCompletoClienteEntity toEntity(final NombreCompletoClienteDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000083);
			throw ServiceSpaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		return NombreCompletoClienteEntity.crear(domain.getPrimerNombre(), domain.getSegundoNombre(), domain.getPrimerApellido(), domain.getSegundoApellido());
	}

	public static final NombreCompletoClienteDomain convertToDomain(final NombreCompletoClienteEntity entity) {		 
		return instancia.toDomain(entity);
	}
	
	public static final NombreCompletoClienteEntity convertToEntity(final NombreCompletoClienteDomain domain) {
		return instancia.toEntity(domain);
	}
	
}
