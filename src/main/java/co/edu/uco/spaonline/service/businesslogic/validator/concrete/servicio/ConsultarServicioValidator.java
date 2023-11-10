package co.edu.uco.spaonline.service.businesslogic.validator.concrete.servicio;

import co.edu.uco.spaonline.crosscutting.util.UtilNumero;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.crosscutting.util.UtilUUID;
import co.edu.uco.spaonline.service.businesslogic.validator.Validator;
import co.edu.uco.spaonline.service.domain.servicio.ServicioDomain;
import co.edu.uco.spaonline.service.domain.servicio.rules.DuracionHoraServicioValidationRule;
import co.edu.uco.spaonline.service.domain.servicio.rules.IdServicioValidationRule;
import co.edu.uco.spaonline.service.domain.servicio.rules.InformacionServicioValidationRule;
import co.edu.uco.spaonline.service.domain.servicio.rules.PrecioValidationRule;
import co.edu.uco.spaonline.service.domain.tiposervicio.rule.NombreTipoServicioValidationRule;

public class ConsultarServicioValidator implements Validator<ServicioDomain> {
	private static final Validator<ServicioDomain> instancia = new ConsultarServicioValidator();

	
	private ConsultarServicioValidator() {
		super();
	}
	
	public static final void ejecutar(final ServicioDomain data) {
		instancia.validar(data);
	}
	@Override
	public void validar(ServicioDomain data) {
		if(!UtilObjeto.esNulo(data)) {
			if(!UtilUUID.esNulo(data.getId())) {
				IdServicioValidationRule.ejecutarValidacion(data.getId());
			}
			if(!UtilObjeto.esNulo(data.getTipoServicio().getNombreTipoServicio())) {
				NombreTipoServicioValidationRule.ejecutarValidacion(data.getTipoServicio().getNombreTipoServicio());
			}
			
			if(!UtilObjeto.esNulo(data.getInformacionServicio())) {
				InformacionServicioValidationRule.ejecutarValidacion(data.getInformacionServicio());
			}
			
			if(!UtilNumero.estaNulo(data.getPrecio())) {
					PrecioValidationRule.ejecutarValidacion(data.getPrecio());
				}
				
			if(!UtilNumero.estaNulo(data.getDuracionHoraServicio())) {
				DuracionHoraServicioValidationRule.ejecutarValidacion(data.getDuracionHoraServicio());
			}
			
			
		}
		
	}

}
