package co.edu.uco.spaonline.service.mapper.entity.concrete.support;


import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.data.entity.support.CorreoElectronicoClienteEntity;
import co.edu.uco.spaonline.service.domain.support.CorreoElectronicoClienteDomain;
import co.edu.uco.spaonline.service.mapper.entity.EntityMapper;

public class CorreoElectronicoClienteEntityMapper implements EntityMapper <CorreoElectronicoClienteEntity, CorreoElectronicoClienteDomain> {
private static final EntityMapper<CorreoElectronicoClienteEntity, CorreoElectronicoClienteDomain> instancia = new CorreoElectronicoClienteEntityMapper();

private CorreoElectronicoClienteEntityMapper() {
	super();
}
@Override
public CorreoElectronicoClienteDomain toDomain(CorreoElectronicoClienteEntity entity) {
	if(UtilObjeto.esNulo(entity)) {
		var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
		var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000070);
		throw ServiceSpaOnlineException.crear(mensajeUsuario,mensajeTecnico);
	}	
	
	return CorreoElectronicoClienteDomain.crear(entity.getCorreoElectronico(),entity.isCorreoElectronicoConfirmado());

}

@Override
public CorreoElectronicoClienteEntity toEntity(CorreoElectronicoClienteDomain domain) {
	if(UtilObjeto.esNulo(domain)) {
		var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
		var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000071);
		throw ServiceSpaOnlineException.crear(mensajeUsuario,mensajeTecnico);
	}
	return CorreoElectronicoClienteEntity.crear(domain.getCorreoElectronico(),domain.isCorreoElectronicoConfirmado());
}
public static final CorreoElectronicoClienteDomain
convertToDomain(final CorreoElectronicoClienteEntity entity) {
	return instancia.toDomain(entity);
	}
public static final CorreoElectronicoClienteEntity
convertToEntity(final CorreoElectronicoClienteDomain domain) {
	return instancia.toEntity(domain);
}
}
