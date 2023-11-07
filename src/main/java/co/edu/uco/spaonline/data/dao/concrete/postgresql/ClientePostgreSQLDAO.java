package co.edu.uco.spaonline.data.dao.concrete.postgresql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import co.edu.uco.spaonline.crosscutting.exception.concrete.DataSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.crosscutting.util.UtilTexto;
import co.edu.uco.spaonline.crosscutting.util.UtilUUID;
import co.edu.uco.spaonline.data.dao.ClienteDAO;
import co.edu.uco.spaonline.data.dao.base.SQLDAO;
import co.edu.uco.spaonline.data.entity.ClienteEntity;
import co.edu.uco.spaonline.data.entity.TipoIdentificacionEntity;
import co.edu.uco.spaonline.data.entity.support.BooleanEntity;
import co.edu.uco.spaonline.data.entity.support.CorreoElectronicoClienteEntity;
import co.edu.uco.spaonline.data.entity.support.NombreCompletoClienteEntity;
import co.edu.uco.spaonline.data.entity.support.NumeroTelefonoMovilClienteEntity;

public final class ClientePostgreSQLDAO extends SQLDAO implements ClienteDAO {

	public  ClientePostgreSQLDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public final void crear(final ClienteEntity entity) {
		final var sentencia = new StringBuilder();
		sentencia.append("INSERT INTO Cliente (id,tipoidentificacion,identificacion,primernombre,segundonombre,primerapellido,segundoapellido,correocliente,"
				+ "correoelectronicoconfirmado,numerotelefonomovil,numerotelefonomovilconfirmado,fechanacimiento ");
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
			sentenciaPreparada.setObject(11, entity.getNumeroTelefonoMovil().isNumeroTelefonoMovilConfirmado());
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
	        sentenciaPreparada.setObject(10, entity.getNumeroTelefonoMovil().isNumeroTelefonoMovilConfirmado());
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
		final var sentencia = new StringBuilder();
	    sentencia.append("DELETE FROM cliente ");
	    sentencia.append ("WHERE id = ?");
	    
	    try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString()) ) {
	        sentenciaPreparada.setObject(1, id);
	        sentenciaPreparada.executeUpdate();
	    } catch (final SQLException excepcion) {
	        var mensajeUsuario = "Se ha presentado un problema tratando de eliminar la información del cliente...";
	        var mensajeTecnico = "Se ha presentado un problema de tipo SQLException en el método eliminar de la clase ClientePostgreSQL tratando de eliminar el Cliente. Por favor, revise la traza completa del problema presentado para identificar lo que sucedió...";
	        throw DataSpaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
	    } catch (final Exception excepcion) {
	        var mensajeUsuario = "Se ha presentado un problema tratando de eliminar la información del cliente...";
	        var mensajeTecnico = "Se ha presentado un problema de tipo Exception en el método eliminar de la clase ClientePostgreSQL tratando de eliminar el Cliente. Por favor, revise la traza completa del problema presentado para identificar lo que sucedió...";
	        throw DataSpaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
	    }
		
	}

	@Override
	public final Optional<ClienteEntity> consultarPorId(final UUID id) {
		final var sentencia = new StringBuilder();
		sentencia.append("SELECT id,tipoidentificacion, identificacion, primernombre, segundonombre,"
				+ "primerapellido, segundoapellido, correoelectronico, correoelectronicoconfirmado, numerotelefonomovil, "
				+ "numerotelefonomovilconfirmado, fechanacimiento ");
		sentencia.append("FROM cliente ");
		sentencia.append("WHERE id= ?");
		
		Optional<ClienteEntity> resultado = Optional.empty();
		
		try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())){
			
			sentenciaPreparada.setObject(1, id);
			
			resultado = ejecutarConsultaPorId(sentenciaPreparada);
			
		}catch(final DataSpaOnlineException excepcion) {
			throw excepcion;
		}
		catch(final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000040);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000047);
			throw DataSpaOnlineException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}
		catch(final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000040);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000048);
			throw DataSpaOnlineException.crear(excepcion,mensajeUsuario,mensajeTecnico);
			
		}

		return resultado;
	}
	private Optional<ClienteEntity> ejecutarConsultaPorId(final PreparedStatement sentenciaPreparada){
Optional<ClienteEntity> resultado = Optional.empty();
		
		try (final var resultados = sentenciaPreparada.executeQuery()) {
			
			if (resultados.next()) {
				var clienteEntity = ClienteEntity.crear(UUID.fromString(resultados.getObject("id").toString()),
						TipoIdentificacionEntity.crear(
								UUID.fromString(resultados.getObject("tipoIdentificacion").toString()),
								resultados.getString("codigo"), resultados.getString("nombre"),
								BooleanEntity.crear(resultados.getBoolean("estado"), false)),
						resultados.getString("identificacion"),
						NombreCompletoClienteEntity.crear(resultados.getString("primerNombre"),
								resultados.getString("segundoNombre"), resultados.getString("primerApellido"),
								resultados.getString("segundoApellido")),
						CorreoElectronicoClienteEntity.crear(resultados.getString("correoElectronico"),
								BooleanEntity.crear(resultados.getBoolean("correoElectronicoConfirmado"), false)),
						NumeroTelefonoMovilClienteEntity.crear(resultados.getString("numeroTelefonoMovil"),
								BooleanEntity.crear(resultados.getBoolean("numeroTelefonoMovilConfirmado"), false)),
						resultados.getDate("fechaNacimiento"));
				resultado = Optional.of(clienteEntity);
			}
		} catch (SQLException e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000065);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000066);
			throw DataSpaOnlineException.crear(e, mensajeUsuario, mensajeTecnico);
		} catch (Exception e) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000065);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000067);
			throw DataSpaOnlineException.crear(e, mensajeUsuario, mensajeTecnico);		
		}
		
		return resultado;
	}

	@Override
	public final List<ClienteEntity> consultar(final ClienteEntity entity) {
		final var parametros = new ArrayList<Object>();
		final String sentencia = formarSentenciaConsulta(entity,parametros); 
		
		try (final var sentenciaPreparada = getConexion().prepareStatement(sentencia)){
			
			colocarParametrosConsulta(sentenciaPreparada, parametros );
			 return ejecutarConsulta(sentenciaPreparada);
			 
		}catch(final DataSpaOnlineException excepcion) {
			throw excepcion;
		}
		catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000040);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000051);
			throw DataSpaOnlineException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}
		catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000040);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000052);
			throw DataSpaOnlineException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}
	}
	private final String formarSentenciaConsulta(final ClienteEntity entity , final List <Object> parametros) {
		final StringBuilder sentencia = new StringBuilder();
		String operadorCondicional ="WHERE";
		
		sentencia.append("\"SELECT id,tipoidentificacion, identificacion, primernombre, segundonombre,"
				+ " primerapellido, segundoapellido, correoelectronico, correoelectronicoconfirmado, numerotelefonomovil, "
				+ " numerotelefonomovilconfirmado, fechanacimiento ");
		sentencia.append("FROM tipoidentificacion ");
		if(!UtilObjeto.esNulo(entity)) {
			
			if(!UtilObjeto.esNulo(entity.getId())) {
				sentencia.append(operadorCondicional).append(" id = ? ");
				operadorCondicional = "AND";
				parametros.add(entity.getId());
			}
			if(!UtilObjeto.esNulo(entity.getTipoIdentificacion())) {
				sentencia.append(operadorCondicional).append(" tipoidentificacion = ? ");
				operadorCondicional = "AND";
				parametros.add(entity.getTipoIdentificacion());
			}
			if(!UtilTexto.estaVacio(entity.getIdentificacion())) {
				sentencia.append(operadorCondicional).append(" identificacion = ? ");
				operadorCondicional = "AND";
				parametros.add(entity.getIdentificacion());
			}
			if(!UtilObjeto.esNulo(entity.getNombreCompleto().getPrimerNombre())) {
				sentencia.append(operadorCondicional).append(" primernombre = ? ");
				parametros.add(entity.getNombreCompleto().getPrimerNombre());
			}
			if(!UtilObjeto.esNulo(entity.getNombreCompleto().getSegundoNombre())) {
				sentencia.append(operadorCondicional).append(" segundonombre = ? ");
				parametros.add(entity.getNombreCompleto().getSegundoNombre());
			}
			if(!UtilObjeto.esNulo(entity.getNombreCompleto().getPrimerApellido())) {
				sentencia.append(operadorCondicional).append(" primerapellido = ? ");
				parametros.add(entity.getNombreCompleto().getPrimerApellido());
			}
			if(!UtilObjeto.esNulo(entity.getNombreCompleto().getSegundoApellido())) {
				sentencia.append(operadorCondicional).append(" segundoapellido = ? ");
				parametros.add(entity.getNombreCompleto().getSegundoApellido());
			}
			if(!UtilObjeto.esNulo(entity.getCorreoElectronico().getCorreoElectronico())) {
				sentencia.append(operadorCondicional).append(" correoelectronico = ? ");
				parametros.add(entity.getCorreoElectronico().getCorreoElectronico());
			}
			if(!UtilObjeto.esNulo(entity.getCorreoElectronico().isCorreoElectronicoConfirmado())) {
				sentencia.append(operadorCondicional).append(" correoelectronicoconfirmado = ? ");
				parametros.add(entity.getCorreoElectronico().isCorreoElectronicoConfirmado());
			}
			if(!UtilObjeto.esNulo(entity.getNumeroTelefonoMovil().getNumeroTelefonoMovil())) {
				sentencia.append(operadorCondicional).append(" numerotelefonomovil = ? ");
				parametros.add(entity.getNumeroTelefonoMovil().getNumeroTelefonoMovil());
			}
			if(!UtilObjeto.esNulo(entity.getNumeroTelefonoMovil().isNumeroTelefonoMovilConfirmado())) {
				sentencia.append(operadorCondicional).append(" numerotelefonomovilconfirmado = ? ");
				parametros.add(entity.getNumeroTelefonoMovil().isNumeroTelefonoMovilConfirmado());
			}
			
			if(!UtilObjeto.esNulo(entity.getFechaNacimiento())) {
				sentencia.append(operadorCondicional).append(" fechanacimiento = ? ");
				parametros.add(entity.getFechaNacimiento());
			}
		}
		sentencia.append("ORDER BY codigo ASC ");
		
		return sentencia.toString();
	}
	private final void colocarParametrosConsulta(final PreparedStatement sentenciaPreparada, final List<Object> parametros ) {
		try {
			for (int indice = 0; indice < parametros.size(); indice++) {
				sentenciaPreparada.setObject(indice + 1 , parametros.get(indice));
			}
			
		}catch(final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000040);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000053);
			throw DataSpaOnlineException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}
		catch(final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000040);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000054);
			throw DataSpaOnlineException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}
	}
	private final List<ClienteEntity> ejecutarConsulta (final PreparedStatement sentenciaPreparada){
		
		final var listaResultados = new ArrayList<ClienteEntity>();
		try(final var resultados = sentenciaPreparada.executeQuery()){
			while (resultados.next()) {
						
				UUID id = UtilUUID.convertirStringaUUID(resultados.getObject("id").toString());
	            TipoIdentificacionEntity tipoIdentificacion = (TipoIdentificacionEntity) resultados.getObject("tipoidentificacion");
	            String identificacion = resultados.getString("identificacion");
	            NombreCompletoClienteEntity nombreCompleto = (NombreCompletoClienteEntity) resultados.getObject("nombrecompleto");
	            CorreoElectronicoClienteEntity correoElectronico = (CorreoElectronicoClienteEntity) resultados.getObject("correoelectronico");
	            NumeroTelefonoMovilClienteEntity numeroTelefono = (NumeroTelefonoMovilClienteEntity) resultados.getObject("numerotelefono");
	            Date fechaNacimiento = resultados.getDate("fechanacimiento");
	            
				var clienteEntity = ClienteEntity.crear(id, tipoIdentificacion, identificacion, nombreCompleto, correoElectronico, numeroTelefono, fechaNacimiento);
				
				listaResultados.add(clienteEntity);
					
			}
		}catch( final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000040);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000055);
			throw DataSpaOnlineException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}
		catch( final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000040);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000056);
			throw DataSpaOnlineException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}
		return listaResultados;
	}

}
