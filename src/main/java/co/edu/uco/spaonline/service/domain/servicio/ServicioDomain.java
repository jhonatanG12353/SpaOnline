package co.edu.uco.spaonline.service.domain.servicio;
import java.util.UUID;


import co.edu.uco.spaonline.service.domain.informacionservicio.InformacionServicioDomain;
import co.edu.uco.spaonline.service.domain.tiposervicio.TipoServicioDomain;

public class ServicioDomain {
	
	private UUID id;
	private  TipoServicioDomain tipoServicio;
	private InformacionServicioDomain informacionServicio;
	private Integer precio;
	private Integer duracionHoraServicio;
	
	private ServicioDomain( final UUID id, final TipoServicioDomain tipoServicio, final InformacionServicioDomain informacionServicio, final Integer precio,
			final Integer duracionHoraServicio) {
		
		setId(id);
		setTipoServicio(tipoServicio);
		setInformacionServicio(informacionServicio);
		setPrecio(precio);
		setDuracionHoraServicio(duracionHoraServicio);
	}
	
	public static final ServicioDomain crear ( final UUID id, final TipoServicioDomain tipoServicio, 
			final InformacionServicioDomain informacionServicio, final Integer precio,
			final Integer duracionHoraServicio) {
		return new ServicioDomain(id, tipoServicio, informacionServicio, precio, duracionHoraServicio);
	}
	

	private final void setId(UUID id) {
		this.id = id;
	}

	private final void setTipoServicio(TipoServicioDomain tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	private final void setInformacionServicio(InformacionServicioDomain informacionServicio) {
		this.informacionServicio = informacionServicio;
	}

	private final void setPrecio(Integer precio) {
		this.precio = precio;
	}

	private final void setDuracionHoraServicio(Integer duracionHoraServicio) {
		this.duracionHoraServicio = duracionHoraServicio;
	}

	public final UUID getId() {
		return id;
	}

	public final TipoServicioDomain getTipoServicio() {
		return tipoServicio;
	}

	public final InformacionServicioDomain getInformacionServicio() {
		return informacionServicio;
	}

	public final Integer getPrecio() {
		return precio;
	}

	public final Integer getDuracionHoraServicio() {
		return duracionHoraServicio;
	}

	
	
}
