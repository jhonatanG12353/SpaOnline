package co.edu.uco.spaonline.service.businesslogic.validator.concrete.cliente;

import co.edu.uco.spaonline.service.businesslogic.validator.Validator;
import co.edu.uco.spaonline.service.domain.cliente.ClienteDomain;
import co.edu.uco.spaonline.service.domain.cliente.rules.CorreoElectronicoValidationRule;
import co.edu.uco.spaonline.service.domain.cliente.rules.NombreCompletoValidationRule;
import co.edu.uco.spaonline.service.domain.cliente.rules.NumeroTelefonoMovilValidationRule;
import co.edu.uco.spaonline.service.domain.cliente.rules.TipoIdentificacionValidationRule;
import co.edu.uco.spaonline.service.domain.cliente.rules.idClienteValidationRule;
import co.edu.uco.spaonline.service.domain.cliente.rules.identificacionValidationRule;

public class RegistrarClienteValidator implements Validator<ClienteDomain> {
	
	private static final Validator<ClienteDomain> instancia = new RegistrarClienteValidator();
	
	
	public static final void ejecutar (final ClienteDomain data) {
		instancia.execute(data);
	}
	@Override
	public void execute(ClienteDomain data) {
		idClienteValidationRule.ejecutarValidacion(data.getId());
		TipoIdentificacionValidationRule.ejecutarValidacion(data.getTipoIdentificacion());
		identificacionValidationRule.ejecutarValidacion(data.getIdentificacion());
		NombreCompletoValidationRule.ejecutarValidacion(data.getNombreCompleto());
		CorreoElectronicoValidationRule.ejecutarValidacion(data.getCorreoElectronico());
		NumeroTelefonoMovilValidationRule.ejecutarValidacion(data.getNumeroTelefonoMovil());
	}

}
