package co.edu.uco.spaonline.crosscutting.util;

import java.util.Random;
import java.util.UUID;

import co.edu.uco.spaonline.crosscutting.exception.concrete.DataSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;

public class UtilUUID {
	public static final UUID UUIDDEFECTO = new UUID(0L, 0L);
	private UtilUUID () {
		super();
	}
	public static UUID generarUUIDDefecto() {
        return new UUID(0L, 0L);
    }
	public static UUID convertirStringaUUID(String uuidString) {
        try {
            return UUID.fromString(uuidString);
        } catch (IllegalArgumentException excepcion) {
        	var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000040);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000058);
			throw DataSpaOnlineException.crear(excepcion,mensajeUsuario,mensajeTecnico);
        }
    }
	public static UUID generarUUIDAleatorio() {
        Random random = new Random();
        long mas = random.nextLong();
        long menos = random.nextLong();
        return new UUID(mas, menos);
    }
	public static final boolean esNulo(final UUID uuid) {
		return (uuid == null) || (uuid == UUIDDEFECTO);
	}
	public static final UUID obtenerValorDefecto(final UUID uuid, final UUID valorDefecto) {		
		return esNulo(uuid) ? valorDefecto: uuid;
	}
}
