package co.edu.uco.spaonline.data.entity;

import java.util.UUID;

public class TipoServicioEntity {
	
	private UUID id;
	private String nombreTipoServicio;
	
	private TipoServicioEntity(UUID id, String nombreTipoServicio) {
		setId(id);
		setNombreTipoServicio(nombreTipoServicio);
	}
	public static final TipoServicioEntity crear (final UUID id, final String nombreTipoServicio) {
		return new TipoServicioEntity(id, nombreTipoServicio);
	}

	private final void setId(UUID id) {
		this.id = id;
	}

	private final void setNombreTipoServicio(String nombreTipoServicio) {
		this.nombreTipoServicio = nombreTipoServicio;
	}

	public final UUID getId() {
		return id;
	}

	public final String getNombreTipoServicio() {
		return nombreTipoServicio;
	} 
	
	

}
