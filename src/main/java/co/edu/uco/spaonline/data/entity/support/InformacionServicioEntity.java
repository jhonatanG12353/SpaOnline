package co.edu.uco.spaonline.data.entity.support;

public class InformacionServicioEntity {
	
	private String nombreServicio;
	private String descripcionServicio;
	
	private InformacionServicioEntity(String nombreServicio, String descripcionServicio) {
		setNombreServicio(nombreServicio);
		setDescripcionServicio(descripcionServicio);
	}
	public static InformacionServicioEntity crear(final String nombre, final String descripcionServicio) {
		
		return new InformacionServicioEntity(nombre,descripcionServicio );
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
