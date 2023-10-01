package co.edu.uco.spaonline.data.entity.support;

public class CorreoElectronicoClienteEntity {

	public String CorreoElectronico;
	public boolean correoElectronicoConfirmado;
	private CorreoElectronicoClienteEntity( final  String correoElectronico, final  boolean correoElectronicoConfirmado) {
		setCorreoElectronico(correoElectronico);
		setCorreoElectronicoConfirmado(correoElectronicoConfirmado);
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
