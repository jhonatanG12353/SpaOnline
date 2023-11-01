package co.edu.uco.spaonline.service.mapper.dto.concrete.support;

import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.service.domain.support.CorreoElectronicoClienteDomain;
import co.edu.uco.spaonline.service.dto.support.CorreoElectronicoClienteDTO;
import co.edu.uco.spaonline.service.mapper.dto.DTOMapper;

public class CorreoElectronicoClienteDTOMapper implements DTOMapper <CorreoElectronicoClienteDTO, CorreoElectronicoClienteDomain>{
	
	private static final DTOMapper<CorreoElectronicoClienteDTO, CorreoElectronicoClienteDomain> instancia = new CorreoElectronicoClienteDTOMapper();
	
	private CorreoElectronicoClienteDTOMapper() {
		super();
	}

	@Override
	public CorreoElectronicoClienteDomain toDomain(CorreoElectronicoClienteDTO dto) {
		if(UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000073);
			throw ServiceSpaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}	
		
		return CorreoElectronicoClienteDomain.crear(dto.getCorreoElectronico(),dto.isCorreoElectronicoConfirmado());
	
	}

	@Override
	public CorreoElectronicoClienteDTO toDTO(CorreoElectronicoClienteDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000071);
			throw ServiceSpaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}
		return CorreoElectronicoClienteDTO.crear(domain.getCorreoElectronico(),domain.isCorreoElectronicoConfirmado());
	}
	public static final CorreoElectronicoClienteDomain convertToDomain(final CorreoElectronicoClienteDTO dto) {
		return instancia.toDomain(dto);
	}
	public static final CorreoElectronicoClienteDTO convertToDTO(final CorreoElectronicoClienteDomain domain) {
		return instancia.toDTO(domain);
	}
}
