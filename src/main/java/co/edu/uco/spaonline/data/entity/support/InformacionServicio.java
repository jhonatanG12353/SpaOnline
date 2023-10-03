package co.edu.uco.spaonline.data.entity.support;

public class InformacionServicio {
	
	private String nombreServicio;
	private String descripcionServicio;
	
	private InformacionServicio(String nombreServicio, String descripcionServicio) {
		setNombreServicio(nombreServicio);
		setDescripcionServicio(descripcionServicio);
	}
	private final void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}
	private final void setDescripcionServicio(String descripcionServicio) {
		this.descripcionServicio = descripcionServicio;
	}
	public final String getNombreServicio() {
		return nombreServicio;
	}
	public final String getDescripcionServicio() {
		return descripcionServicio;
	}
	

}
