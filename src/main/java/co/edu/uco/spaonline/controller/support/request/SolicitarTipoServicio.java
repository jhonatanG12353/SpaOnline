package co.edu.uco.spaonline.controller.support.request;

import java.util.UUID;

import co.edu.uco.spaonline.crosscutting.util.UtilTexto;
import co.edu.uco.spaonline.crosscutting.util.UtilUUID;

public class SolicitarTipoServicio {
	
	private UUID id;
	private String nombreTipoServicio;
	
	public SolicitarTipoServicio() {
		super();
		setId(UtilUUID.UUIDDEFECTO);
		setNombreTipoServicio(UtilTexto.VACIO);
	}
	
	public SolicitarTipoServicio(UUID id, String nombreTipoServicio) {
		super();
		setId(id);
		setNombreTipoServicio(nombreTipoServicio);
	}

	public final void setId(UUID id) {
		this.id = id;
	}

	public final void setNombreTipoServicio(String nombreTipoServicio) {
		this.nombreTipoServicio = nombreTipoServicio;
	}

	public final UUID getId() {
		return id;
	}

	public final String getNombreTipoServicio() {
		return nombreTipoServicio;
	}
	
	
	

}
