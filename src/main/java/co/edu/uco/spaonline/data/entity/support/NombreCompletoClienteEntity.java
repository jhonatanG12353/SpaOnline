package co.edu.uco.spaonline.data.entity.support;

import co.edu.uco.spaonline.data.entity.support.NombreCompletoClienteEntity;

public class NombreCompletoClienteEntity {
	public String primerNombre;
	public String segundoNombre;
	public String primerApellido;
	public String segundoApellido;
	private NombreCompletoClienteEntity(String primerNombre, String segundoNombre, String primerApellido,
			String segundoApellido) {
		setPrimerNombre(primerNombre);
		setSegundoNombre(segundoNombre);
		setPrimerApellido(primerApellido);
		setSegundoApellido(segundoApellido);
	}
	public static NombreCompletoClienteEntity crear(String primerNombre, String segundoNombre, String primerApellido,
			String segundoApellido) {
	
		return new NombreCompletoClienteEntity(primerNombre, segundoNombre, primerApellido, segundoApellido);
	}
	private final void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}
	private final void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}
	private final void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	private final void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
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


}
