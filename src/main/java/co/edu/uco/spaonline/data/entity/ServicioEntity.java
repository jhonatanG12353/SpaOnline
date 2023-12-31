package co.edu.uco.spaonline.data.entity;

import java.util.UUID;

import co.edu.uco.spaonline.data.entity.support.InformacionServicioEntity;

public final class ServicioEntity {
	
	private UUID id;
	private  TipoServicioEntity tipoServicio;
	private InformacionServicioEntity informacionServicio;
	private Integer precio;
	private Integer duracionHoraServicio;
	
	private ServicioEntity( final UUID id, final TipoServicioEntity tipoServicio, final InformacionServicioEntity informacionServicio, final Integer precio,
			final Integer duracionHoraServicio) {
		
		setId(id);
		setTipoServicio(tipoServicio);
		setInformacionServicio(informacionServicio);
		setPrecio(precio);
		setDuracionHoraServicio(duracionHoraServicio);
	}
	
	public static final ServicioEntity crear ( final UUID id, final TipoServicioEntity tipoServicio, final InformacionServicioEntity informacionServicio, final Integer precio,
			final Integer duracionHoraServicio) {
		return new ServicioEntity(id, tipoServicio, informacionServicio, precio, duracionHoraServicio);
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
