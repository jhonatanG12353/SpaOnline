package co.edu.uco.spaonline.service.businesslogic.validator.concrete.servicio;

import co.edu.uco.spaonline.service.businesslogic.validator.Validator;
import co.edu.uco.spaonline.service.domain.servicio.ServicioDomain;
import co.edu.uco.spaonline.service.domain.servicio.rules.DuracionHoraServicioValidationRule;
import co.edu.uco.spaonline.service.domain.servicio.rules.IdServicioValidationRule;
import co.edu.uco.spaonline.service.domain.servicio.rules.InformacionServicioValidationRule;
import co.edu.uco.spaonline.service.domain.servicio.rules.PrecioValidationRule;
public class ModificarServicioValidator implements Validator<ServicioDomain> {
	
	private static final Validator<ServicioDomain> instancia = new ModificarServicioValidator();
	
	@Override
	public final void validar(final ServicioDomain data) {
			IdServicioValidationRule.ejecutarValidacion(data.getId());
			InformacionServicioValidationRule.ejecutarValidacion(data.getInformacionServicio());
			DuracionHoraServicioValidationRule.ejecutarValidacion(data.getDuracionHoraServicio());
			PrecioValidationRule.ejecutarValidacion(data.getPrecio());
	}
	public static final void ejecutar (final ServicioDomain data) {
		instancia.validar(data);
	}

}
