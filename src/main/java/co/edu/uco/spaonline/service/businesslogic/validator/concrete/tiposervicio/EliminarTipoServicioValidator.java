package co.edu.uco.spaonline.service.businesslogic.validator.concrete.tiposervicio;

import co.edu.uco.spaonline.service.businesslogic.validator.Validator;
import co.edu.uco.spaonline.service.domain.tiposervicio.TipoServicioDomain;
import co.edu.uco.spaonline.service.domain.tiposervicio.rule.IdTipoServicioValidationRule;
import co.edu.uco.spaonline.service.domain.tiposervicio.rule.TipoServicioValidationRule;

public class EliminarTipoServicioValidator implements Validator<TipoServicioDomain>{
	private static final Validator<TipoServicioDomain> instancia = new EliminarTipoServicioValidator();
	
	private EliminarTipoServicioValidator() {
		super();
	}
	
	public static final void ejecutar(final TipoServicioDomain data) {
		instancia.validar(data);
	}
	
	@Override
	public void validar(TipoServicioDomain data) {
		TipoServicioValidationRule.ejecutarValidacion(data);
		IdTipoServicioValidationRule.ejecutarValidacion(data.getId());
	}

}
