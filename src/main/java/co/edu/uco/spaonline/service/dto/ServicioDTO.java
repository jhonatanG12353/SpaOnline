package co.edu.uco.spaonline.service.dto;

import java.util.UUID;

import co.edu.uco.spaonline.crosscutting.util.UtilUUID;
import co.edu.uco.spaonline.service.dto.support.InformacionServicioDTO;

public final class ServicioDTO {
	
	private UUID id;
	private  TipoServicioDTO tipoServicio;
	private InformacionServicioDTO informacionServicio;
	private Integer precio;
	private Integer duracionHoraServicio;
	
	public ServicioDTO() {
		setId(UtilUUID.UUIDDEFECTO);
		setTipoServicio(tipoServicio);
		setInformacionServicio(informacionServicio);
		setPrecio(precio);
		setDuracionHoraServicio(duracionHoraServicio);
	}
	
	
	public ServicioDTO( final UUID id, final TipoServicioDTO tipoServicio, final InformacionServicioDTO informacionServicio, final Integer precio,
			final Integer duracionHoraServicio) {
		
		setId(id);
		setTipoServicio(tipoServicio);
		setInformacionServicio(informacionServicio);
		setPrecio(precio);
		setDuracionHoraServicio(duracionHoraServicio);
	}
	public static final ServicioDTO crear(){
		return new ServicioDTO();
	}

	public final ServicioDTO setId(UUID id) {
		this.id = id;
		return this;
	}

	public final ServicioDTO setTipoServicio(TipoServicioDTO tipoServicio) {
		this.tipoServicio = tipoServicio;
		return this;
	}

	private final ServicioDTO setInformacionServicio(InformacionServicioDTO informacionServicio) {
		this.informacionServicio = informacionServicio;
		return this;
	}

	private final ServicioDTO setPrecio(Integer precio) {
		this.precio = precio;
		return this;
	}

	private final ServicioDTO setDuracionHoraServicio(Integer duracionHoraServicio) {
		this.duracionHoraServicio = duracionHoraServicio;
		return this;
	}
	

	public final UUID getId() {
		return id;
	}

	public final TipoServicioDTO getTipoServicio() {
		return tipoServicio;
	}

	public final InformacionServicioDTO getInformacionServicio() {
		return informacionServicio;
	}

	public final Integer getPrecio() {
		return precio;
	}

	public final Integer getDuracionHoraServicio() {
		return duracionHoraServicio;
	}
	
	

}
