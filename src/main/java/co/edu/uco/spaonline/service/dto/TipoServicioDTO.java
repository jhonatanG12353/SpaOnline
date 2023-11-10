package co.edu.uco.spaonline.service.dto;

import java.util.UUID;

import co.edu.uco.spaonline.crosscutting.util.UtilTexto;
import co.edu.uco.spaonline.crosscutting.util.UtilUUID;


public class TipoServicioDTO {
	
	private UUID id;
	private String nombreTipoServicio;
	
	public TipoServicioDTO() {
		setId(UtilUUID.UUIDDEFECTO);
		setNombreTipoServicio(UtilTexto.VACIO);
	}
	
	public TipoServicioDTO(UUID id, String nombreTipoServicio) {
		setId(id);
		setNombreTipoServicio(nombreTipoServicio);
	}
	public static final TipoServicioDTO crear () {
		return new TipoServicioDTO ();
	}
	
	public static final TipoServicioDTO crear (final UUID id,final String nombre) {
		return new TipoServicioDTO (id,nombre);
	}
	

	public final TipoServicioDTO setId(UUID id) {
		this.id = id;
		return this;
	}

	public final TipoServicioDTO setNombreTipoServicio(String nombreTipoServicio) {
		this.nombreTipoServicio = nombreTipoServicio;
		return this;
	}

	public final UUID getId() {
		return id;
	}

	public final String getNombreTipoServicio() {
		return nombreTipoServicio;
	} 
	
	

}
