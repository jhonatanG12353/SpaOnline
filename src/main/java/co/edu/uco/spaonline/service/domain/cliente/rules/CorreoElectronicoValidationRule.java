package co.edu.uco.spaonline.service.domain.cliente.rules;

import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.service.domain.ValidationRule;
import co.edu.uco.spaonline.service.domain.support.CorreoElectronicoClienteDomain;

public class CorreoElectronicoValidationRule implements ValidationRule <CorreoElectronicoClienteDomain>{

	private static final ValidationRule<CorreoElectronicoClienteDomain> instancia = new CorreoElectronicoValidationRule();
	
	private CorreoElectronicoValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final CorreoElectronicoClienteDomain dato) {
		instancia.validar(dato);
	}
	
	@Override
	public void validar(CorreoElectronicoClienteDomain dato) {
		ValidarObligatoriedad(dato);
	
	}
	private final void ValidarObligatoriedad(final CorreoElectronicoClienteDomain dato) {
		if(UtilObjeto.esNulooVacio(dato)) {
			var mensajeUsuario = "El correo no puede estar vacio";
			throw ServiceSpaOnlineException.crear(mensajeUsuario);
		}
	}

}
