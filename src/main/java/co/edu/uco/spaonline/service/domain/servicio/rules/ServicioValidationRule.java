package co.edu.uco.spaonline.service.domain.servicio.rules;

import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.service.domain.ValidationRule;
import co.edu.uco.spaonline.service.domain.servicio.ServicioDomain;

public class ServicioValidationRule implements ValidationRule<ServicioDomain> {
	private static final ValidationRule<ServicioDomain> instancia = new ServicioValidationRule();
	
	private ServicioValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final ServicioDomain dato) {
		instancia.validar(dato);
	}

	@Override
	public void validar(ServicioDomain dato) {
		if(UtilObjeto.esNulo(dato)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000015);
			throw ServiceSpaOnlineException.crear(mensajeUsuario);
		}
	}
	
}
