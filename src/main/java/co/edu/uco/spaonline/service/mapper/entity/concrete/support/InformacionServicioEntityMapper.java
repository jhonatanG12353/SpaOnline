package co.edu.uco.spaonline.service.mapper.entity.concrete.support;

import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.data.entity.support.InformacionServicioEntity;
import co.edu.uco.spaonline.service.domain.informacionservicio.InformacionServicioDomain;
import co.edu.uco.spaonline.service.mapper.entity.EntityMapper;

public class InformacionServicioEntityMapper implements EntityMapper  <InformacionServicioEntity, InformacionServicioDomain>{
	
	private static final EntityMapper <InformacionServicioEntity, InformacionServicioDomain> instancia = new InformacionServicioEntityMapper ();
	
	private InformacionServicioEntityMapper () {
		super();
	}

	@Override
	public InformacionServicioDomain toDomain(InformacionServicioEntity entity) {
		if(UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000070);
			throw ServiceSpaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}	
		
		return InformacionServicioDomain.crear(entity.getNombreServicio(),entity.getDescripcionServicio());

	}

	@Override
	public InformacionServicioEntity toEntity(InformacionServicioDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000071);
			throw ServiceSpaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}
		return InformacionServicioEntity.crear(domain.getNombreServicio(),domain.getDescripcionServicio());
	}
	public static final InformacionServicioDomain
	convertToDomain(final InformacionServicioEntity entity) {
		return instancia.toDomain(entity);
	}
	public static final InformacionServicioEntity
	convertToEntity(final InformacionServicioDomain domain) {
		return instancia.toEntity(domain);
	}

}
