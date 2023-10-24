package co.edu.uco.spaonline.data.entity;

import java.util.UUID;

import co.edu.uco.spaonline.data.entity.support.CorreoElectronicoClienteEntity;
import co.edu.uco.spaonline.data.entity.support.NombreCompletoClienteEntity;
import co.edu.uco.spaonline.data.entity.support.NumeroTelefonoMovilClienteEntity;
import co.edu.uco.spaonline.data.entity.ClienteEntity;
import co.edu.uco.spaonline.service.domain.support.CorreoElectronicoClienteDomain;
import co.edu.uco.spaonline.service.domain.support.NombreCompletoClienteDomain;
import co.edu.uco.spaonline.service.domain.support.NumeroTelefonoMovilClienteDomain;
import co.edu.uco.spaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;

public final class ClienteEntity {
	private UUID id;
	private TipoIdentificacionEntity tipoIdentificacion;
	private String identificacion;
	private NombreCompletoClienteEntity nombreCompleto;
	private CorreoElectronicoClienteEntity correoElectronico;
	private NumeroTelefonoMovilClienteEntity numeroTelefonoMovil;
	private ClienteEntity(final UUID id, final TipoIdentificacionEntity tipoIdentificacion, final String identificacion, final NombreCompletoClienteEntity nombreClienteEntity, final CorreoElectronicoClienteEntity correoClienteEntity, final NumeroTelefonoMovilClienteEntity numeroTelefonoMovilClienteEntity) {
		
		setId(id);
		setTipoIdentificacion(tipoIdentificacion);
		setIdentificacion(identificacion);
		setNombreCompleto(nombreClienteEntity);
		setCorreoElectronico(correoClienteEntity);
		setNumeroTelefonoMovil(numeroTelefonoMovilClienteEntity);
		
	}
	public static final ClienteEntity crear (final UUID id, final TipoIdentificacionDomain tipoIdentificacion, final String identificacion, final NombreCompletoClienteDomain nombreCompletoCliente, final CorreoElectronicoClienteDomain correoElectronicoCliente, final NumeroTelefonoMovilClienteDomain numeroTelefonoMovilCliente) {
		return new ClienteEntity (id, null, identificacion, null, null, null);
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
	

}
