package co.edu.uco.spaonline.service.mapper.dto.concrete.support;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.service.domain.support.BooleanDomain;
import co.edu.uco.spaonline.service.dto.support.BooleanDTO;
import co.edu.uco.spaonline.service.mapper.dto.DTOMapper;

public class BooleanDTOMapper implements DTOMapper<BooleanDTO, BooleanDomain> {
	private static final DTOMapper<BooleanDTO, BooleanDomain> instancia = new BooleanDTOMapper();
	
	private BooleanDTOMapper() {
		super();
	}
	
	@Override
	public BooleanDomain toDomain(BooleanDTO dto) {
		if(UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000013);
			throw ServiceSpaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		return BooleanDomain.crear(dto.isValor(), dto.isValorDefecto());
	}

	@Override
	public BooleanDTO toDTO(BooleanDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000013);
			throw ServiceSpaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		return BooleanDTO.crear()
				.setValor(domain.isValor())
				.setValorDefecto(domain.isValorDefecto());
	}
	
	public static final BooleanDomain convertToDomain(final BooleanDTO dto) {		 
		return instancia.toDomain(dto);
	}
	
	public static final BooleanDTO convertToDTO(final BooleanDomain domain) {
		return instancia.toDTO(domain);
	}
	
	public static final List<BooleanDTO>  convertToListDTO(final List<BooleanDomain> dto){
		List<BooleanDTO> resultados = new ArrayList<>();
		for (int i = 0; i < dto.size(); i++) {
			resultados.add(convertToDTO(dto.get(i)));
		}
		
		return resultados;
	}

}
