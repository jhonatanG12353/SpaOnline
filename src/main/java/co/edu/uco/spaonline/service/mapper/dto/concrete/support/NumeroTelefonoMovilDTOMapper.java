package co.edu.uco.spaonline.service.mapper.dto.concrete.support;

import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.service.domain.support.NumeroTelefonoMovilClienteDomain;
import co.edu.uco.spaonline.service.dto.support.NumeroTelefonoMovilClienteDTO;
import co.edu.uco.spaonline.service.mapper.dto.DTOMapper;

public class NumeroTelefonoMovilDTOMapper implements DTOMapper <NumeroTelefonoMovilClienteDTO, NumeroTelefonoMovilClienteDomain>{
	
	private NumeroTelefonoMovilDTOMapper() {
		super();
	}

	@Override
	public NumeroTelefonoMovilClienteDomain toDomain(NumeroTelefonoMovilClienteDTO dto) {
		if(UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000070);
			throw ServiceSpaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}			
		return NumeroTelefonoMovilClienteDomain.crear(dto.getNumeroTelefonoMovil(), dto.isNumeroTelefonoConfirmado());
	}

	@Override
	public NumeroTelefonoMovilClienteDTO toDTO(NumeroTelefonoMovilClienteDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000071);
			throw ServiceSpaOnlineException.crear(mensajeUsuario,mensajeTecnico);
		}
		return NumeroTelefonoMovilClienteDTO.crear(domain.getNumeroTelefonoMovil(), domain.isNumeroTelefonoConfirmado());
	}

}
