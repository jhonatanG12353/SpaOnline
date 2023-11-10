package co.edu.uco.spaonline.service.domain.tiposervicio.rule;

import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.util.UtilTexto;
import co.edu.uco.spaonline.service.domain.ValidationRule;

public final class CodigoTipoServicioValidationRule implements ValidationRule <String>{

	private static final ValidationRule<String> instancia = new CodigoTipoServicioValidationRule();
	
	private CodigoTipoServicioValidationRule() {
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
		if(!UtilTexto.longitudMaximaValida(dato,50)) {
			var mensajeUsuario = "La longitud del codigo del tipo de identificacion no es valida. la longitud Maxima son 50 caracteres";
			throw ServiceSpaOnlineException.crear(mensajeUsuario);
		}
	}
	private final void validarObligatoriedad(final String dato) {
		if(UtilTexto.estaVacio(dato)) {
			var mensajeUsuario = "La longitud del codigo del tipo de identificacion es un dato de tipo obligatorio...";
			throw ServiceSpaOnlineException.crear(mensajeUsuario);
		}
	}
	private final void validarFormato(final String dato) {
		if(!UtilTexto.contieneSoloLetrasDigitosEspacios(dato)) {
			var mensajeUsuario = "La longitud del codigo del tipo de identificacion solo puede contener letras...";
			throw ServiceSpaOnlineException.crear(mensajeUsuario);
		}
	}

}
