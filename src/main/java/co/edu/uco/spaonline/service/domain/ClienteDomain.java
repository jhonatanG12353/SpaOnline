package co.edu.uco.spaonline.service.domain;

import java.util.UUID;


import co.edu.uco.spaonline.data.entity.TipoIdentificacionEntity;
import co.edu.uco.spaonline.data.entity.support.CorreoElectronicoClienteEntity;
import co.edu.uco.spaonline.data.entity.support.NombreCompletoClienteEntity;
import co.edu.uco.spaonline.data.entity.support.NumeroTelefonoMovilClienteEntity;
import co.edu.uco.spaonline.service.domain.support.CorreoElectronicoClienteDomain;
import co.edu.uco.spaonline.service.domain.support.NombreCompletoClienteDomain;
import co.edu.uco.spaonline.service.domain.support.NumeroTelefonoMovilClienteDomain;
import co.edu.uco.spaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;

public final class ClienteDomain {
	private UUID id;
	private TipoIdentificacionDomain tipoIdentificacion;
	private String identificacion;
	private NombreCompletoClienteDomain nombreCompleto;
	private CorreoElectronicoClienteDomain correoElectronico;
	private NumeroTelefonoMovilClienteDomain numeroTelefonoMovil;
	
	private ClienteDomain(final UUID id, final TipoIdentificacionDomain tipoIdentificacion, final String identificacion, final NombreCompletoClienteDomain nombreClienteDomain, final CorreoElectronicoClienteDomain correoClienteDomain, final NumeroTelefonoMovilClienteDomain numeroTelefonoMovilClienteDomain) {
		
		setId(id);
		setTipoIdentificacion(tipoIdentificacion);
		setIdentificacion(identificacion);
		setNombreCompleto(nombreClienteDomain);
		setCorreoElectronico(correoClienteDomain);
		setNumeroTelefonoMovil(numeroTelefonoMovilClienteDomain);
		
	}
	public static final ClienteDomain crear(final UUID id, final TipoIdentificacionEntity tipoIdentificacion, final String identificacion, final NombreCompletoClienteEntity nombreCliente,
		final CorreoElectronicoClienteEntity correoCliente, final NumeroTelefonoMovilClienteEntity numeroTelefonoMovilCliente) {
		
		return new ClienteDomain(id, null, identificacion, null, null, null);
				
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
	
}
