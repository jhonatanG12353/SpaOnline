package co.edu.uco.spaonline.service.businesslogic.validator.concrete.tipoidentificacion;

import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.crosscutting.util.UtilTexto;
import co.edu.uco.spaonline.crosscutting.util.UtilUUID;
import co.edu.uco.spaonline.service.businesslogic.validator.Validator;
import co.edu.uco.spaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.spaonline.service.domain.tipoidentificacion.rules.CodigoTipoIdentificacionValidationRule;
import co.edu.uco.spaonline.service.domain.tipoidentificacion.rules.IdTipoIdentificacionValidationRule;
import co.edu.uco.spaonline.service.domain.tipoidentificacion.rules.NombreTipoIdentificacionValidationRule;

public class ConsultarTipoIdentificacionValidator implements Validator<TipoIdentificacionDomain>{
	private static final Validator<TipoIdentificacionDomain> instancia = new ConsultarTipoIdentificacionValidator();
	
	private ConsultarTipoIdentificacionValidator() {
		super();
	}
	
	public static final void ejecutar(final TipoIdentificacionDomain data) {
		instancia.execute(data);
	}
	
	@Override
	public void execute(TipoIdentificacionDomain data) {
		if(!UtilObjeto.esNulo(data)) {
			if(!UtilUUID.esNulo(data.getId())) {				
				IdTipoIdentificacionValidationRule.ejecutarValidacion(data.getId());
			}
			
			if(!UtilTexto.estaVacio(data.getCodigo())) {				
				CodigoTipoIdentificacionValidationRule.ejecutarValidacion(data.getCodigo());
			}
			
			if(!UtilTexto.estaVacio(data.getNombre())) {				
				NombreTipoIdentificacionValidationRule.ejecutarValidacion(data.getNombre());
			}
		}
	}

}
