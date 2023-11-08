package co.edu.uco.spaonline.data.dao.daofactory.concrete;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import co.edu.uco.spaonline.crosscutting.exception.concrete.DataSpaOnlineException;

public class Configuracion {
	
	private static final Properties PROPIEDADES =new Properties();
		
	static {
		try (InputStream input =ClassLoader.getSystemResourceAsStream("config.properties")){
			PROPIEDADES.load(input);
		}catch(final IOException excepcion){
			String mensajeUsuario="";
			String mensajeTecnico="";
			throw DataSpaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		
		}
	}
	
	public static String obtenerURL() {
		return PROPIEDADES.getProperty("db.url");
	}
	
	public static String obtenerUsuario() {
		return PROPIEDADES.getProperty("db.usuario");
	}
	public static String obtenerContrasenia() {
		return PROPIEDADES.getProperty("db.contrasenia");
	}
}
