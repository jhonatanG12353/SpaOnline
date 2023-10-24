package co.edu.uco.spaonline.service.domain.support;

public class NumeroTelefonoMovilClienteDomain {
	public String numeroTelefonoMovil;
	public boolean numeroTelefonoConfirmado;
	private NumeroTelefonoMovilClienteDomain(final String numeroTelefonoMovil, final boolean numeroTelefonoConfirmado) {
		super();
		setNumeroTelefonoMovil(numeroTelefonoMovil);
		setNumeroTelefonoConfirmado(numeroTelefonoConfirmado);
	}
	public static NumeroTelefonoMovilClienteDomain crear(String numeroTelefonoMovil,
			boolean numeroTelefonoConfirmado) {
		
		return new NumeroTelefonoMovilClienteDomain(numeroTelefonoMovil, numeroTelefonoConfirmado);
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
