package co.edu.uco.spaonline.service.domain.cliente.rules;

import java.util.UUID;

import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.service.domain.ValidationRule;

public class idClienteValidationRule implements  ValidationRule <UUID>{
	
	private static final ValidationRule<UUID> instancia = new idClienteValidationRule();
	
	private idClienteValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final UUID dato) {
		instancia.validar(dato);
	}
	
	@Override
	public void validar(UUID dato) {
		validarObligatoriedad(dato);	
	}
	private final void validarObligatoriedad(final UUID dato) {
		if(UtilObjeto.esNulo(dato)) {
			var mensajeUsuario = "La longitud del codigo del tipo de Servicio es un dato de tipo obligatorio...";
			throw ServiceSpaOnlineException.crear(mensajeUsuario);
		}
	}
	private final void validarFormato(final UUID dato) {
		if(!UtilObjeto.esNulo(dato)) {
			var mensajeUsuario = "La longitud del codigo del tipo de Servicio solo puede contener letras...";
			throw ServiceSpaOnlineException.crear(mensajeUsuario);
		}
	}
}
