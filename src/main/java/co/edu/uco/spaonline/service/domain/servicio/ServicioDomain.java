package co.edu.uco.spaonline.service.domain.servicio;
import java.util.UUID;

import co.edu.uco.spaonline.data.entity.TipoServicioEntity;
import co.edu.uco.spaonline.data.entity.support.InformacionServicioEntity;
import co.edu.uco.spaonline.service.dto.TipoServicioDTO;
import co.edu.uco.spaonline.service.dto.support.InformacionServicioDTO;

public class ServicioDomain {
	
	private UUID id;
	private  TipoServicioEntity tipoServicio;
	private InformacionServicioEntity informacionServicio;
	private Integer precio;
	private Integer duracionHoraServicio;
	
	private ServicioDomain( final UUID id, final TipoServicioEntity tipoServicio, final InformacionServicioEntity informacionServicio, final Integer precio,
			final Integer duracionHoraServicio) {
		
		setId(id);
		setTipoServicio(tipoServicio);
		setInformacionServicio(informacionServicio);
		setPrecio(precio);
		setDuracionHoraServicio(duracionHoraServicio);
	}
	
	public static final ServicioDomain crear ( final UUID id, final TipoServicioEntity tipoServicioEntity, final InformacionServicioEntity informacionServicioEntity, final Integer precio,
			final Integer duracionHoraServicio) {
		return new ServicioDomain(id, tipoServicioEntity, informacionServicioEntity, precio, duracionHoraServicio);
	}
	
	public static ServicioDomain crear2(UUID id, TipoServicioDTO tipoServicio,
			InformacionServicioDTO informacionServicio, Integer precio, Integer duracionHoraServicio) {
		return new ServicioDomain(id, null, null, precio, duracionHoraServicio);
	}

	private final void setId(UUID id) {
		this.id = id;
	}

	private final void setTipoServicio(TipoServicioEntity tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	private final void setInformacionServicio(InformacionServicioEntity informacionServicio) {
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

	public final TipoServicioEntity getTipoServicio() {
		return tipoServicio;
	}

	public final InformacionServicioEntity getInformacionServicio() {
		return informacionServicio;
	}

	public final Integer getPrecio() {
		return precio;
	}

	public final Integer getDuracionHoraServicio() {
		return duracionHoraServicio;
	}

	
	
}
