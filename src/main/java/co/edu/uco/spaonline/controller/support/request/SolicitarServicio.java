package co.edu.uco.spaonline.controller.support.request;

import java.util.UUID;

import co.edu.uco.spaonline.crosscutting.util.UtilNumero;
import co.edu.uco.spaonline.crosscutting.util.UtilUUID;


public class SolicitarServicio {
	
	private UUID id;
	private  SolicitarTipoServicio tiposervicio;
	private SolicitarInformacion informacion;
	private Integer precio;
	private Integer duracionHoraServicio;
	
	
	
	public SolicitarServicio() {
		super();
		setId(UtilUUID.UUIDDEFECTO);
		setTiposervicio(new SolicitarTipoServicio());
		setInformacion(new SolicitarInformacion());
		setPrecio(UtilNumero.NUMERODEFECTO);
		setDuracionHoraServicio(UtilNumero.NUMERODEFECTO);
	}
	
	public SolicitarServicio(UUID id, SolicitarTipoServicio tiposervicio, SolicitarInformacion informacion,
			Integer precio, Integer duracionHoraServicio) {
		super();
		setId(id);
		setTiposervicio(tiposervicio);
		setInformacion(informacion);
		setPrecio(precio);
		setDuracionHoraServicio(duracionHoraServicio);
	}

	public final void setId(UUID id) {
		this.id = id;
	}

	public final void setTiposervicio(SolicitarTipoServicio tiposervicio) {
		this.tiposervicio = tiposervicio;
	}

	public final void setInformacion(SolicitarInformacion informacion) {
		this.informacion = informacion;
	}

	public final void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public final void setDuracionHoraServicio(Integer duracionHoraServicio) {
		this.duracionHoraServicio = duracionHoraServicio;
	}

	public final UUID getId() {
		return id;
	}

	public final SolicitarTipoServicio getTiposervicio() {
		return tiposervicio;
	}

	public final SolicitarInformacion getInformacion() {
		return informacion;
	}

	public final Integer getPrecio() {
		return precio;
	}

	public final Integer getDuracionHoraServicio() {
		return duracionHoraServicio;
	}
	
	
	
	

}
