package co.edu.uco.spaonline.crosscutting.util;

public final class UtilObjeto {
	
	public static final String VACIO="";

	private UtilObjeto() {
		super();
	}

	public static final <O> boolean esNulo(final O objeto) {
		return objeto == null;
	}
	public static final <O> boolean esNulooVacio(final O objeto) {
		return objeto == null && objeto == VACIO;
	}
	

	public static final <O> O obtenerValorDefecto(final O objeto, final O valorDefecto) {		
		return esNulo(objeto) ? valorDefecto: objeto;
	}
}
