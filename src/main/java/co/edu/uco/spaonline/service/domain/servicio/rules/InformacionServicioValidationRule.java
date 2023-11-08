package co.edu.uco.spaonline.service.domain.servicio.rules;

import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.service.businesslogic.validator.Validator;
import co.edu.uco.spaonline.service.domain.ValidationRule;
import co.edu.uco.spaonline.service.domain.informacionservicio.InformacionServicioDomain;

public class InformacionServicioValidationRule implements ValidationRule<InformacionServicioDomain>{
	
	@SuppressWarnings("unchecked")
	private static final Validator<InformacionServicioDomain> instancia = (Validator<InformacionServicioDomain>) new InformacionServicioValidationRule();

	private InformacionServicioValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final InformacionServicioDomain dato) {
		instancia.execute(dato);
		
	}

	@Override
	public void validar(InformacionServicioDomain dato) {
		if (UtilObjeto.esNulo(dato)) {
			var mensajeUsuario= " No es posible llevar a cablo la operacion deseada con el nformacion Servicio";
			throw ServiceSpaOnlineException.crear(mensajeUsuario);
		}
		
	}

}
