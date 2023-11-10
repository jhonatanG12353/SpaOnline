package co.edu.uco.spaonline.service.businesslogic.validator.concrete.tiposervicio;

import co.edu.uco.spaonline.service.businesslogic.validator.Validator;
import co.edu.uco.spaonline.service.domain.tiposervicio.TipoServicioDomain;
import co.edu.uco.spaonline.service.domain.tiposervicio.rule.IdTipoServicioValidationRule;
import co.edu.uco.spaonline.service.domain.tiposervicio.rule.NombreTipoServicioValidationRule;

public class RegistrarTipoServicioValidator implements Validator<TipoServicioDomain>{
	
	private static final Validator<TipoServicioDomain> instancia = new RegistrarTipoServicioValidator();

	@Override
	public void validar(TipoServicioDomain data) {
		IdTipoServicioValidationRule.ejecutarValidacion(data.getId());
		NombreTipoServicioValidationRule.ejecutarValidacion(data.getNombreTipoServicio());
		
	}
	public static final void ejecutar (final TipoServicioDomain data) {
		instancia.validar(data);
	}

}
