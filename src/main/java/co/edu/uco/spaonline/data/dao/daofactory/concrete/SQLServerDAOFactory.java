package co.edu.uco.spaonline.data.dao.daofactory.concrete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.uco.spaonline.data.dao.ClienteDAO;
import co.edu.uco.spaonline.data.dao.ServicioDAO;
import co.edu.uco.spaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.spaonline.data.dao.TipoServicioDAO;
import co.edu.uco.spaonline.data.dao.concrete.sqlserver.ClienteSQLServerDAO;
import co.edu.uco.spaonline.data.dao.concrete.sqlserver.ServicioSQLServerDAO;
import co.edu.uco.spaonline.data.dao.concrete.sqlserver.TipoIdentificacionSQLServerDAO;
import co.edu.uco.spaonline.data.dao.concrete.sqlserver.TipoServicioSQLServerDAO;
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
	            
	            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");        
	            String url = "jdbc:sqlserver://localhost:1433;databaseName=localhost";
	            String usuario = "DESKTOP-UHNANUA";
	            String contraseña = "";
	            
	            conexion = DriverManager.getConnection(url, usuario, contraseña);
	        } catch (ClassNotFoundException | SQLException e) {
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
		return new ClienteSQLServerDAO(conexion);
	}

	@Override
	public TipoIdentificacionDAO obtenerTipoIdentidicacionDAO() {
		return new TipoIdentificacionSQLServerDAO(conexion);
	}
	@Override
	public ServicioDAO obtenerServicioDAO() {
		return new ServicioSQLServerDAO(conexion);
	}
	@Override
	public TipoServicioDAO obtenerTipoServicioDAO() {
		return new TipoServicioSQLServerDAO(conexion);
	}
	
	
}
