package co.edu.uco.spaonline.data.entity.support;

import co.edu.uco.spaonline.data.entity.support.CorreoElectronicoClienteEntity;

public class CorreoElectronicoClienteEntity {
	private String correoElectronico;
	private BooleanEntity correoElectronicoConfirmado;
	
	private CorreoElectronicoClienteEntity(final String correoElectronico, final BooleanEntity correoElectronicoConfirmado) {
		setCorreoElectronico(correoElectronico);
		setCorreoElectronicoConfirmado(correoElectronicoConfirmado);
	}
	
	public static final CorreoElectronicoClienteEntity crear(final String correoElectronico, final BooleanEntity correoElectronicoConfirmado) {
		return new CorreoElectronicoClienteEntity(correoElectronico, correoElectronicoConfirmado);
	}

	private final void setCorreoElectronico(final String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	private final void setCorreoElectronicoConfirmado(final BooleanEntity correoElectronicoConfirmado) {
		this.correoElectronicoConfirmado = correoElectronicoConfirmado;
	}

	public final String getCorreoElectronico() {
		return correoElectronico;
	}

	public final BooleanEntity isCorreoElectronicoConfirmado() {
		return correoElectronicoConfirmado;
	}
	
}
