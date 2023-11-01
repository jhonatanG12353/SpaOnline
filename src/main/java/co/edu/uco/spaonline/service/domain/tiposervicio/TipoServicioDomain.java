package co.edu.uco.spaonline.service.domain.tiposervicio;

import java.util.UUID;

public class TipoServicioDomain {
	
	private UUID id;
	private String nombreTipoServicio;
	
	private TipoServicioDomain(UUID id, String nombreTipoServicio) {
		setId(id);
		setNombreTipoServicio(nombreTipoServicio);
	}
	public static final TipoServicioDomain crear (final UUID id, final String nombreTipoServicio) {
		return new TipoServicioDomain(id, nombreTipoServicio);
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
