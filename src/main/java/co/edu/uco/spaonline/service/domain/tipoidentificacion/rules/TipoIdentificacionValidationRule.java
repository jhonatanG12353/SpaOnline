package co.edu.uco.spaonline.service.domain.tipoidentificacion.rules;


import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.service.domain.ValidationRule;
import co.edu.uco.spaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;

public class TipoIdentificacionValidationRule implements ValidationRule<TipoIdentificacionDomain>{
	
	private static final ValidationRule<TipoIdentificacionDomain> instancia = new TipoIdentificacionValidationRule();

	private TipoIdentificacionValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final TipoIdentificacionDomain dato) {
		instancia.validar(dato);
		
	}
	@Override
	public final void validar (TipoIdentificacionDomain dato) {
		if (UtilObjeto.esNulo(dato)) {
			final var mensajeUsuario= " No es posible llevar a cablo la operacion deseada con el Tipo de Identificacion";
			throw ServiceSpaOnlineException.crear(mensajeUsuario);
		}
	}
	
	

}
