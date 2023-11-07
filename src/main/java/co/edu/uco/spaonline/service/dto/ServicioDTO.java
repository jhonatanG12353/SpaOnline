package co.edu.uco.spaonline.service.dto;

import java.util.UUID;

import co.edu.uco.spaonline.data.entity.TipoServicioEntity;
import co.edu.uco.spaonline.data.entity.support.InformacionServicioEntity;
import co.edu.uco.spaonline.service.domain.informacionservicio.InformacionServicioDomain;
import co.edu.uco.spaonline.service.domain.tiposervicio.TipoServicioDomain;
import co.edu.uco.spaonline.service.dto.support.InformacionServicioDTO;

public final class ServicioDTO {
	
	private UUID id;
	private  TipoServicioDTO tipoServicio;
	private InformacionServicioDTO informacionServicio;
	private Integer precio;
	private Integer duracionHoraServicio;
	
	private ServicioDTO( final UUID id, final TipoServicioDTO tipoServicio, final InformacionServicioDTO informacionServicio, final Integer precio,
			final Integer duracionHoraServicio) {
		
		setId(id);
		setTipoServicio(tipoServicio);
		setInformacionServicio(informacionServicio);
		setPrecio(precio);
		setDuracionHoraServicio(duracionHoraServicio);
	}
	public static ServicioDTO crear(final UUID id, final TipoServicioDomain tipoServicioDomain, final InformacionServicioDomain informacionServicioDomain, final Integer precio,
			final Integer duracionHoraServicio) {
		return new ServicioDTO(id,null,null, precio,duracionHoraServicio);
	}
	public static ServicioDTO crear(UUID id, TipoServicioEntity tipoServicio,
			InformacionServicioEntity informacionServicio, Integer precio, Integer duracionHoraServicio) {
		return new ServicioDTO(id,null,null, precio, duracionHoraServicio);
	}

	private final void setId(UUID id) {
		this.id = id;
	}

	private final void setTipoServicio(TipoServicioDTO tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	private final void setInformacionServicio(InformacionServicioDTO informacionServicio) {
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
