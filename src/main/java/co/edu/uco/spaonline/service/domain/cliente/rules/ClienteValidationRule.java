package co.edu.uco.spaonline.service.domain.cliente.rules;

import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.service.domain.ValidationRule;
import co.edu.uco.spaonline.service.domain.cliente.ClienteDomain;

public class ClienteValidationRule implements ValidationRule<ClienteDomain> {
	private static final ValidationRule<ClienteDomain> instancia = new ClienteValidationRule();
	
	private ClienteValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final ClienteDomain dato) {
		instancia.validar(dato);
	}

	@Override
	public void validar(ClienteDomain dato) {
		if(UtilObjeto.esNulo(dato)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000015);
			throw ServiceSpaOnlineException.crear(mensajeUsuario);
		}
	}
}
