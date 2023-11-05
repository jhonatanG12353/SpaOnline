package co.edu.uco.spaonline.data.dao.base;

import java.sql.Connection;

public class SQLDAO {
	
	private Connection conexion;
	

    // Constructor que recibe una conexión y la almacena en el atributo 'conexion'
	protected SQLDAO (final Connection conexion) {
		setConexion(conexion);
	}
	
	private final void setConexion(final Connection conexion) {
		//TODO: Controlar que la conexion no sea nula o que no esté cerrada o que ya no se haya confirmado una transacción		
		this.conexion = conexion;
	}
	
	// Método protegido para obtener la conexión
	protected final Connection getConexion() {
		return conexion;
	}

}
