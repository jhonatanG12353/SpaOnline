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

public final class SQLServerDAOFactory extends DAOFactory{
	private Connection conexion; 
	private boolean enTransaccion = false;
	
	public SQLServerDAOFactory() {
		abrirConexion();
	}

	@Override
	protected final void abrirConexion() {
		 try {
	            
	                 
	            String url = "jdbc:postgresql://localhost:5432/DB_SPA_ONLINE";
	            String usuario = "postgres";
	            String contraseña = "12353";
	            
	            conexion = DriverManager.getConnection(url, usuario, contraseña);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public final void cerrarConexion() {
		 try {
	            if (conexion != null && !conexion.isClosed()) {
	                conexion.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public final void iniciarTransaccion() {
		try {
            if (!enTransaccion) {
                conexion.setAutoCommit(false);
                enTransaccion = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public final void confirmarTransaccion() {
		try {
            if (enTransaccion) {
                conexion.commit();
                conexion.setAutoCommit(true);
                enTransaccion = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public final  void cancelarTransaccion() {
		 try {
	            if (enTransaccion) {
	                conexion.rollback();
	                conexion.setAutoCommit(true);
	                enTransaccion = false;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public ClienteDAO obtenerClienteDAO() {
		return new ClientePostgreSQLDAO(conexion);
	}

	@Override
	public TipoIdentificacionDAO obtenerTipoIdentificacionDAO() {
		return new TipoIdentificacionPostgreSQLDAO(conexion);
	}
	@Override
	public ServicioDAO obtenerServicioDAO() {
		return new ServicioPostgreSQLDAO(conexion);
	}
	@Override
	public TipoServicioDAO obtenerTipoServicioDAO() {
		return new TipoServicioPostgreSQLDAO(conexion);
	}
	
	
}
