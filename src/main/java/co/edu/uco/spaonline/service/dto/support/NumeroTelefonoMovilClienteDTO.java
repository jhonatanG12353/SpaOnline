package co.edu.uco.spaonline.service.dto.support;

public class NumeroTelefonoMovilClienteDTO {
	
	public String numeroTelefonoMovil;
	public boolean numeroTelefonoConfirmado;
	
	
	public NumeroTelefonoMovilClienteDTO(String numeroTelefonoMovil, boolean numeroTelefonoConfirmado) {
		setNumeroTelefonoConfirmado(numeroTelefonoConfirmado);
		setNumeroTelefonoMovil(numeroTelefonoMovil);
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
