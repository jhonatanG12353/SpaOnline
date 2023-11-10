package co.edu.uco.spaonline.service.mapper.entity.concrete;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.data.entity.TipoServicioEntity;
import co.edu.uco.spaonline.service.domain.tiposervicio.TipoServicioDomain;
import co.edu.uco.spaonline.service.mapper.entity.EntityMapper;

public class TipoServicioEntityMapper implements EntityMapper<TipoServicioEntity, TipoServicioDomain> {
	private static final EntityMapper<TipoServicioEntity, TipoServicioDomain> instancia = new TipoServicioEntityMapper();

	@Override
	public TipoServicioDomain toDomain(TipoServicioEntity entity) {
		if(UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000070);
			throw ServiceSpaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}	
		
		return TipoServicioDomain.crear(entity.getId(), entity.getNombreTipoServicio());
	}

	@Override
	public TipoServicioEntity toEntity(TipoServicioDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000071);
			throw ServiceSpaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}
		return TipoServicioEntity.crear(domain.getId(), domain.getNombreTipoServicio());
	}
	public static final TipoServicioDomain
	convertToDomain(final TipoServicioEntity entity) {
		return instancia.toDomain(entity);
	}
	public static final TipoServicioEntity
	convertToEntity(final TipoServicioDomain domain) {
		return instancia.toEntity(domain);
	}
	public static final List<TipoServicioDomain>  convertToListDomain(final List<TipoServicioEntity> entity){
		List<TipoServicioDomain> resultados = new ArrayList<>();
		for (int i = 0; i < entity.size(); i++) {
			resultados.add(convertToDomain(entity.get(i)));
		}
		return resultados;
	}

}
