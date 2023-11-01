package co.edu.uco.spaonline.service.dto.support;

import co.edu.uco.spaonline.service.dto.support.NombreCompletoClienteDTO;

public class NombreCompletoClienteDTO {
	
	public String primerNombre;
	public String segundoNombre;
	public String primerApellido;
	public String segundoApellido;
	
	
	public NombreCompletoClienteDTO(String primerNombre, String segundoNombre, String primerApellido,
			String segundoApellido) {
		setPrimerApellido(primerApellido);
		setSegundoApellido(segundoApellido);
		setPrimerNombre(primerNombre);
		setSegundoNombre(segundoNombre);
	}
	public final NombreCompletoClienteDTO setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
		return this;
	}
	public final NombreCompletoClienteDTO setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
		return this;
	}
	public final NombreCompletoClienteDTO setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
		return this;
	}
	public final NombreCompletoClienteDTO setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
		return this;
	}
	public final String getPrimerNombre() {
		return primerNombre;
	}
	public final String getSegundoNombre() {
		return segundoNombre;
	}
	public final String getPrimerApellido() {
		return primerApellido;
	}
	public final String getSegundoApellido() {
		return segundoApellido;
	}
	public static NombreCompletoClienteDTO crear(String primerNombre, String segundoNombre, String primerApellido,
			String segundoApellido) {
	
		return new NombreCompletoClienteDTO(primerNombre, segundoNombre, primerApellido, segundoApellido);
	}
	
	
	

}
