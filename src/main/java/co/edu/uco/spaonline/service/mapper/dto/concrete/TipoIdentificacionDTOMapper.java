package co.edu.uco.spaonline.service.mapper.dto.concrete;

import co.edu.uco.spaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.spaonline.service.dto.TipoIdentificacionDTO;
import co.edu.uco.spaonline.service.mapper.dto.DTOMapper;
import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;

public class TipoIdentificacionDTOMapper implements DTOMapper <TipoIdentificacionDTO, TipoIdentificacionDomain>{

	
	private static final DTOMapper<TipoIdentificacionDTO, TipoIdentificacionDomain> instancia = new TipoIdentificacionDTOMapper();
	
	private TipoIdentificacionDTOMapper() {
		super();
	}
	@Override
	public TipoIdentificacionDomain toDomain(TipoIdentificacionDTO dto) {
		if(UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000073);
			throw ServiceSpaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}	
		
		return TipoIdentificacionDomain.crear(dto.getId(), dto.getCodigo(), dto.getNombre(), dto.isEstado());
	}

	@Override
	public TipoIdentificacionDTO toDTO(TipoIdentificacionDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000071);
			throw ServiceSpaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}
		return TipoIdentificacionDTO.crear(domain.getId(), domain.getCodigo(), domain.getNombre(), domain.isEstado());
	}
	public static final TipoIdentificacionDomain convertToDomain(final TipoIdentificacionDTO dto) {
		return instancia.toDomain(dto);
	}
	public static final TipoIdentificacionDTO convertToDTO(final TipoIdentificacionDomain domain) {
		return instancia.toDTO(domain);
	}
	

}
