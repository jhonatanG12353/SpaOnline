package co.edu.uco.spaonline.service.dto;

import java.util.UUID;


public class TipoServicioDTO {
	
	private UUID id;
	private String nombreTipoServicio;
	
	private TipoServicioDTO(UUID id, String nombreTipoServicio) {
		setId(id);
		setNombreTipoServicio(nombreTipoServicio);
	}
	public static final TipoServicioDTO crear (final UUID id, final String nombreTipoServicio) {
		return new TipoServicioDTO (id, nombreTipoServicio);
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
