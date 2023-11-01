package co.edu.uco.spaonline.service.dto.support;

public class InformacionServicioDTO {
	
	private String nombreServicio;
	private String descripcionServicio;
	
	private InformacionServicioDTO(String nombreServicio, String descripcionServicio) {
		setNombreServicio(nombreServicio);
		setDescripcionServicio(descripcionServicio);
	}
	public static InformacionServicioDTO crear(final String nombreServicio, final String descripcionServicio) {
	
		return new InformacionServicioDTO(nombreServicio, descripcionServicio);
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
