package co.edu.uco.spaonline.service.domain.servicio.rules;

import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.data.entity.support.InformacionServicioEntity;
import co.edu.uco.spaonline.service.businesslogic.validator.Validator;
import co.edu.uco.spaonline.service.domain.ValidationRule;
import co.edu.uco.spaonline.service.domain.informacionservicio.InformacionServicioDomain;

public class InformacionServicioValidationRule implements ValidationRule<InformacionServicioEntity>{
	
	private static final Validator<InformacionServicioEntity> instancia = (Validator<InformacionServicioEntity>) new InformacionServicioValidationRule();

	private InformacionServicioValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final InformacionServicioEntity dato) {
		instancia.execute(dato);
		
	}

	@Override
	public void validar(InformacionServicioEntity dato) {
		if (UtilObjeto.esNulo(dato)) {
			var mensajeUsuario= " No es posible llevar a cablo la operacion deseada con el nformacion Servicio";
			throw ServiceSpaOnlineException.crear(mensajeUsuario);
		}
	}
	
	

}
