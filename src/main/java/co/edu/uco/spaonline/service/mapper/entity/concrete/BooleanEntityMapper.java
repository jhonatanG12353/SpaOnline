package co.edu.uco.spaonline.service.mapper.entity.concrete;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.data.entity.support.BooleanEntity;
import co.edu.uco.spaonline.service.domain.support.BooleanDomain;
import co.edu.uco.spaonline.service.mapper.entity.EntityMapper;

public class BooleanEntityMapper implements EntityMapper<BooleanEntity, BooleanDomain> {

	private static final EntityMapper<BooleanEntity, BooleanDomain> instancia = new BooleanEntityMapper();
	
	private BooleanEntityMapper() {
		super();
	}
	
	@Override
	public final BooleanDomain toDomain(final BooleanEntity entity) {
		if(UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000013);
			throw ServiceSpaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		 
		return BooleanDomain.crear(entity.isValor(), entity.isValorDefecto());
	}

	@Override
	public final BooleanEntity toEntity(final BooleanDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000013);
			throw ServiceSpaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		return BooleanEntity.crear(domain.isValor(), domain.isValorDefecto());
	}

	public static final BooleanDomain convertToDomain(final BooleanEntity entity) {		 
		return instancia.toDomain(entity);
	}
	
	public static final BooleanEntity convertToEntity(final BooleanDomain domain) {
		return instancia.toEntity(domain);
	}
	
	public static final List<BooleanDomain>  convertToListDomain(final List<BooleanEntity> entity){
		List<BooleanDomain> resultados = new ArrayList<>();
		for (int i = 0; i < entity.size(); i++) {
			resultados.add(convertToDomain(entity.get(i)));
		}
		return resultados;
	}

}
