package co.edu.uco.spaonline.service.domain.cliente.rules;

import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.util.UtilTexto;
import co.edu.uco.spaonline.service.domain.ValidationRule;

public class identificacionValidationRule implements ValidationRule <String>{

	private static final ValidationRule<String> instancia = new identificacionValidationRule();
	
	private identificacionValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final String dato) {
		instancia.validar(dato);
	}
	
	@Override
	public void validar(String dato) {
		validarLongitud(dato);
		validarObligatoriedad(dato);
		validarFormato(dato);
		
	}
	
	private final void validarLongitud(final String dato) {
		if(UtilTexto.longitudMaximaValida(dato,70)) {
			var mensajeUsuario = "La longitud del nombre completo no es valida. la longitud Maxima son 70 caracteres";
			throw ServiceSpaOnlineException.crear(mensajeUsuario);
		}
	}
	private final void validarObligatoriedad(final String dato) {
		if(UtilTexto.estaVacio(dato)) {
			var mensajeUsuario = "La longitud del nombre completo no es valida, es un dato de tipo obligatorio...";
			throw ServiceSpaOnlineException.crear(mensajeUsuario);
		}
	}
	private final void validarFormato(final String dato) {
		if(!UtilTexto.contieneSoloLetras(dato)) {
			var mensajeUsuario = "El nombre completo solo puede contener letras...";
			throw ServiceSpaOnlineException.crear(mensajeUsuario);
		}
	}

}
