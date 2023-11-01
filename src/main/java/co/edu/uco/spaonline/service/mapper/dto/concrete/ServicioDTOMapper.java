package co.edu.uco.spaonline.service.mapper.dto.concrete;


import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.service.domain.servicio.ServicioDomain;
import co.edu.uco.spaonline.service.dto.ServicioDTO;
import co.edu.uco.spaonline.service.mapper.dto.DTOMapper;

public class ServicioDTOMapper implements DTOMapper<ServicioDTO, ServicioDomain> {
	
	private static final DTOMapper<ServicioDTO, ServicioDomain> instancia = new ServicioDTOMapper();

	@Override
	public ServicioDomain toDomain(ServicioDTO dto) {
		if(UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000070);
			throw ServiceSpaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}	
		
		return ServicioDomain.crear2(dto.getId(), dto.getTipoServicio(),dto.getInformacionServicio(), dto.getPrecio(), dto.getDuracionHoraServicio());
	}

	@Override
	public ServicioDTO toDTO (ServicioDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000071);
			throw ServiceSpaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}
		return ServicioDTO.crear(domain.getId(), domain.getTipoServicio(), domain.getInformacionServicio(), domain.getPrecio(), domain.getDuracionHoraServicio());
	}

	public static final ServicioDomain
	convertToDomain(final ServicioDTO dto) {
		return instancia.toDomain(dto);
	}
	public static final ServicioDTO
	convertToEntity(final ServicioDomain domain) {
		return instancia.toDTO(domain);
	}

}
