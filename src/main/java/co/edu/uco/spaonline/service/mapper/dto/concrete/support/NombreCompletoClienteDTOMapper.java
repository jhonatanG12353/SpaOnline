package co.edu.uco.spaonline.service.mapper.dto.concrete.support;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.service.domain.nombrecompletocliente.NombreCompletoClienteDomain;
import co.edu.uco.spaonline.service.dto.support.NombreCompletoClienteDTO;
import co.edu.uco.spaonline.service.mapper.dto.DTOMapper;

public class NombreCompletoClienteDTOMapper implements DTOMapper<NombreCompletoClienteDTO, NombreCompletoClienteDomain> {
	private static final DTOMapper<NombreCompletoClienteDTO, NombreCompletoClienteDomain> instancia = new NombreCompletoClienteDTOMapper();
	
	private NombreCompletoClienteDTOMapper() {
		super();
	}
	
	@Override
	public NombreCompletoClienteDomain toDomain(NombreCompletoClienteDTO dto) {
		if(UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000014);
			throw ServiceSpaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		return NombreCompletoClienteDomain.crear(dto.getPrimerNombre(), dto.getSegundoNombre(), dto.getPrimerApellido(), dto.getSegundoApellido());
	}

	@Override
	public NombreCompletoClienteDTO toDTO(NombreCompletoClienteDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000014);
			throw ServiceSpaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		
				String primerNombre = domain.getPrimerNombre();
				String segundoNombre =domain.getSegundoNombre();
				String primerApellido = domain.getPrimerApellido();
				String segundoApellido = domain.getSegundoApellido();
				return NombreCompletoClienteDTO.crear(primerNombre,segundoNombre,primerApellido,segundoApellido);
	}
	
	public static final NombreCompletoClienteDomain convertToDomain(final NombreCompletoClienteDTO dto) {		 
		return instancia.toDomain(dto);
	}
	
	public static final NombreCompletoClienteDTO convertToDTO(final NombreCompletoClienteDomain domain) {
		return instancia.toDTO(domain);
	}
	
	public static final List<NombreCompletoClienteDTO>  convertToListDTO(final List<NombreCompletoClienteDomain> dto){
		List<NombreCompletoClienteDTO> resultados = new ArrayList<>();
		for (int i = 0; i < dto.size(); i++) {
			resultados.add(convertToDTO(dto.get(i)));
		}
		
		return resultados;
	}

}
