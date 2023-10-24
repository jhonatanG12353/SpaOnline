package co.edu.uco.spaonline.crosscutting.exception.concrete;

import co.edu.uco.spaonline.crosscutting.exception.SpaOnlineException;
import co.edu.uco.spaonline.crosscutting.exception.enumerator.LugarException;

public class CrosscuttingSpaOnlineException extends SpaOnlineException{
	

		private static final long serialVersionUID = 6744095626690529725L;
		
		protected CrosscuttingSpaOnlineException(final Throwable excepcionRaiz, final String mensajeUsuario,
				final String mensajeTecnico) {
			super(LugarException.CROSSCUTTING, excepcionRaiz, mensajeUsuario, mensajeTecnico);
		}
		
		public static final SpaOnlineException crear(final String mensajeUsuario) {
			return new CrosscuttingSpaOnlineException(null, mensajeUsuario, mensajeUsuario);
		}
		
		public static final SpaOnlineException crear (final String mensajeUsuario, final String mensajeTecnico) {
			return new CrosscuttingSpaOnlineException(null, mensajeUsuario, mensajeTecnico);
		}
		
		public static final SpaOnlineException crear (final Throwable excepcionRaiz, final String mensajeUsuario, final String mensajeTecnico) {
			return new CrosscuttingSpaOnlineException(excepcionRaiz, mensajeUsuario, mensajeTecnico);
		}

	}



