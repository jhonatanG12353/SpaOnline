package co.edu.uco.spaonline.crosscutting.util;

import java.sql.Date;
import java.util.Objects;

public class UtilFechaDefecto {
	
	public static final Date FECHADEFECTO = Date.valueOf("2500-12-31");

    private UtilFechaDefecto() {
        super();
    }

    public static final boolean esNulo(final Date fecha) {
        return Objects.isNull(fecha) || fecha == FECHADEFECTO;
    }

    public static final Date obtenerValorDefecto(final Date fecha, final Date valorDefecto) {
        return esNulo(fecha) ? valorDefecto : fecha;
    }
}