package co.edu.uco.spaonline.service.mapper.dto.concrete.support;

import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.service.domain.informacionservicio.InformacionServicioDomain;
import co.edu.uco.spaonline.service.dto.support.InformacionServicioDTO;
import co.edu.uco.spaonline.service.mapper.dto.DTOMapper;

public class InformacionServicioDTOMapper implements DTOMapper  <InformacionServicioDTO, InformacionServicioDomain>{
	
	private static final DTOMapper <InformacionServicioDTO, InformacionServicioDomain> instancia = new InformacionServicioDTOMapper ();
	
	private InformacionServicioDTOMapper () {
		super();
	}

	@Override
	public InformacionServicioDomain toDomain(InformacionServicioDTO dto) {
		if(UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000070);
			throw ServiceSpaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}	
		
		return InformacionServicioDomain.crear(dto.getNombreServicio(),dto.getDescripcionServicio());
	}

	@Override
	public InformacionServicioDTO toDTO(InformacionServicioDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000071);
			throw ServiceSpaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}
		return InformacionServicioDTO.crear(domain.getNombreServicio(),domain.getDescripcionServicio());
	}
	
	public static final InformacionServicioDomain
	convertToDomain(final InformacionServicioDTO entity) {
		return instancia.toDomain(entity);
	}
	public static final InformacionServicioDTO
	convertToEntity(final InformacionServicioDomain domain) {
		return instancia.toDTO(domain);
	}




}
