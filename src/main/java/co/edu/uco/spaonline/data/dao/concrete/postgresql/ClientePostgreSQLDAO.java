package co.edu.uco.spaonline.data.dao.concrete.postgresql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import co.edu.uco.spaonline.crosscutting.exception.concrete.DataSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.data.dao.ClienteDAO;
import co.edu.uco.spaonline.data.dao.base.SQLDAO;
import co.edu.uco.spaonline.data.entity.ClienteEntity;

public final class ClientePostgreSQLDAO extends SQLDAO implements ClienteDAO {

	public  ClientePostgreSQLDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public final void crear(final ClienteEntity entity) {
		final var sentencia = new StringBuilder();
		sentencia.append("INSERT INTO Cliente (id,tipoidentificacion,identificacion,primernombre,segundonombre,primerapellido,segundoapellido,correocliente,"
				+ "correoelectronicoconfirmado,numerotelefonomovil,numerotelefonomovilconfirmado,fechanacimiento) ");
		sentencia.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString()) ) {
			
			sentenciaPreparada.setObject(1, entity.getId());
			sentenciaPreparada.setObject(2, entity.getTipoIdentificacion().getNombre());
			sentenciaPreparada.setString(3, entity.getIdentificacion());
			sentenciaPreparada.setObject(4, entity.getNombreCompleto().getPrimerNombre());
			sentenciaPreparada.setObject(5, entity.getNombreCompleto().getSegundoNombre());
			sentenciaPreparada.setObject(6, entity.getNombreCompleto().getPrimerApellido());
			sentenciaPreparada.setObject(7, entity.getNombreCompleto().getSegundoApellido());
			sentenciaPreparada.setObject(8, entity.getCorreoElectronico().getCorreoElectronico());
			sentenciaPreparada.setObject(9, entity.getCorreoElectronico().isCorreoElectronicoConfirmado());
			sentenciaPreparada.setObject(10, entity.getNumeroTelefonoMovil().getNumeroTelefonoMovil());
			sentenciaPreparada.setObject(11, entity.getNumeroTelefonoMovil().isNumeroTelefonoConfirmado());
			sentenciaPreparada.setDate(12, entity.getFechaNacimiento());
			
			sentenciaPreparada.executeUpdate();
		}
		catch(final SQLException excepcion){
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000037);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000041);
			throw DataSpaOnlineException.crear(excepcion, mensajeUsuario,mensajeTecnico);
		}catch(final Exception excepcion){
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000037);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000042);
			throw DataSpaOnlineException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}
	}

	@Override
	public final void modificar(final ClienteEntity entity) {
		final var sentencia = new StringBuilder();
	    
	    sentencia.append("UPDATE cliente ");
	    sentencia.append ("SET tipoidentificacion = ?, identificacion = ?, primernombre = ?, segundonombre = ?, primerapellido = ?,"
	    		+ "segundoapellido = ?, correoelectronico = ?, correoelectronicoconfirmado = ?, numerotelefonomovil = ?, numerotelefonomovilconfirmado = ?, fechanacimiento = ? ");
	    sentencia.append ("WHERE id = ?");
	    
	    try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString()) ) {
	        
	        sentenciaPreparada.setObject(1, entity.getTipoIdentificacion().getNombre());
	        sentenciaPreparada.setString(2, entity.getIdentificacion());
	        sentenciaPreparada.setObject(3, entity.getNombreCompleto().getPrimerNombre());
	        sentenciaPreparada.setObject(4, entity.getNombreCompleto().getSegundoNombre());
	        sentenciaPreparada.setObject(5, entity.getNombreCompleto().getPrimerApellido());
	        sentenciaPreparada.setObject(6, entity.getNombreCompleto().getSegundoApellido());
	        sentenciaPreparada.setObject(7, entity.getCorreoElectronico().getCorreoElectronico());
	        sentenciaPreparada.setObject(8, entity.getCorreoElectronico().isCorreoElectronicoConfirmado());
	        sentenciaPreparada.setObject(9, entity.getNumeroTelefonoMovil().getNumeroTelefonoMovil());
	        sentenciaPreparada.setObject(10, entity.getNumeroTelefonoMovil().isNumeroTelefonoConfirmado());
	        sentenciaPreparada.setObject(11, entity.getFechaNacimiento());
	        sentenciaPreparada.setObject(12, entity.getId());
	        
	        sentenciaPreparada.executeUpdate();
	    }
	    catch(final SQLException excepcion){
	        var mensajeUsuario = "se ha presentado un problema tratando de modificar un Cliente";
	        var mensajeTecnico = "Se ha presentado un problema de tipo SQLException en el método modificar de la clase ClientePostegreSQL tratando de llevar a cabo la modificación del Cliente. Por favor, revise la traza completa del problema presentado para identificar lo que sucedió...";
	        throw DataSpaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
	    } catch (final Exception excepcion) {
	        var mensajeUsuario = "se ha presentado un problema tratando de modificar un Cliente";
	        var mensajeTecnico = "Se ha presentado un problema de tipo Exception en el método modificar de la clase ClientePostegreSQL tratando de llevar a cabo la modificación del Cliente. Por favor, revise la traza completa del problema presentado para identificar lo que sucedió...";
	        throw DataSpaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
	    }
		
	}

	@Override
	public final void eliminar(final UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final Optional<ClienteEntity> consultarPorId(final UUID id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public final List<ClienteEntity> consultar(final ClienteEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
