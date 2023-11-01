package co.edu.uco.spaonline.service.mapper.dto.concrete.support;

import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.service.domain.support.NombreCompletoClienteDomain;
import co.edu.uco.spaonline.service.dto.support.NombreCompletoClienteDTO;
import co.edu.uco.spaonline.service.mapper.dto.DTOMapper;

public class NombreCompletoClienteDTOMapper implements DTOMapper <NombreCompletoClienteDTO, NombreCompletoClienteDomain>{
	
	private static final DTOMapper<NombreCompletoClienteDTO, NombreCompletoClienteDomain> instancia = new NombreCompletoClienteDTOMapper();

	@Override
	public NombreCompletoClienteDomain toDomain(NombreCompletoClienteDTO dto) {
		if(UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000070);
			throw ServiceSpaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}	
		
		return NombreCompletoClienteDomain.crear(dto.getPrimerNombre(), dto.getSegundoNombre(),
				dto.getPrimerApellido(), dto.getSegundoApellido());
	}

	@Override
	public NombreCompletoClienteDTO toDTO(NombreCompletoClienteDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000071);
			throw ServiceSpaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}
		return NombreCompletoClienteDTO.crear (domain.getPrimerNombre(), domain.getSegundoNombre(),
				domain.getPrimerApellido(), domain.getSegundoApellido());
	}
	
	public static final NombreCompletoClienteDomain convertToDomain(final NombreCompletoClienteDTO dto) {
		return instancia.toDomain(dto);
	}
	public static final NombreCompletoClienteDTO convertToDTO(final NombreCompletoClienteDomain domain) {
		return instancia.toDTO(domain);
	}

}
