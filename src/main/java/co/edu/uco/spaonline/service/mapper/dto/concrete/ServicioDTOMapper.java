package co.edu.uco.spaonline.service.mapper.dto.concrete;


import java.util.ArrayList;
import java.util.List;

import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.service.domain.servicio.ServicioDomain;
import co.edu.uco.spaonline.service.dto.ServicioDTO;
import co.edu.uco.spaonline.service.mapper.dto.DTOMapper;
import co.edu.uco.spaonline.service.mapper.dto.concrete.support.InformacionServicioDTOMapper;

public class ServicioDTOMapper implements DTOMapper<ServicioDTO, ServicioDomain> {
	
	private static final DTOMapper<ServicioDTO, ServicioDomain> instancia = new ServicioDTOMapper();
	
	private ServicioDTOMapper() {
		super();
	}
	

	public ServicioDomain toDomain(ServicioDTO dto) {
		if(UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000012);
			throw ServiceSpaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		return ServicioDomain.crear(
				dto.getId(),
				TipoServicioDTOMapper.convertToDomain(dto.getTipoServicio()),
				InformacionServicioDTOMapper.convertToDomain(dto.getInformacionServicio()),
				(dto.getPrecio()),(dto.getDuracionHoraServicio()));
	}

	@Override
	public ServicioDTO toDTO(ServicioDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000012);
			throw ServiceSpaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		return ServicioDTO.crear()
				.setId(domain.getId()).setTipoServicio(TipoServicioDTOMapper.convertToDTO(domain.getTipoServicio()));

				
				
	}
	
	public static final ServicioDomain convertToDomain(final ServicioDTO dto) {		 
		return instancia.toDomain(dto);
	}
	
	public static final ServicioDTO convertToDTO(final ServicioDomain domain) {
		return instancia.toDTO(domain);
	}
	
	public static final List<ServicioDTO>  convertToListDTO(final List<ServicioDomain> dto){
		List<ServicioDTO> resultados = new ArrayList<>();
		for (int i = 0; i < dto.size(); i++) {
			resultados.add(convertToDTO(dto.get(i)));
		}
		
		return resultados;
	}

}
