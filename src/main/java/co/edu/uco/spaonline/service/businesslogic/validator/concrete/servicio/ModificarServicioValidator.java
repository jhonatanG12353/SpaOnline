package co.edu.uco.spaonline.service.businesslogic.validator.concrete.servicio;

import co.edu.uco.spaonline.service.businesslogic.validator.Validator;
import co.edu.uco.spaonline.service.domain.tiposervicio.TipoServicioDomain;
import co.edu.uco.spaonline.service.domain.tiposervicio.rule.IdTipoServicioValidationRule;
import co.edu.uco.spaonline.service.domain.tiposervicio.rule.NombreTipoServicioValidationRule;

public class ModificarServicioValidator implements Validator<TipoServicioDomain> {
	
	private static final Validator<TipoServicioDomain> instancia = new ModificarServicioValidator();
	
	@Override
	public final void execute(final TipoServicioDomain data) {
			IdTipoServicioValidationRule.ejecutarValidacion(data.getId());
			NombreTipoServicioValidationRule.ejecutarValidacion(data.getNombreTipoServicio());
	}
	public static final void ejecutar (final TipoServicioDomain data) {
		instancia.execute(data);
	}

}
