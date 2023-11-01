package co.edu.uco.spaonline.service.businesslogic.validator.concrete.servicio;

import co.edu.uco.spaonline.service.businesslogic.validator.Validator;
import co.edu.uco.spaonline.service.domain.servicio.ServicioDomain;
import co.edu.uco.spaonline.service.domain.servicio.rules.DuracionHoraServicioValidationRule;
import co.edu.uco.spaonline.service.domain.servicio.rules.IdServicioValidationRule;
import co.edu.uco.spaonline.service.domain.servicio.rules.InformacionServicioValidationRule;
import co.edu.uco.spaonline.service.domain.servicio.rules.PrecioValidationRule;

public class RegistrarServicioValidator implements Validator<ServicioDomain> {
	
	private static final Validator<ServicioDomain> instancia = new RegistrarServicioValidator();
	
	public void execute(ServicioDomain data) {
	 IdServicioValidationRule.ejecutarValidacion(data.getId());
	 InformacionServicioValidationRule.ejecutarValidacion(data.getInformacionServicio());
	 PrecioValidationRule.ejecutarValidacion(data.getPrecio());
	 DuracionHoraServicioValidationRule.ejecutarValidacion(data.getDuracionHoraServicio());
	}
	public static final void ejecutar (final ServicioDomain data) {
		instancia.execute(data);
	}
	
}
