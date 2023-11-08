package co.edu.uco.spaonline.crosscutting.util;

public class UtilNumero {

	public static boolean longitudMinimaValida (final Integer valor, final int longitud) {
		String numero = String.valueOf(valor);
		return UtilTexto.aplicarTrim(numero).length()>= longitud;
	}
	public static boolean longitudMaximaValida (final Integer dato, final int longitud) {
		String numero = String.valueOf(dato);
		return UtilTexto.aplicarTrim(numero).length()<= longitud;
	}
	public static final boolean estaNulo(final Integer valor) {
		return UtilObjeto.esNulo(valor);
	}

}
