package co.edu.uco.spaonline.service.domain.correoelectronicocliente.rules;

import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.service.domain.ValidationRule;
import co.edu.uco.spaonline.service.domain.correoelectronicocliente.CorreoElectronicoClienteDomain;

public class CorreoElectronicoValidationRule implements ValidationRule<CorreoElectronicoClienteDomain> {
	private static final ValidationRule<CorreoElectronicoClienteDomain> instancia = new CorreoElectronicoValidationRule();
	
	private CorreoElectronicoValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final CorreoElectronicoClienteDomain dato) {
		instancia.validar(dato);
	}

	@Override
	public void validar(CorreoElectronicoClienteDomain dato) {
		if(UtilObjeto.esNulo(dato)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000015);
			throw ServiceSpaOnlineException.crear(mensajeUsuario);
		}
	}

}
