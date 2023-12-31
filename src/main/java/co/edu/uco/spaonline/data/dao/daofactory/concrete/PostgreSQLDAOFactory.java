package co.edu.uco.spaonline.data.dao.daofactory.concrete;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

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
	
	
	public PostgreSQLDAOFactory () {
		abrirConexion();
	}

	@Override
	protected void abrirConexion() {
		       
 
            try {
            	Properties prop = new Properties();
				InputStream input = getClass().getResourceAsStream("/application.properties");
				prop.load(input);
				String url = prop.getProperty("db.url");
				String usuario = prop.getProperty("db.user");
				String contresenia = prop.getProperty("db.password");
		        
		        if (url == null || url.isEmpty() || usuario == null || usuario.isEmpty() || contresenia == null || contresenia.isEmpty()) {
		        	var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
					var mensajeTecnico = "No se pudieron obtener credenciales de la base de datos";
					throw DataSpaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		        }
			
			conexion = DriverManager.getConnection(url, usuario, contresenia);
            } catch (SQLException e) {
    			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
    			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000024);
    			throw DataSpaOnlineException.crear(e, mensajeUsuario, mensajeTecnico);
            } catch (Exception e) {
    			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
    			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000025);
    			throw DataSpaOnlineException.crear(e, mensajeUsuario, mensajeTecnico);        	
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
