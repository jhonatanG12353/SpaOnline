package co.edu.uco.spaonline.crosscutting.exception.concrete;

import co.edu.uco.spaonline.crosscutting.exception.SpaOnlineException;
import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.exception.enumerator.LugarException;

public class ServiceSpaOnlineException extends SpaOnlineException{

	private static final long serialVersionUID = -1983857422301149874L;
	
	protected ServiceSpaOnlineException(final Throwable excepcionRaiz, final String mensajeUsuario,
			final String mensajeTecnico) {
		super(LugarException.SERVICE, excepcionRaiz, mensajeUsuario, mensajeTecnico);
	}
	
	public static final SpaOnlineException crear(final String mensajeUsuario) {
		return new ServiceSpaOnlineException(null, mensajeUsuario,mensajeUsuario);
	}
	
	public static final SpaOnlineException crear (final String mensajeUsuario, final String mensajeTecnico) {
		return new ServiceSpaOnlineException(null, mensajeUsuario, mensajeTecnico);
	}
	
	public static final SpaOnlineException crear (final Throwable excepcionRaiz, final String mensajeUsuario, final String mensajeTecnico) {
		return new ServiceSpaOnlineException(excepcionRaiz, mensajeUsuario, mensajeTecnico);
	}


}
