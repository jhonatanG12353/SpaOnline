package co.edu.uco.spaonline.service.domain.servicio.rules;

import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.util.UtilNumero;
import co.edu.uco.spaonline.service.domain.ValidationRule;

public class DuracionHoraServicioValidationRule implements ValidationRule<Integer> {
	
	private static final ValidationRule<Integer> instancia = new DuracionHoraServicioValidationRule();

	private DuracionHoraServicioValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final Integer dato) {
		instancia.validar(dato);
	}
	
	@Override
	public void validar(Integer dato) {
		validarLongitud(dato);
		validarObligatoriedad(dato);
		
	}
	private final void validarLongitud(final Integer dato) {
		if(UtilNumero.longitudMaximaValida(dato,10)) {
			var mensajeUsuario = "La longitud del numero no es valida. la longitud Maxima son 10 caracteres";
			throw ServiceSpaOnlineException.crear(mensajeUsuario);
		}
	}
	
	private final void validarObligatoriedad(final Integer dato) {
		if(UtilNumero.longitudMinimaValida(dato, 0)) {
			var mensajeUsuario = "La longitud del codigo del tipo de identificacion es un dato de tipo obligatorio...";
			throw ServiceSpaOnlineException.crear(mensajeUsuario);
		}
	}

}
