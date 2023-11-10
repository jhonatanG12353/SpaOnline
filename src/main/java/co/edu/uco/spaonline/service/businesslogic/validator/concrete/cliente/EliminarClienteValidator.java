package co.edu.uco.spaonline.service.businesslogic.validator.concrete.cliente;

import co.edu.uco.spaonline.service.businesslogic.validator.Validator;
import co.edu.uco.spaonline.service.domain.cliente.ClienteDomain;
import co.edu.uco.spaonline.service.domain.cliente.rules.ClienteValidationRule;
import co.edu.uco.spaonline.service.domain.cliente.rules.IdClienteValidationRule;

public class EliminarClienteValidator implements Validator<ClienteDomain> {
	private static final Validator<ClienteDomain> instancia = new EliminarClienteValidator();
	
	private EliminarClienteValidator() {
		super();
	}
	
	public static final void ejecutar(final ClienteDomain data) {
		instancia.validar(data);
	}
	@Override
	public void validar(ClienteDomain data) {
		ClienteValidationRule.ejecutarValidacion(data);
		IdClienteValidationRule.ejecutarValidacion(data.getId());
	}

}
