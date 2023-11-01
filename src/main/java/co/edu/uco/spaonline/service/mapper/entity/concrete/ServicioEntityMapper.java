package co.edu.uco.spaonline.service.mapper.entity.concrete;


import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.data.entity.ServicioEntity;
import co.edu.uco.spaonline.service.domain.servicio.ServicioDomain;
import co.edu.uco.spaonline.service.mapper.entity.EntityMapper;

public class ServicioEntityMapper implements EntityMapper<ServicioEntity, ServicioDomain> {
	
	private static final EntityMapper<ServicioEntity, ServicioDomain> instancia = new ServicioEntityMapper();

	@Override
	public ServicioDomain toDomain(ServicioEntity entity) {
		if(UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000070);
			throw ServiceSpaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}	
		
		return ServicioDomain.crear(entity.getId(), entity.getTipoServicio(), entity.getInformacionServicio(), entity.getPrecio(), entity.getDuracionHoraServicio());
	}

	@Override
	public ServicioEntity toEntity(ServicioDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000071);
			throw ServiceSpaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}
		return ServicioEntity.crear(domain.getId(), domain.getTipoServicio(), domain.getInformacionServicio(), domain.getPrecio(), domain.getDuracionHoraServicio());
	}

}
