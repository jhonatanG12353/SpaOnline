package co.edu.uco.spaonline.service.businesslogic.validator.concrete.tiposervicio;

import co.edu.uco.spaonline.service.businesslogic.validator.Validator;
import co.edu.uco.spaonline.service.domain.tipoidentificacion.rules.IdTipoIdentificacionValidationRule;
import co.edu.uco.spaonline.service.domain.tiposervicio.TipoServicioDomain;
import co.edu.uco.spaonline.service.domain.tiposervicio.rule.NombreTipoServicioValidationRule;

public class ModificarTipoServicioValidator implements Validator<TipoServicioDomain> {
	
	private static final Validator<TipoServicioDomain> instancia = new ModificarTipoServicioValidator();
	
	@Override
	public final void execute(final TipoServicioDomain data) {
		
		IdTipoIdentificacionValidationRule.ejecutarValidacion(data.getId());
		NombreTipoServicioValidationRule.ejecutarValidacion(data.getNombreTipoServicio());
		
	}
	public static final void ejecutar (final TipoServicioDomain data) {
		instancia.execute(data);
	}

}
