package co.edu.uco.spaonline.service.mapper.dto.concrete;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.service.domain.cliente.ClienteDomain;
import co.edu.uco.spaonline.service.domain.correoelectronicocliente.CorreoElectronicoClienteDomain;
import co.edu.uco.spaonline.service.domain.nombrecompletocliente.NombreCompletoClienteDomain;
import co.edu.uco.spaonline.service.domain.numerotelefonomovilcliente.NumeroTelefonoMovilClienteDomain;
import co.edu.uco.spaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.spaonline.service.dto.ClienteDTO;
import co.edu.uco.spaonline.service.mapper.dto.DTOMapper;
import co.edu.uco.spaonline.service.mapper.dto.concrete.support.CorreoElectronicoClienteDTOMapper;
import co.edu.uco.spaonline.service.mapper.dto.concrete.support.NombreCompletoClienteDTOMapper;
import co.edu.uco.spaonline.service.mapper.dto.concrete.support.NumeroTelefonoMovilDTOMapper;

public class ClienteDTOMapper implements DTOMapper<ClienteDTO, ClienteDomain> {
	private static final DTOMapper<ClienteDTO, ClienteDomain> instancia = new ClienteDTOMapper();
	
	private ClienteDTOMapper() {
		super();
	}
	
	@Override
	public ClienteDomain toDomain(ClienteDTO dto) {
		if(UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000012);
			throw ServiceSpaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		return ClienteDomain.crear(
				dto.getId(),
				TipoIdentificacionDTOMapper.convertToDomain(dto.getTipoIdentificacion()),
				dto.getIdentificacion(),
				NombreCompletoClienteDTOMapper.convertToDomain(dto.getNombreCompleto()),
				CorreoElectronicoClienteDTOMapper.convertToDomain(dto.getCorreoElectronico()),
				NumeroTelefonoMovilDTOMapper.convertToDomain(dto.getNumeroTelefonoMovil()),
				dto.getFechaNacimiento()
				);
	}

	@Override
	public ClienteDTO toDTO(ClienteDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000012);
			throw ServiceSpaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		UUID id = domain.getId();
		TipoIdentificacionDomain tipoIdentificacion = domain.getTipoIdentificacion();
		String identificacion = domain.getIdentificacion();
		NombreCompletoClienteDomain nombreCompleto = domain.getNombreCompleto();
		CorreoElectronicoClienteDomain correoElectronico = domain.getCorreoElectronico();
		NumeroTelefonoMovilClienteDomain numeroTelefonoMovil = domain.getNumeroTelefonoMovil();

		return ClienteDTO.crear(id, tipoIdentificacion, identificacion, nombreCompleto, correoElectronico, numeroTelefonoMovil);
	}
	
	public static final ClienteDomain convertToDomain(final ClienteDTO dto) {		 
		return instancia.toDomain(dto);
	}
	
	public static final ClienteDTO convertToDTO(final ClienteDomain domain) {
		return instancia.toDTO(domain);
	}
	
	public static final List<ClienteDTO>  convertToListDTO(final List<ClienteDomain> dto){
		List<ClienteDTO> resultados = new ArrayList<>();
		for (int i = 0; i < dto.size(); i++) {
			resultados.add(convertToDTO(dto.get(i)));
		}
		
		return resultados;
	}

}
