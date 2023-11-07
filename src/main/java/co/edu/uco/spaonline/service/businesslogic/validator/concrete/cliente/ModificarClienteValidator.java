package co.edu.uco.spaonline.service.businesslogic.validator.concrete.cliente;

import co.edu.uco.spaonline.service.businesslogic.validator.Validator;
import co.edu.uco.spaonline.service.domain.cliente.ClienteDomain;
import co.edu.uco.spaonline.service.domain.cliente.rules.ClienteValidationRule;
import co.edu.uco.spaonline.service.domain.cliente.rules.FechaNacimientoClienteValidationRule;
import co.edu.uco.spaonline.service.domain.cliente.rules.IdentificacionValidationRule;
import co.edu.uco.spaonline.service.domain.correoelectronicocliente.rules.CorreoElectronicoClienteValidationRule;
import co.edu.uco.spaonline.service.domain.nombrecompletocliente.rules.NombreCompletoValidationRule;
import co.edu.uco.spaonline.service.domain.nombrecompletocliente.rules.PrimerApellidoNombreCompletoClienteValidationRule;
import co.edu.uco.spaonline.service.domain.nombrecompletocliente.rules.PrimerNombreNombreCompletoClienteValidationRule;
import co.edu.uco.spaonline.service.domain.nombrecompletocliente.rules.SegundoApellidoNombreCompletoClienteValidationRule;
import co.edu.uco.spaonline.service.domain.nombrecompletocliente.rules.SegundoNombreNombreCompletoClienteValidationRule;
import co.edu.uco.spaonline.service.domain.numerotelefonomovilcliente.rules.NumeroTelefonoMovilClienteValidationRule;
import co.edu.uco.spaonline.service.domain.numerotelefonomovilcliente.rules.NumeroTelefonoMovilValidationRule;
import co.edu.uco.spaonline.service.domain.tipoidentificacion.rules.IdTipoIdentificacionValidationRule;
import co.edu.uco.spaonline.service.domain.tipoidentificacion.rules.TipoIdentificacionValidationRule;

public class ModificarClienteValidator implements Validator<ClienteDomain>{
	private static final Validator<ClienteDomain> instancia = new ModificarClienteValidator();
	
	private ModificarClienteValidator() {
		super();
	}
	
	public static final void ejecutar(final ClienteDomain data) {
		instancia.execute(data);
	}
	@Override
	public void execute(ClienteDomain data) {
		ClienteValidationRule.ejecutarValidacion(data);
		TipoIdentificacionValidationRule.ejecutarValidacion(data.getTipoIdentificacion());
		IdTipoIdentificacionValidationRule.ejecutarValidacion(data.getTipoIdentificacion().getId());
		IdentificacionValidationRule.ejecutarValidacion(data.getIdentificacion());
		NombreCompletoValidationRule.ejecutarValidacion(data.getNombreCompleto());
		PrimerNombreNombreCompletoClienteValidationRule.ejecutarValidacion(data.getNombreCompleto().getPrimerNombre());
		SegundoNombreNombreCompletoClienteValidationRule.ejecutarValidacion(data.getNombreCompleto().getSegundoNombre());
		PrimerApellidoNombreCompletoClienteValidationRule.ejecutarValidacion(data.getNombreCompleto().getPrimerApellido());
		SegundoApellidoNombreCompletoClienteValidationRule.ejecutarValidacion(data.getNombreCompleto().getSegundoApellido());
		CorreoElectronicoClienteValidationRule.ejecutarValidacion(data.getCorreoElectronico().getCorreoElectronico());
		NumeroTelefonoMovilClienteValidationRule.ejecutarValidacion(data.getNumeroTelefonoMovil());
		NumeroTelefonoMovilValidationRule.ejecutarValidacion(data.getNumeroTelefonoMovil().getNumeroTelefonoMovil());
		FechaNacimientoClienteValidationRule.ejecutarValidacion(data.getFechaNacimiento());
	}
}
