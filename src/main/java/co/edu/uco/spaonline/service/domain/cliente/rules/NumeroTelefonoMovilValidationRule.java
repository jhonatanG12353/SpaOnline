package co.edu.uco.spaonline.service.domain.cliente.rules;

import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.service.domain.ValidationRule;
import co.edu.uco.spaonline.service.domain.support.NumeroTelefonoMovilClienteDomain;

public class NumeroTelefonoMovilValidationRule implements ValidationRule <NumeroTelefonoMovilClienteDomain>{

	private static final ValidationRule<NumeroTelefonoMovilClienteDomain> instancia = new NumeroTelefonoMovilValidationRule();
	
	private NumeroTelefonoMovilValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final NumeroTelefonoMovilClienteDomain dato) {
		instancia.validar(dato);
	}
	
	@Override
	public void validar(NumeroTelefonoMovilClienteDomain dato) {
		ValidarObligatoriedad(dato);
	
	}
	private final void ValidarObligatoriedad(final NumeroTelefonoMovilClienteDomain dato) {
		if(UtilObjeto.esNulooVacio(dato)) {
			var mensajeUsuario = "El Numero de telefono no puede estar vacio";
			throw ServiceSpaOnlineException.crear(mensajeUsuario);
		}
	}
}
