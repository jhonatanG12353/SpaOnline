package co.edu.uco.spaonline.service.dto;

import java.util.UUID;

import co.edu.uco.spaonline.crosscutting.util.UtilTexto;
import co.edu.uco.spaonline.crosscutting.util.UtilUUID;

public final class TipoIdentificacionDTO {
	
	private UUID id;
	private String codigo;
	private String nombre;
	private boolean estado;
	
	
	public TipoIdentificacionDTO() {
		setId(UtilUUID.generarUUIDDefecto());
		setCodigo(UtilTexto.VACIO);
		setNombre(UtilTexto.VACIO);
		setEstado(false);
	
	}
	public TipoIdentificacionDTO(final UUID id,final  String codigo,final  String nombre, final boolean estado) {
		setId(id);
		setCodigo(codigo);
		setNombre(nombre);
		setEstado(estado);
	}
	public static TipoIdentificacionDTO crear(UUID id, String codigo, String nombre, boolean estado) {
		
		return new TipoIdentificacionDTO(id,codigo,nombre,estado);
	}
	
	public final TipoIdentificacionDTO setId(final UUID id) {	
			this.id = id;
		return this;
	}
	public final TipoIdentificacionDTO setCodigo(final String codigo) {
		this.codigo = codigo;
		return this;
	}
	public final TipoIdentificacionDTO setNombre(final String nombre) {
		this.nombre = nombre;
		return this;
	}
	public final TipoIdentificacionDTO setEstado(final boolean estado) {
		
		this.estado = estado;
		return this;
	}
	
	public static final TipoIdentificacionDTO crear() {
		return new TipoIdentificacionDTO();
	}
	public final UUID getId() {
		return id;
	}
	public final String getCodigo() {
		return codigo;
	}
	public final String getNombre() {
		return nombre;
	}
	public final boolean isEstado() {
		return estado;
	}
	
	
	
	
}