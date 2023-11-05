package co.edu.uco.spaonline.service.businesslogic.validator.concrete.tipoidentificacion;


import co.edu.uco.spaonline.service.businesslogic.validator.Validator;
import co.edu.uco.spaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.spaonline.service.domain.tipoidentificacion.rules.CodigoTipoIdentificacionValidationRule;
import co.edu.uco.spaonline.service.domain.tipoidentificacion.rules.NombreTipoIdentificacionValidationRule;


public class RegistrarTipoIdentificacionValidator implements Validator<TipoIdentificacionDomain> {
	
	private static final Validator<TipoIdentificacionDomain> instancia = new RegistrarTipoIdentificacionValidator();
	
	@Override
	public final void execute(final TipoIdentificacionDomain data) {
		CodigoTipoIdentificacionValidationRule.ejecutarValidacion(data.getCodigo());
		NombreTipoIdentificacionValidationRule.ejecutarValidacion(data.getNombre());
		
	}
	public static final void ejecutar (final TipoIdentificacionDomain data) {
		instancia.execute(data);
	}

	
}