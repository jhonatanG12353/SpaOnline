package co.edu.uco.spaonline.service.dto.support;

import co.edu.uco.spaonline.service.dto.support.NumeroTelefonoMovilClienteDTO;

public class NumeroTelefonoMovilClienteDTO {
	
	public String numeroTelefonoMovil;
	public boolean numeroTelefonoConfirmado;
	
	
	public NumeroTelefonoMovilClienteDTO(String numeroTelefonoMovil, boolean numeroTelefonoConfirmado) {
		setNumeroTelefonoConfirmado(numeroTelefonoConfirmado);
		setNumeroTelefonoMovil(numeroTelefonoMovil);
	}
	public static NumeroTelefonoMovilClienteDTO crear(String numeroTelefonoMovil,
			boolean numeroTelefonoConfirmado) {
		
		return new NumeroTelefonoMovilClienteDTO(numeroTelefonoMovil, numeroTelefonoConfirmado);
	}
	public final NumeroTelefonoMovilClienteDTO setNumeroTelefonoMovil(String numeroTelefonoMovil) {
		this.numeroTelefonoMovil = numeroTelefonoMovil;
		return this;
	}
	public final NumeroTelefonoMovilClienteDTO setNumeroTelefonoConfirmado(boolean numeroTelefonoConfirmado) {
		this.numeroTelefonoConfirmado = numeroTelefonoConfirmado;
		return this;
	}
	public final String getNumeroTelefonoMovil() {
		return numeroTelefonoMovil;
	}
	public final boolean isNumeroTelefonoConfirmado() {
		return numeroTelefonoConfirmado;
	}
	
}
