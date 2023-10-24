package co.edu.uco.spaonline.crosscutting.exception.concrete;

import co.edu.uco.spaonline.crosscutting.exception.SpaOnlineException;
import co.edu.uco.spaonline.crosscutting.exception.concrete.DataSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.exception.enumerator.LugarException;

public final class DataSpaOnlineException  extends SpaOnlineException{
	

	private static final long serialVersionUID = -2727036418055792587L;
	
	protected DataSpaOnlineException(final Throwable excepcionRaiz, final String mensajeUsuario,
			final String mensajeTecnico) {
		super(LugarException.DATA, excepcionRaiz, mensajeUsuario, mensajeTecnico);

	}
	
	public static final SpaOnlineException crear(final String mensajeUsuario) {
		return new DataSpaOnlineException(null, mensajeUsuario, mensajeUsuario);
	}
	
	public static final SpaOnlineException crear (final String mensajeUsuario, final String mensajeTecnico) {
		return new DataSpaOnlineException(null, mensajeUsuario, mensajeTecnico);
	}
	
	public static final SpaOnlineException crear (final Throwable excepcionRaiz, final String mensajeUsuario, final String mensajeTecnico) {
		return new DataSpaOnlineException(excepcionRaiz, mensajeUsuario, mensajeTecnico);
	}

	

}
