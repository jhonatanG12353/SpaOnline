package co.edu.uco.spaonline.crosscutting.exception;

import co.edu.uco.spaonline.crosscutting.exception.enumerator.LugarException;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.crosscutting.util.UtilTexto;

public class SpaOnlineException extends RuntimeException {


	private static final long serialVersionUID = -551425372694998396L;
	private LugarException lugar;
	private Throwable excepcionRaiz;
	private String mensajeUsuario;
	private String mensajeTecnico;
	private boolean tieneExcepcionRaiz;
	
	
	protected SpaOnlineException(final LugarException lugar, final Throwable excepcionRaiz, final String mensajeUsuario,
			final String mensajeTecnico) {
		setLugar(lugar);
		setExcepcionRaiz(excepcionRaiz);
		setMensajeUsuario(mensajeUsuario);
		setMensajeTecnico(mensajeTecnico);
	}
	
	private final void setLugar( final LugarException lugar) {
		this.lugar = UtilObjeto.obtenerValorDefecto (lugar, LugarException.GENERAL); 
	}
	private final void setExcepcionRaiz(final Throwable excepcionRaiz) {
		this.excepcionRaiz = UtilObjeto.obtenerValorDefecto(excepcionRaiz, new Exception());
	}
	private final void setMensajeUsuario(final String mensajeUsuario) {
		this.mensajeUsuario = UtilTexto.aplicarTrim(mensajeUsuario);;
	}
	private final void setMensajeTecnico(final String mensajeTecnico) {
		this.mensajeTecnico = UtilTexto.aplicarTrim(mensajeTecnico);
	}
	
	private final void setTieneExcepcionRaiz(final boolean tieneExcepcionRaiz) {
		this.tieneExcepcionRaiz =tieneExcepcionRaiz;
	}

	public static final long getSerialversionuid() {
		return serialVersionUID;
	}
	public final LugarException getLugar() {
		return lugar;
	}
	public final Throwable getExcepcionRaiz() {
		return excepcionRaiz;
	}
	public final String getMensajeUsuario() {
		return mensajeUsuario;
	}
	public final String getMensajeTecnico() {
		return mensajeTecnico;
	}

	public final boolean isTieneExcepcionRaiz() {
		return tieneExcepcionRaiz;
	} 
	
	
	
	
	
}
