package co.edu.uco.spaonline.data.entity.support;

import co.edu.uco.spaonline.data.entity.support.NumeroTelefonoMovilClienteEntity;

public class NumeroTelefonoMovilClienteEntity {
	public String numeroTelefonoMovil;
	public boolean numeroTelefonoConfirmado;
	private NumeroTelefonoMovilClienteEntity(final String numeroTelefonoMovil, final boolean numeroTelefonoConfirmado) {
		super();
		setNumeroTelefonoMovil(numeroTelefonoMovil);
		setNumeroTelefonoConfirmado(numeroTelefonoConfirmado);
	}
	
	public static NumeroTelefonoMovilClienteEntity crear(String numeroTelefonoMovil,
			boolean numeroTelefonoConfirmado) {
		
		return new NumeroTelefonoMovilClienteEntity(numeroTelefonoMovil, numeroTelefonoConfirmado);
	}
	private final void setNumeroTelefonoMovil(final String numeroTelefonoMovil) {
		this.numeroTelefonoMovil = numeroTelefonoMovil;
	}
	private final void setNumeroTelefonoConfirmado( final boolean numeroTelefonoConfirmado) {
		this.numeroTelefonoConfirmado = numeroTelefonoConfirmado;
	}
	public final String getNumeroTelefonoMovil() {
		return numeroTelefonoMovil;
	}
	public final boolean isNumeroTelefonoConfirmado() {
		return numeroTelefonoConfirmado;
	}
	

}
