package co.edu.uco.spaonline.service.domain.nombrecompletocliente.rules;

import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.service.domain.ValidationRule;
import co.edu.uco.spaonline.service.domain.nombrecompletocliente.NombreCompletoClienteDomain;

public class NombreCompletoValidationRule implements ValidationRule<NombreCompletoClienteDomain> {
	private static final ValidationRule<NombreCompletoClienteDomain> instancia = new NombreCompletoValidationRule();
	
	private NombreCompletoValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final NombreCompletoClienteDomain dato) {
		instancia.validar(dato);
	}

	@Override
	public void validar(NombreCompletoClienteDomain dato) {
		if(UtilObjeto.esNulo(dato)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000058);
			throw ServiceSpaOnlineException.crear(mensajeUsuario);
		}
	}
	
}
