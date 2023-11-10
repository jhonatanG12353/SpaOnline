package co.edu.uco.spaonline.service.businesslogic.validator.concrete.tiposervicio;

import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.crosscutting.util.UtilTexto;
import co.edu.uco.spaonline.crosscutting.util.UtilUUID;
import co.edu.uco.spaonline.service.businesslogic.validator.Validator;
import co.edu.uco.spaonline.service.domain.tiposervicio.TipoServicioDomain;
import co.edu.uco.spaonline.service.domain.tiposervicio.rule.CodigoTipoServicioValidationRule;
import co.edu.uco.spaonline.service.domain.tiposervicio.rule.IdTipoServicioValidationRule;

public class ConsultarTipoServicioValidator implements Validator<TipoServicioDomain>{
	private static final Validator<TipoServicioDomain> instancia = new ConsultarTipoServicioValidator();
	
	private ConsultarTipoServicioValidator() {
		super();
	}
	
	public static final void ejecutar(final TipoServicioDomain data) {
		instancia.validar(data);
	}
	
	@Override
	public void validar(TipoServicioDomain data) {
		if(!UtilObjeto.esNulo(data)) {
			if(!UtilUUID.esNulo(data.getId())) {				
				IdTipoServicioValidationRule.ejecutarValidacion(data.getId());
			}
			
			if(!UtilTexto.estaVacio(data.getNombreTipoServicio())) {				
				CodigoTipoServicioValidationRule.ejecutarValidacion(data.getNombreTipoServicio());
			}

		}
	}

}
