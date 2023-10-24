package co.edu.uco.spaonline.crosscutting.exception.concrete;

import co.edu.uco.spaonline.crosscutting.exception.SpaOnlineException;
import co.edu.uco.spaonline.crosscutting.exception.concrete.ControllerSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.exception.enumerator.LugarException;

public final class ControllerSpaOnlineException extends SpaOnlineException{


	private static final long serialVersionUID = 6744095626690529725L;
	
	protected ControllerSpaOnlineException(final Throwable excepcionRaiz, final String mensajeUsuario,
			final String mensajeTecnico) {
		super(LugarException.CONTROLLER, excepcionRaiz, mensajeUsuario, mensajeTecnico);
	}
	
	public static final SpaOnlineException crear(final String mensajeUsuario) {
		return new ControllerSpaOnlineException(null, mensajeUsuario, mensajeUsuario);
	}
	
	public static final SpaOnlineException crear (final String mensajeUsuario, final String mensajeTecnico) {
		return new ControllerSpaOnlineException(null, mensajeUsuario, mensajeTecnico);
	}
	
	public static final SpaOnlineException crear (final Throwable excepcionRaiz, final String mensajeUsuario, final String mensajeTecnico) {
		return new ControllerSpaOnlineException(excepcionRaiz, mensajeUsuario, mensajeTecnico);
	}

	

}
