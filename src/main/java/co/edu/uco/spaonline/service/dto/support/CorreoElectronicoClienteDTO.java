package co.edu.uco.spaonline.service.dto.support;

import co.edu.uco.spaonline.service.dto.support.CorreoElectronicoClienteDTO;

public class CorreoElectronicoClienteDTO {
	
	public String CorreoElectronico;
	public boolean correoElectronicoConfirmado;
	
	
	public CorreoElectronicoClienteDTO(String correoElectronico, boolean correoElectronicoConfirmado) {
		setCorreoElectronico(correoElectronico);
		setCorreoElectronicoConfirmado(correoElectronicoConfirmado);
	}
	
	public final CorreoElectronicoClienteDTO  setCorreoElectronico(String correoElectronico) {
		CorreoElectronico = correoElectronico;
		return this;
	}
	public final CorreoElectronicoClienteDTO setCorreoElectronicoConfirmado(boolean correoElectronicoConfirmado) {
		this.correoElectronicoConfirmado = correoElectronicoConfirmado;
		return this;
	}
	public final String getCorreoElectronico() {
		return CorreoElectronico;
	}
	public final boolean isCorreoElectronicoConfirmado() {
		return correoElectronicoConfirmado;
	}
	public static CorreoElectronicoClienteDTO crear(String correoElectronico,
			boolean correoElectronicoConfirmado) {
		return new CorreoElectronicoClienteDTO (correoElectronico,correoElectronicoConfirmado);
	}
	
	
}
