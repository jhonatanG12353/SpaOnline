package co.edu.uco.spaonline.service.mapper.entity.concrete;


import java.util.ArrayList;
import java.util.List;

import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.data.entity.ClienteEntity;
import co.edu.uco.spaonline.data.entity.ServicioEntity;
import co.edu.uco.spaonline.service.domain.cliente.ClienteDomain;
import co.edu.uco.spaonline.service.domain.servicio.ServicioDomain;
import co.edu.uco.spaonline.service.mapper.entity.EntityMapper;
import co.edu.uco.spaonline.service.mapper.entity.concrete.support.CorreoElectronicoClienteEntityMapper;
import co.edu.uco.spaonline.service.mapper.entity.concrete.support.InformacionServicioEntityMapper;
import co.edu.uco.spaonline.service.mapper.entity.concrete.support.NombreCompletoClienteEntityMapper;
import co.edu.uco.spaonline.service.mapper.entity.concrete.support.NumeroTelefonoMovilClienteEntityMapper;

public class ServicioEntityMapper implements EntityMapper<ServicioEntity, ServicioDomain> {
	
private static final EntityMapper<ServicioEntity, ServicioDomain> instancia = new ServicioEntityMapper();
	
	private ServicioEntityMapper() {
		super();
	}
	
	@Override
	public final ServicioDomain toDomain(final ServicioEntity entity) {
		if(UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000074);
			throw ServiceSpaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		 
		return ServicioDomain.crear(
				entity.getId(),
				TipoServicioEntityMapper.convertToDomain(entity.getTipoServicio()),
				InformacionServicioEntityMapper.convertToDomain(entity.getInformacionServicio()),
				entity.getPrecio(),entity.getDuracionHoraServicio()
				);
	}

	@Override
	public final ServicioEntity toEntity(final ServicioDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000075);
			throw ServiceSpaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		return ServicioEntity.crear(
				domain.getId(),
				TipoServicioEntityMapper.convertToEntity(domain.getTipoServicio()),
				InformacionServicioEntityMapper.convertToEntity(domain.getInformacionServicio()),
				domain.getPrecio(),domain.getDuracionHoraServicio()
				);
	}

	public static final ServicioDomain convertToDomain(final ServicioEntity entity) {		 
		return instancia.toDomain(entity);
	}
	
	public static final ServicioEntity convertToEntity(final ServicioDomain domain) {
		return instancia.toEntity(domain);
	}
	
	public static final List<ServicioDomain>  convertToListDomain(final List<ServicioEntity> entity){
		List<ServicioDomain> resultados = new ArrayList<>();
		for (int i = 0; i < entity.size(); i++) {
			resultados.add(convertToDomain(entity.get(i)));
		}
		
		return resultados;
	}

}
