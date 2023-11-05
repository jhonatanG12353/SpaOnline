package co.edu.uco.spaonline.data.dao.daofactory.concrete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.uco.spaonline.data.dao.ClienteDAO;
import co.edu.uco.spaonline.data.dao.ServicioDAO;
import co.edu.uco.spaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.spaonline.data.dao.TipoServicioDAO;
import co.edu.uco.spaonline.data.dao.concrete.postgresql.ClientePostgreSQLDAO;
import co.edu.uco.spaonline.data.dao.concrete.postgresql.ServicioPostgreSQLDAO;
import co.edu.uco.spaonline.data.dao.concrete.postgresql.TipoIdentificacionPostgreSQLDAO;
import co.edu.uco.spaonline.data.dao.concrete.postgresql.TipoServicioPostgreSQLDAO;
import co.edu.uco.spaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.spaonline.crosscutting.exception.concrete.CrosscuttingSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.util.UtilSQL;
import co.edu.uco.spaonline.crosscutting.exception.concrete.DataSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;

public class PostgreSQLDAOFactory extends DAOFactory{

	private Connection conexion; 
	private boolean enTransaccion = false;
	
	public PostgreSQLDAOFactory () {
		abrirConexion();
	}

	@Override
	protected void abrirConexion() {
		try {
			
		       
            String url = "jdbc:postgresql://localhost:5432/DB_SPA_ONLINE";
            String usuario = "spaonline";
            String contraseña = "12353";
		conexion = DriverManager.getConnection(url, usuario, contraseña);
	} catch (final SQLException excepcion) {
		var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
		var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000028);
		throw DataSpaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
	} catch (final Exception excepcion) {
		var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
		var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000029);
		throw DataSpaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
	}
	}

	@Override
	public void cerrarConexion() {
		UtilSQL.cerrarConexion(conexion);
		
	}

	@Override
	public void iniciarTransaccion() {
		UtilSQL.iniciarTransaccion(conexion);
		
	}

	@Override
	public void confirmarTransaccion() {
		UtilSQL.confirmarTransaccion(conexion);	
		
	}

	@Override
	public void cancelarTransaccion() {
		UtilSQL.cancelarTransaccion(conexion);
		
	}

	@Override
	public ClienteDAO obtenerClienteDAO() {
		if (!UtilSQL.conexionAbierta(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000034);
			throw CrosscuttingSpaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}

		return new ClientePostgreSQLDAO(conexion);
	}

	@Override
	public TipoIdentificacionDAO obtenerTipoIdentificacionDAO() {
		if (!UtilSQL.conexionAbierta(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000035);
			throw CrosscuttingSpaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		return new TipoIdentificacionPostgreSQLDAO(conexion);
	}



	@Override
	public ServicioDAO obtenerServicioDAO() {
		if (!UtilSQL.conexionAbierta(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000035);
			throw CrosscuttingSpaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		return new ServicioPostgreSQLDAO(conexion);
	}

	@Override
	public TipoServicioDAO obtenerTipoServicioDAO() {
		if (!UtilSQL.conexionAbierta(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000035);
			throw CrosscuttingSpaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		return new TipoServicioPostgreSQLDAO(conexion);
	}

}
