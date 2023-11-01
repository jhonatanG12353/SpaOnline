package co.edu.uco.spaonline.service.dto;

import java.sql.Date;
import java.util.UUID;

import co.edu.uco.spaonline.crosscutting.util.UtilFechaDefecto;
import co.edu.uco.spaonline.crosscutting.util.UtilTexto;
import co.edu.uco.spaonline.service.dto.support.CorreoElectronicoClienteDTO;
import co.edu.uco.spaonline.service.dto.support.NombreCompletoClienteDTO;
import co.edu.uco.spaonline.service.dto.support.NumeroTelefonoMovilClienteDTO;
import co.edu.uco.spaonline.service.domain.support.CorreoElectronicoClienteDomain;
import co.edu.uco.spaonline.service.domain.support.NombreCompletoClienteDomain;
import co.edu.uco.spaonline.service.domain.support.NumeroTelefonoMovilClienteDomain;
import co.edu.uco.spaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.spaonline.service.dto.ClienteDTO;

public final class ClienteDTO {
	
	private UUID id;
	private TipoIdentificacionDTO tipoIdentificacion;
	private String identificacion;
	private NombreCompletoClienteDTO nombreCompleto;
	private CorreoElectronicoClienteDTO correoElectronico;
	private NumeroTelefonoMovilClienteDTO numeroTelefonoMovil;
	private Date fechaNacimiento;
	
	
	public ClienteDTO(final UUID id, final TipoIdentificacionDTO tipoIdentificacion, final String identificacion,
			final NombreCompletoClienteDTO nombreCompleto, final CorreoElectronicoClienteDTO correoElectronico,
			final NumeroTelefonoMovilClienteDTO numeroTelefonoMovil, final Date fechaNacimiento) {
		setId(id);
		setTipoIdentificacion(tipoIdentificacion);
		setIdentificacion(UtilTexto.VACIO);
		setNombreCompleto(nombreCompleto);
		setCorreoElectronico(correoElectronico);
		setNumeroTelefonoMovil(numeroTelefonoMovil);
		setFechaNacimiento(UtilFechaDefecto.generarFechaInvalida());
	}
	public static final ClienteDTO crear (final UUID id, final TipoIdentificacionDomain tipoIdentificacion, final String identificacion, final NombreCompletoClienteDomain nombreCompletoCliente, final CorreoElectronicoClienteDomain correoElectronicoCliente, final NumeroTelefonoMovilClienteDomain numeroTelefonoMovilCliente) {
		return new ClienteDTO (id, null, identificacion, null, null, null,null);
	}
	
	
	public final ClienteDTO setId(final UUID id) {
		this.id = id;
		return this;
	}
	public final ClienteDTO setTipoIdentificacion(final TipoIdentificacionDTO tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
		return this;
	}
	public final ClienteDTO setIdentificacion(final String identificacion) {
		this.identificacion = identificacion;
		return this;
	}
	public final ClienteDTO setNombreCompleto(final NombreCompletoClienteDTO nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
		return this;
	}
	public final ClienteDTO setCorreoElectronico(final CorreoElectronicoClienteDTO correoElectronico) {
		this.correoElectronico = correoElectronico;
		return this;
	}
	public final ClienteDTO setNumeroTelefonoMovil(final NumeroTelefonoMovilClienteDTO numeroTelefonoMovil) {
		this.numeroTelefonoMovil = numeroTelefonoMovil;
		return this;
	}
	public final ClienteDTO setFechaNacimiento(final Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
		return this;
	}
	public final UUID getId() {
		return id;
	}
	public final TipoIdentificacionDTO getTipoIdentificacion() {
		return tipoIdentificacion;
	}
	public final String getIdentificacion() {
		return identificacion;
	}
	public final NombreCompletoClienteDTO getNombreCompleto() {
		return nombreCompleto;
	}
	public final CorreoElectronicoClienteDTO getCorreoElectronico() {
		return correoElectronico;
	}
	public final NumeroTelefonoMovilClienteDTO getNumeroTelefonoMovil() {
		return numeroTelefonoMovil;
	}
	public final Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	

}
