package co.edu.uco.spaonline.data.dao.daofactory;

import co.edu.uco.spaonline.data.dao.daofactory.concrete.SQLServerDAOFactory;
import co.edu.uco.spaonline.data.dao.ClienteDAO;
import co.edu.uco.spaonline.data.dao.ServicioDAO;
import co.edu.uco.spaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.spaonline.data.dao.TipoServicioDAO;

public abstract class DAOFactory {
	
	public static final SQLServerDAOFactory obtenerDAOFactory (final TipoDAOFactory factoria) {
		switch (factoria) {
		case SQLSERVER:{
			return new SQLServerDAOFactory(); 
		}
		case POSTGRESQL:{
			throw new RuntimeException("Factoria no soportada"); 
		}
		case MYSQL:{
			throw new RuntimeException("Factoria no soportada"); 
		}
		case ORACLE:{
			throw new RuntimeException("Factoria no soportada"); 
		}
		default:
			throw new  RuntimeException("Factoria no soportada");
		}
	}
	
	protected abstract void abrirConexion();
	
	public abstract void cerrarConexion();
	
	public abstract void iniciarTransaccion();
	
	public abstract void confirmarTransaccion();
	
	public abstract void cancelarTransaccion(); 
	
	public abstract ClienteDAO obtenerClienteDAO();
	
	public abstract TipoIdentificacionDAO obtenerTipoIdentidicacionDAO ();
	
	public abstract ServicioDAO	obtenerServicioDAO();
	
	public abstract TipoServicioDAO obtenerTipoServicioDAO();

}
