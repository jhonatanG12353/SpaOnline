package co.edu.uco.spaonline.service.businesslogic.validator.concrete.servicio;

import co.edu.uco.spaonline.service.businesslogic.validator.Validator;
import co.edu.uco.spaonline.service.domain.servicio.ServicioDomain;
import co.edu.uco.spaonline.service.domain.servicio.rules.IdServicioValidationRule;
import co.edu.uco.spaonline.service.domain.servicio.rules.ServicioValidationRule;

public class EliminarServicioValidator implements Validator<ServicioDomain> {
	
	private static final Validator<ServicioDomain> instancia = new EliminarServicioValidator();
	
	public static final void ejecutar(final ServicioDomain data) {
		instancia.execute(data);
	}
	
	@Override
	public void execute(ServicioDomain data) {	
		ServicioValidationRule.ejecutarValidacion(data);
		IdServicioValidationRule.ejecutarValidacion(data.getId());
	}

}
