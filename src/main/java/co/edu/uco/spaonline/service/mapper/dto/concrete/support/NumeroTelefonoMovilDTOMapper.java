package co.edu.uco.spaonline.service.mapper.dto.concrete.support;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.service.domain.numerotelefonomovilcliente.NumeroTelefonoMovilClienteDomain;
import co.edu.uco.spaonline.service.dto.support.NumeroTelefonoMovilClienteDTO;
import co.edu.uco.spaonline.service.mapper.dto.DTOMapper;

public class NumeroTelefonoMovilDTOMapper implements DTOMapper<NumeroTelefonoMovilClienteDTO, NumeroTelefonoMovilClienteDomain> {
	private static final DTOMapper<NumeroTelefonoMovilClienteDTO, NumeroTelefonoMovilClienteDomain> instancia = new NumeroTelefonoMovilDTOMapper();
	
	private NumeroTelefonoMovilDTOMapper() {
		super();
	}
	
	@Override
	public NumeroTelefonoMovilClienteDomain toDomain(NumeroTelefonoMovilClienteDTO dto) {
		if(UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000014);
			throw ServiceSpaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		return NumeroTelefonoMovilClienteDomain.crear(dto.getNumeroTelefonoMovil(), BooleanDTOMapper.convertToDomain(dto.isNumeroTelefonoMovilConfirmado()));
	}

	@Override
	public NumeroTelefonoMovilClienteDTO toDTO(NumeroTelefonoMovilClienteDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000014);
			throw ServiceSpaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		return NumeroTelefonoMovilClienteDTO.crear()
				.setNumeroTelefonoMovil(domain.getNumeroTelefonoMovil())
				.setNumeroTelefonoMovilConfirmado(BooleanDTOMapper.convertToDTO(domain.isNumeroTelefonoMovilConfirmado()));
	}
	
	public static final NumeroTelefonoMovilClienteDomain convertToDomain(final NumeroTelefonoMovilClienteDTO dto) {		 
		return instancia.toDomain(dto);
	}
	
	public static final NumeroTelefonoMovilClienteDTO convertToDTO(final NumeroTelefonoMovilClienteDomain domain) {
		return instancia.toDTO(domain);
	}
	
	public static final List<NumeroTelefonoMovilClienteDTO>  convertToListDTO(final List<NumeroTelefonoMovilClienteDomain> dto){
		List<NumeroTelefonoMovilClienteDTO> resultados = new ArrayList<>();
		for (int i = 0; i < dto.size(); i++) {
			resultados.add(convertToDTO(dto.get(i)));
		}
		
		return resultados;
	}

}
