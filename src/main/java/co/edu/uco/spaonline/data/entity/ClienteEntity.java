package co.edu.uco.spaonline.data.entity;

import java.sql.Date;
import java.util.UUID;

import co.edu.uco.spaonline.data.entity.support.CorreoElectronicoClienteEntity;
import co.edu.uco.spaonline.data.entity.support.NombreCompletoClienteEntity;
import co.edu.uco.spaonline.data.entity.support.NumeroTelefonoMovilClienteEntity;
import co.edu.uco.spaonline.service.domain.cliente.rules.FechaNacimientoClienteValidationRule;
import co.edu.uco.spaonline.data.entity.ClienteEntity;
public final class ClienteEntity {
	private UUID id;
	private TipoIdentificacionEntity tipoIdentificacion;
	private String identificacion;
	private NombreCompletoClienteEntity nombreCompleto;
	private CorreoElectronicoClienteEntity correoElectronico;
	private NumeroTelefonoMovilClienteEntity numeroTelefonoMovil;
	private static Date fechaNacimiento;
	private ClienteEntity(final UUID id, final TipoIdentificacionEntity tipoIdentificacion, final String identificacion, final NombreCompletoClienteEntity nombreClienteEntity, final CorreoElectronicoClienteEntity correoClienteEntity, final NumeroTelefonoMovilClienteEntity numeroTelefonoMovilClienteEntity, final Date fechaNacimiento) {
		
		setId(id);
		setTipoIdentificacion(tipoIdentificacion);
		setIdentificacion(identificacion);
		setNombreCompleto(nombreClienteEntity);
		setCorreoElectronico(correoClienteEntity);
		setNumeroTelefonoMovil(numeroTelefonoMovilClienteEntity);
		setFechaNacimiento(fechaNacimiento);
		
	}
	public static final ClienteEntity crear (final UUID id, final TipoIdentificacionEntity tipoIdentificacion, final String identificacion, final NombreCompletoClienteEntity nombreCompletoCliente, final CorreoElectronicoClienteEntity correoElectronicoCliente, final NumeroTelefonoMovilClienteEntity numeroTelefonoMovilCliente, final Date fechaNacimientoClienteValidationRule) {
		return new ClienteEntity (id, tipoIdentificacion, identificacion, nombreCompletoCliente, correoElectronicoCliente, numeroTelefonoMovilCliente, fechaNacimiento);
	}
	
	private final void setId(UUID id) {
		this.id = id;
	}
	private final void setTipoIdentificacion(TipoIdentificacionEntity tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}
	private final void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public final void setNombreCompleto(NombreCompletoClienteEntity nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public final CorreoElectronicoClienteEntity getCorreoElectronico() {
		return correoElectronico;
	}
	private final void setCorreoElectronico(CorreoElectronicoClienteEntity correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public final NumeroTelefonoMovilClienteEntity getNumeroTelefonoMovil() {
		return numeroTelefonoMovil;
	}
	private final void setNumeroTelefonoMovil(NumeroTelefonoMovilClienteEntity numeroTelefonoMovil) {
		this.numeroTelefonoMovil = numeroTelefonoMovil;
	}
	public final UUID getId() {
		return id;
	}
	public final TipoIdentificacionEntity getTipoIdentificacion() {
		return tipoIdentificacion;
	}
	public final String getIdentificacion() {
		return identificacion;
	}
	public final NombreCompletoClienteEntity getNombreCompleto() {
		return nombreCompleto;
	}
	public final Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	@SuppressWarnings("static-access")
	private final void setFechaNacimiento(final Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	

}
