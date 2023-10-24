package co.edu.uco.spaonline.service.mapper.entity.concrete.support;


import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.data.entity.support.NumeroTelefonoMovilClienteEntity;
import co.edu.uco.spaonline.service.domain.support.NumeroTelefonoMovilClienteDomain;
import co.edu.uco.spaonline.service.mapper.entity.EntityMapper;


public class NumeroTelefonoMovilClienteEntityMapper implements EntityMapper<NumeroTelefonoMovilClienteEntity, NumeroTelefonoMovilClienteDomain> {
	
	private static final EntityMapper<NumeroTelefonoMovilClienteEntity, NumeroTelefonoMovilClienteDomain> instancia = new NumeroTelefonoMovilClienteEntityMapper();
	
	private NumeroTelefonoMovilClienteEntityMapper() {
		super();
	}
	@Override
	public NumeroTelefonoMovilClienteDomain toDomain(NumeroTelefonoMovilClienteEntity entity) {
		if(UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000070);
			throw ServiceSpaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}	
		
		return NumeroTelefonoMovilClienteDomain.crear(entity.getNumeroTelefonoMovil(), entity.isNumeroTelefonoConfirmado());

	}

	@Override
	public NumeroTelefonoMovilClienteEntity toEntity(NumeroTelefonoMovilClienteDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000071);
			throw ServiceSpaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}
		return NumeroTelefonoMovilClienteEntity.crear(domain.getNumeroTelefonoMovil(), domain.isNumeroTelefonoConfirmado());
	}
	
	public static final NumeroTelefonoMovilClienteDomain
	convertToDomain(final NumeroTelefonoMovilClienteEntity entity) {
		return instancia.toDomain(entity);
	}
	public static final NumeroTelefonoMovilClienteEntity
	convertToEntity(final NumeroTelefonoMovilClienteDomain domain) {
		return instancia.toEntity(domain);
	}

}
