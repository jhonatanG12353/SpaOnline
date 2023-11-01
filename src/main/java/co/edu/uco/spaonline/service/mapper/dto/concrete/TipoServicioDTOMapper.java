package co.edu.uco.spaonline.service.mapper.dto.concrete;

import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.service.domain.tiposervicio.TipoServicioDomain;
import co.edu.uco.spaonline.service.dto.TipoServicioDTO;
import co.edu.uco.spaonline.service.mapper.dto.DTOMapper;

public class TipoServicioDTOMapper implements DTOMapper<TipoServicioDTO, TipoServicioDomain> {
	
	private static final DTOMapper<TipoServicioDTO, TipoServicioDomain> instancia = new TipoServicioDTOMapper();

	@Override
	public TipoServicioDomain toDomain(TipoServicioDTO dto) {
		if(UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000070);
			throw ServiceSpaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}	
		
		return TipoServicioDomain.crear(dto.getId(), dto.getNombreTipoServicio());
	}
	
	@Override
	public TipoServicioDTO toDTO(TipoServicioDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000071);
			throw ServiceSpaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}
		return TipoServicioDTO.crear(domain.getId(), domain.getNombreTipoServicio());
	}
	
	public static final TipoServicioDomain convertToDomain(final TipoServicioDTO dto) {
		return instancia.toDomain(dto);
	}
	public static final TipoServicioDTO convertToDTO(final TipoServicioDomain domain) {
		return instancia.toDTO(domain);
	}

}
