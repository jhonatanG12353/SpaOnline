package co.edu.uco.spaonline.service.domain.numerotelefonomovilcliente.rules;

import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.service.domain.ValidationRule;
import co.edu.uco.spaonline.service.domain.numerotelefonomovilcliente.NumeroTelefonoMovilClienteDomain;

public class NumeroTelefonoMovilClienteValidationRule implements ValidationRule<NumeroTelefonoMovilClienteDomain> {
	private static final ValidationRule<NumeroTelefonoMovilClienteDomain> instancia = new NumeroTelefonoMovilClienteValidationRule();
	
	private NumeroTelefonoMovilClienteValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final NumeroTelefonoMovilClienteDomain dato) {
		instancia.validar(dato);
	}

	@Override
	public void validar(NumeroTelefonoMovilClienteDomain dato) {
		if(UtilObjeto.esNulo(dato)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000015);
			throw ServiceSpaOnlineException.crear(mensajeUsuario);
		}
	}

}
