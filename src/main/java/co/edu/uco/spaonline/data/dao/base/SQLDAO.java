package co.edu.uco.spaonline.data.dao.base;

import java.sql.Connection;

import co.edu.uco.spaonline.crosscutting.exception.concrete.DataSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.util.UtilSQL;

public class SQLDAO {
	
	private Connection conexion;

	protected SQLDAO (final Connection conexion) {
		setConexion(conexion);
	}
	
	private final void setConexion(final Connection conexion) {
		 if(!UtilSQL.conexionAbierta(conexion)) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000004);
				var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000027);
				throw DataSpaOnlineException.crear(mensajeUsuario, mensajeTecnico);		
	        }
		 this.conexion = conexion;
	}
	
	protected final Connection getConexion() {
		return conexion;
	}

}
