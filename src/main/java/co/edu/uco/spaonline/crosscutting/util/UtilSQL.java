package co.edu.uco.spaonline.crosscutting.util;

import java.sql.Connection;
import java.sql.SQLException;

import co.edu.uco.spaonline.crosscutting.exception.concrete.CrosscuttingSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;

public class UtilSQL {
	
	private UtilSQL() {
		super();
	}
	
	public static final boolean conexionAbierta(final Connection conexion) {
		if(!UtilObjeto.esNulo(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico =CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000007);
			throw CrosscuttingSpaOnlineException.crear(mensajeUsuario,mensajeTecnico);
			}
		
		try {
			return !conexion.isClosed();
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000005);
			throw CrosscuttingSpaOnlineException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}
			catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000006);
			throw CrosscuttingSpaOnlineException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}
	}
	
	public static final void cerrarConexion (final Connection conexion)  {
		if(!UtilObjeto.esNulo(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico =CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000008);
			throw CrosscuttingSpaOnlineException.crear(mensajeUsuario,mensajeTecnico);
			}
		try {
			if(!conexionAbierta(conexion)) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
				var mensajeTecnico =CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000009);
				throw CrosscuttingSpaOnlineException.crear(mensajeUsuario,mensajeTecnico);
				}
			conexion.close();
		}
		catch(CrosscuttingSpaOnlineException excepcion){
			throw excepcion;
		} 
		catch(final SQLException excepcion){
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico =CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000013);
			throw CrosscuttingSpaOnlineException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}
		catch( final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico =CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000014);
			throw CrosscuttingSpaOnlineException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}
		}
		
		public static final void iniciarTransaccion (final Connection conexion){
			if(!UtilObjeto.esNulo(conexion)) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
				var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000010);
				throw CrosscuttingSpaOnlineException.crear(mensajeUsuario,mensajeTecnico);
				}
			try {
				if(!conexionAbierta(conexion)) {
					var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
					var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000011);
					throw CrosscuttingSpaOnlineException.crear(mensajeUsuario,mensajeTecnico);
					}
				if(!conexion.getAutoCommit()) {
					var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
					var mensajeTecnico =CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000012);
					throw CrosscuttingSpaOnlineException.crear(mensajeUsuario,mensajeTecnico);
					}
				conexion.setAutoCommit(false);
			}
			catch(CrosscuttingSpaOnlineException excepcion){
				throw excepcion;
			}
			catch(final SQLException excepcion){
				var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
				var mensajeTecnico =CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000015);
				throw CrosscuttingSpaOnlineException.crear(excepcion,mensajeUsuario,mensajeTecnico);
			}
			catch( final Exception excepcion) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
				var mensajeTecnico =CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000016);
				throw CrosscuttingSpaOnlineException.crear(excepcion,mensajeUsuario,mensajeTecnico);
			}
		}
		public static final void confirmarTransaccion(final Connection conexion) {

			if (UtilObjeto.esNulo(conexion)) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
				var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000017);
				throw CrosscuttingSpaOnlineException.crear(mensajeUsuario, mensajeTecnico);
			}

			try {
				if (!conexionAbierta(conexion)) {
					var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
					var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000018);
					throw CrosscuttingSpaOnlineException.crear(mensajeUsuario, mensajeTecnico);
				}

				if (conexion.getAutoCommit()) {
					var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
					var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000019);
					throw CrosscuttingSpaOnlineException.crear(mensajeUsuario, mensajeTecnico);
				}

				conexion.commit();
			} catch (final CrosscuttingSpaOnlineException excepcion) {
				throw excepcion;
			} catch (final SQLException excepcion) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
				var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000020);
				throw CrosscuttingSpaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
			} catch (final Exception excepcion) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
				var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000021);
				throw CrosscuttingSpaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
			}
		}

		public static final void cancelarTransaccion(final Connection conexion) {

			if (UtilObjeto.esNulo(conexion)) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
				var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000022);
				throw CrosscuttingSpaOnlineException.crear(mensajeUsuario, mensajeTecnico);
			}

			try {
				if (!conexionAbierta(conexion)) {
					var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
					var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000023);
					throw CrosscuttingSpaOnlineException.crear(mensajeUsuario, mensajeTecnico);
				}

				if (conexion.getAutoCommit()) {
					var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
					var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000024);
					throw CrosscuttingSpaOnlineException.crear(mensajeUsuario, mensajeTecnico);
				}

				conexion.rollback();
			} catch (final CrosscuttingSpaOnlineException excepcion) {
				throw excepcion;
			} catch (final SQLException excepcion) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
				var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000025);
				throw CrosscuttingSpaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
			} catch (final Exception excepcion) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
				var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000026);
				throw CrosscuttingSpaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
			}
		}

}
