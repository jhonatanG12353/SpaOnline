package co.edu.uco.spaonline.data.entity.support;

public class NumeroTelefonoMovilClienteEntity {
	public String numeroTelefonoMovil;
	public boolean numeroTelefonoConfirmado;
	private NumeroTelefonoMovilClienteEntity(final String numeroTelefonoMovil, final boolean numeroTelefonoConfirmado) {
		super();
		setNumeroTelefonoMovil(numeroTelefonoMovil);
		setNumeroTelefonoConfirmado(numeroTelefonoConfirmado);
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
