package co.edu.uco.spaonline.service.domain.support;

public class CorreoElectronicoClienteDomain {

	public String CorreoElectronico;
	public boolean correoElectronicoConfirmado;
	private CorreoElectronicoClienteDomain( final  String correoElectronico, final  boolean correoElectronicoConfirmado) {
		setCorreoElectronico(correoElectronico);
		setCorreoElectronicoConfirmado(correoElectronicoConfirmado);
	}
	
	public static CorreoElectronicoClienteDomain crear( final String correoElectronico,
			final boolean correoElectronicoConfirmado) {
		
		return new CorreoElectronicoClienteDomain (correoElectronico,correoElectronicoConfirmado);
	}
	private final void setCorreoElectronico(final String correoElectronico) {
		CorreoElectronico = correoElectronico;
	}
	private final void setCorreoElectronicoConfirmado( final boolean correoElectronicoConfirmado) {
		this.correoElectronicoConfirmado = correoElectronicoConfirmado;
	}
	public final String getCorreoElectronico() {
		return CorreoElectronico;
	}
	public final boolean isCorreoElectronicoConfirmado() {
		return correoElectronicoConfirmado;
	}
	
	
}
