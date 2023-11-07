package co.edu.uco.spaonline.service.businesslogic.validator.concrete.cliente;

import co.edu.uco.spaonline.crosscutting.util.UtilFechaDefecto;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.crosscutting.util.UtilTexto;
import co.edu.uco.spaonline.crosscutting.util.UtilUUID;
import co.edu.uco.spaonline.service.businesslogic.validator.Validator;
import co.edu.uco.spaonline.service.domain.cliente.ClienteDomain;
import co.edu.uco.spaonline.service.domain.cliente.rules.FechaNacimientoClienteValidationRule;
import co.edu.uco.spaonline.service.domain.cliente.rules.IdClienteValidationRule;
import co.edu.uco.spaonline.service.domain.cliente.rules.IdentificacionValidationRule;
import co.edu.uco.spaonline.service.domain.correoelectronicocliente.rules.CorreoElectronicoClienteValidationRule;
import co.edu.uco.spaonline.service.domain.nombrecompletocliente.rules.PrimerNombreNombreCompletoClienteValidationRule;
import co.edu.uco.spaonline.service.domain.numerotelefonomovilcliente.rules.NumeroTelefonoMovilClienteValidationRule;
import co.edu.uco.spaonline.service.domain.tipoidentificacion.rules.IdTipoIdentificacionValidationRule;

public class ConsultarClienteValidator implements Validator<ClienteDomain> {
	private static final Validator<ClienteDomain> instancia = new ConsultarClienteValidator();
	
	private ConsultarClienteValidator() {
		super();
	}
	
	public static final void ejecutar(final ClienteDomain data) {
		instancia.execute(data);
	}

	@Override
	public void execute(ClienteDomain data) {
		if(!UtilObjeto.esNulo(data)) {
			if(!UtilUUID.esNulo(data.getId())) {
				IdClienteValidationRule.ejecutarValidacion(data.getId());
			}
			
			if(!UtilObjeto.esNulo(data.getTipoIdentificacion()) && !UtilUUID.esNulo(data.getTipoIdentificacion().getId())) {
				IdTipoIdentificacionValidationRule.ejecutarValidacion(data.getTipoIdentificacion().getId());
			}
			
			if(!UtilTexto.estaVacio(data.getIdentificacion())) {
				IdentificacionValidationRule.ejecutarValidacion(data.getIdentificacion());
			}
			
			if(!UtilObjeto.esNulo(data.getNombreCompleto())) {
				if(!UtilTexto.estaVacio(data.getNombreCompleto().getPrimerNombre())) {
					PrimerNombreNombreCompletoClienteValidationRule.ejecutarValidacion(data.getNombreCompleto().getPrimerNombre());
				}
				
				if(!UtilTexto.estaVacio(data.getNombreCompleto().getSegundoNombre())) {
					PrimerNombreNombreCompletoClienteValidationRule.ejecutarValidacion(data.getNombreCompleto().getSegundoNombre());
				}
				
				if(!UtilTexto.estaVacio(data.getNombreCompleto().getPrimerApellido())) {
					PrimerNombreNombreCompletoClienteValidationRule.ejecutarValidacion(data.getNombreCompleto().getPrimerApellido());
				}
				
				if(!UtilTexto.estaVacio(data.getNombreCompleto().getSegundoApellido())) {
					PrimerNombreNombreCompletoClienteValidationRule.ejecutarValidacion(data.getNombreCompleto().getSegundoApellido());
				}
			}
			
			if(!UtilObjeto.esNulo(data.getCorreoElectronico()) && !UtilTexto.estaVacio(data.getCorreoElectronico().getCorreoElectronico())) {
				CorreoElectronicoClienteValidationRule.ejecutarValidacion(data.getCorreoElectronico().getCorreoElectronico());
			}
			
			if(!UtilObjeto.esNulo(data.getNumeroTelefonoMovil()) && !UtilTexto.estaVacio(data.getNumeroTelefonoMovil().getNumeroTelefonoMovil())) {
				NumeroTelefonoMovilClienteValidationRule.ejecutarValidacion(data.getNumeroTelefonoMovil());
			}
			
			if(!UtilFechaDefecto.esNulo(data.getFechaNacimiento())) {
				FechaNacimientoClienteValidationRule.ejecutarValidacion(data.getFechaNacimiento());
			}
			
		}
	}

}
