package co.edu.uco.spaonline.service.domain.cliente.rules;

import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.service.domain.ValidationRule;
import co.edu.uco.spaonline.service.domain.support.NombreCompletoClienteDomain;

public class NombreCompletoValidationRule implements ValidationRule <NombreCompletoClienteDomain>{

	private static final ValidationRule<NombreCompletoClienteDomain> instancia = new NombreCompletoValidationRule();
	
	private NombreCompletoValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final NombreCompletoClienteDomain dato) {
		instancia.validar(dato);
	}
	
	@Override
	public void validar(NombreCompletoClienteDomain dato) {
		ValidarObligatoriedad(dato);
	
		
	}
	
	private final void ValidarObligatoriedad(final NombreCompletoClienteDomain dato) {
		if(UtilObjeto.esNulooVacio(dato)) {
			var mensajeUsuario = "El nombre no puede estar vacio";
			throw ServiceSpaOnlineException.crear(mensajeUsuario);
		}
	}
	
}
