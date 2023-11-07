package co.edu.uco.spaonline.service.domain.cliente;

import java.sql.Date;
import java.util.UUID;


import co.edu.uco.spaonline.service.domain.cliente.ClienteDomain;
import co.edu.uco.spaonline.service.domain.correoelectronicocliente.CorreoElectronicoClienteDomain;
import co.edu.uco.spaonline.service.domain.nombrecompletocliente.NombreCompletoClienteDomain;
import co.edu.uco.spaonline.service.domain.numerotelefonomovilcliente.NumeroTelefonoMovilClienteDomain;
import co.edu.uco.spaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;

public final class ClienteDomain {
	private UUID id;
	private TipoIdentificacionDomain tipoIdentificacion;
	private String identificacion;
	private NombreCompletoClienteDomain nombreCompleto;
	private CorreoElectronicoClienteDomain correoElectronico;
	private NumeroTelefonoMovilClienteDomain numeroTelefonoMovil;
	private Date fechaNacimiento;
	
	private ClienteDomain(final UUID id, final TipoIdentificacionDomain tipoIdentificacion, final String identificacion, final NombreCompletoClienteDomain nombreClienteDomain, final CorreoElectronicoClienteDomain correoClienteDomain,
			final NumeroTelefonoMovilClienteDomain numeroTelefonoMovilClienteDomain , final Date fechaNacimiento) {
		
		setId(id);
		setTipoIdentificacion(tipoIdentificacion);
		setIdentificacion(identificacion);
		setNombreCompleto(nombreClienteDomain);
		setCorreoElectronico(correoClienteDomain);
		setNumeroTelefonoMovil(numeroTelefonoMovilClienteDomain);
		setFechaNacimiento(fechaNacimiento);
	}
	public static final ClienteDomain crear(final UUID id, final TipoIdentificacionDomain tipoIdentificacion, final String identificacion,
			final NombreCompletoClienteDomain nombreCompleto, final CorreoElectronicoClienteDomain correoElectronico,
			final NumeroTelefonoMovilClienteDomain numeroTelefonoMovil, final Date fechaNacimiento) {
		return new ClienteDomain(id, tipoIdentificacion, identificacion, nombreCompleto, correoElectronico, numeroTelefonoMovil, fechaNacimiento);
	}
	

	
	private final void setId(UUID id) {
		this.id = id;
	}
	private final void setTipoIdentificacion(TipoIdentificacionDomain tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}
	private final void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public final void setNombreCompleto(NombreCompletoClienteDomain nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public final CorreoElectronicoClienteDomain getCorreoElectronico() {
		return correoElectronico;
	}
	private final void setCorreoElectronico(CorreoElectronicoClienteDomain correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public final NumeroTelefonoMovilClienteDomain getNumeroTelefonoMovil() {
		return numeroTelefonoMovil;
	}
	private final void setNumeroTelefonoMovil(NumeroTelefonoMovilClienteDomain numeroTelefonoMovil) {
		this.numeroTelefonoMovil = numeroTelefonoMovil;
	}
	private final void setFechaNacimiento(final Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public final UUID getId() {
		return id;
	}
	public final TipoIdentificacionDomain getTipoIdentificacion() {
		return tipoIdentificacion;
	}
	public final String getIdentificacion() {
		return identificacion;
	}
	public final NombreCompletoClienteDomain getNombreCompleto() {
		return nombreCompleto;
	}
	public final Date getFechaNacimiento() {
		return fechaNacimiento;
	}
}
