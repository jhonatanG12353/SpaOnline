package co.edu.uco.spaonline.crosscutting.util;

import java.sql.Date;

public class UtilFechaDefecto {
	
	private UtilFechaDefecto() {
		super();
	}
	public static Date generarFechaInvalida() {
		Date date = new Date(150, 0, 1);
         return date;
    }
}