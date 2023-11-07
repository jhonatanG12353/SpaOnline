package co.edu.uco.spaonline.service.domain.informacionservicio;

public class InformacionServicioDomain {
	
	private String nombreServicio;
	private String descripcionServicio;
	
	private InformacionServicioDomain(String nombreServicio, String descripcionServicio) {
		setNombreServicio(nombreServicio);
		setDescripcionServicio(descripcionServicio);
	}
	public static InformacionServicioDomain crear( final String nombreServicio,
			final String descripcionServicio) {
		
		return new InformacionServicioDomain (nombreServicio,descripcionServicio);
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
