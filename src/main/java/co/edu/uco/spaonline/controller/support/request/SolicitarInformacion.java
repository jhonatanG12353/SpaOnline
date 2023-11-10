package co.edu.uco.spaonline.controller.support.request;

import co.edu.uco.spaonline.crosscutting.util.UtilTexto;

public class SolicitarInformacion {
	
	private String nombreServicio;
	private String descripcionServicio;
	
	public SolicitarInformacion() {
		super();
		setNombreServicio(UtilTexto.VACIO);
		setDescripcionServicio(UtilTexto.VACIO);
	}
	
	public SolicitarInformacion(String nombreServicio, String descripcionServicio) {
		super();
		setNombreServicio(nombreServicio);
		setDescripcionServicio(descripcionServicio);
	}
	public final void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}
	public final void setDescripcionServicio(String descripcionServicio) {
		this.descripcionServicio = descripcionServicio;
	}
	public final String getNombreServicio() {
		return nombreServicio;
	}
	public final String getDescripcionServicio() {
		return descripcionServicio;
	}
	
	

}
