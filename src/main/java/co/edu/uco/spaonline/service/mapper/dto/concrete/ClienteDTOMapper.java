package co.edu.uco.spaonline.service.mapper.dto.concrete;

import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.service.domain.ClienteDomain;
import co.edu.uco.spaonline.service.dto.ClienteDTO;
import co.edu.uco.spaonline.service.mapper.dto.DTOMapper;

public class ClienteDTOMapper implements DTOMapper <ClienteDTO, ClienteDomain> {
	private static final DTOMapper<ClienteDTO, ClienteDomain> instancia = new ClienteDTOMapper();
	
	private ClienteDTOMapper() {
		super();
	}
	@Override
	public ClienteDomain toDomain(ClienteDTO dto) {
		if(UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000070);
			throw ServiceSpaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}	
		
		return ClienteDomain.crear2(dto.getId(), dto.getTipoIdentificacion(),dto.getIdentificacion(), dto.getNombreCompleto(),
				dto.getCorreoElectronico(), dto.getNumeroTelefonoMovil());
	}

	@Override
	public ClienteDTO toDTO(ClienteDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000071);
			throw ServiceSpaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}
		return ClienteDTO.crear(domain.getId(), domain.getTipoIdentificacion(),domain.getIdentificacion(), domain.getNombreCompleto(),
				domain.getCorreoElectronico(), domain.getNumeroTelefonoMovil());
	}
	public static final ClienteDomain
	convertToDomain(final ClienteDTO dto) {
		return instancia.toDomain(dto);
	}
	public static final ClienteDTO
	convertToEntity(final ClienteDomain domain) {
		return instancia.toDTO(domain);
	}

}
