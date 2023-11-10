package co.edu.uco.spaonline.service.domain.tiposervicio.rule;

import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.service.domain.ValidationRule;
import co.edu.uco.spaonline.service.domain.tiposervicio.TipoServicioDomain;

public class TipoServicioValidationRule implements ValidationRule<TipoServicioDomain>{
	
	private static final ValidationRule<TipoServicioDomain> instancia = new TipoServicioValidationRule();

	private TipoServicioValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final TipoServicioDomain dato) {
		instancia.validar(dato);
		
	}
	@Override
	public final void validar (TipoServicioDomain dato) {
		if (UtilObjeto.esNulo(dato)) {
			final var mensajeUsuario= " No es posible llevar a cablo la operacion deseada con el Tipo de Identificacion";
			throw ServiceSpaOnlineException.crear(mensajeUsuario);
		}
	}
	

}
