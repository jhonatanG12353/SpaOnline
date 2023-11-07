package co.edu.uco.spaonline.service.domain.cliente.rules;

import java.sql.Date;

import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.util.UtilFechaDefecto;
import co.edu.uco.spaonline.service.domain.ValidationRule;

public class FechaNacimientoClienteValidationRule implements ValidationRule<Date> {
	private static final ValidationRule<Date> instancia = new FechaNacimientoClienteValidationRule();
	
	private FechaNacimientoClienteValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final Date dato) {
		instancia.validar(dato);
	}

	@Override
	public void validar(Date dato) {
		validarObligatoriedad(dato);
	}
	
	private final void validarObligatoriedad(final Date dato) {
		if(UtilFechaDefecto.esNulo(dato)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000016);
			throw ServiceSpaOnlineException.crear(mensajeUsuario);
		}
	}

}
