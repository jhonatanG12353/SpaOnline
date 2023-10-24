package co.edu.uco.spaonline.crosscutting.messages;

import co.edu.uco.spaonline.crosscutting.exception.concrete.CrosscuttingSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CategoriaMensaje;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.TipoMensaje;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.crosscutting.util.UtilTexto;

public final class Mensaje {
	
	private CodigoMensaje codigo;
	private TipoMensaje tipo;
	private CategoriaMensaje categoria;
	private String contenido;
	private Mensaje(final CodigoMensaje codigo, final TipoMensaje tipo, final CategoriaMensaje categoria, final String contenido) {
		setCodigo(codigo);
		setTipo(tipo);
		setCategoria(categoria);
		setContenido(contenido);
	}
	
	public static final Mensaje crear(final CodigoMensaje codigo, final TipoMensaje tipo, final CategoriaMensaje categoria, final String contenido) {	
			return new Mensaje (codigo, tipo, categoria, contenido);
		}
	private final void setCodigo(final CodigoMensaje codigo) {
		if (UtilObjeto.esNulo(codigo)) {
			var mensajeUsuario=CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var  mensajeTecnico=CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000001);
			throw CrosscuttingSpaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		this.codigo = UtilObjeto.obtenerValorDefecto(codigo, null );
	}
	private final void setTipo(final TipoMensaje tipo) {
		this.tipo = UtilObjeto.obtenerValorDefecto(tipo, TipoMensaje.USUARIO);
	}
	private final void setCategoria(final CategoriaMensaje categoria) {
		this.categoria = UtilObjeto.obtenerValorDefecto(categoria, CategoriaMensaje.FATAL);
	}
	private final void setContenido(final String contenido) {
		this.contenido = UtilTexto.aplicarTrim(contenido);
	}
	public final CodigoMensaje getCodigo() {
		return codigo;
	}
	public final TipoMensaje getTipo() {
		return tipo;
	}
	public final CategoriaMensaje getCategoria() {
		return categoria;
	}
	public final String getContenido() {
		return contenido;
	} 
	
	

}
