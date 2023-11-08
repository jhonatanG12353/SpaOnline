package co.edu.uco.spaonline.data.dao.concrete.postgresql;

import java.sql.Connection;
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
import co.edu.uco.spaonline.data.dao.TipoServicioDAO;
import co.edu.uco.spaonline.data.dao.base.SQLDAO;
import co.edu.uco.spaonline.data.entity.TipoServicioEntity;

public class TipoServicioPostgreSQLDAO extends SQLDAO implements TipoServicioDAO  {
	
	public  TipoServicioPostgreSQLDAO (final Connection conexion) {
		super(conexion);
	}

	@Override
	public final void crear(final TipoServicioEntity entity) {	
		final var sentencia = new StringBuilder();
		
		sentencia.append("INSERT INTO tiposervicio (id,nombretiposervicio) ");
		sentencia.append("VALUES(?,?)");
		
		try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString()) ) {
			
			sentenciaPreparada.setObject(1, entity.getId());
			sentenciaPreparada.setString(2, entity.getNombreTipoServicio());
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
	public final void modificar(final TipoServicioEntity entity) {	
		final var sentencia = new StringBuilder();
	    
	    sentencia.append("UPDATE tiposervicio ");
	    sentencia.append ("SET nombretiposervicio = ? ");
	    sentencia.append ("WHERE id = ?");
	    
	    try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString()) ) {
	        
	        sentenciaPreparada.setString(1, entity.getNombreTipoServicio());
	        sentenciaPreparada.setObject(2, entity.getId());
	        
	        sentenciaPreparada.executeUpdate();
	    }
	    catch(final SQLException excepcion){
	        var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000038);
	        var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000043);
	        throw DataSpaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
	    } catch (final Exception excepcion) {
	        var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000038);
	        var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000044);
	        throw DataSpaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
	    }

	}

	@Override
	public final void eliminar(final UUID id) {
		final var sentencia = new StringBuilder();
	    sentencia.append("DELETE FROM tiposervicio ");
	    sentencia.append ("WHERE id = ?");
	    
	    try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString()) ) {
	        sentenciaPreparada.setObject(1, id);
	        sentenciaPreparada.executeUpdate();
	    } catch (final SQLException excepcion) {
	        var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000039);
	        var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000045);
	        throw DataSpaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
	    } catch (final Exception excepcion) {
	        var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000039);
	        var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000046);
	        throw DataSpaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
	    }

	}

	@Override
	public final Optional<TipoServicioEntity> consultarPorId(final UUID id) {
		final var sentencia = new StringBuilder();
		sentencia.append("SELECT id,nombretiposervicio ");
		sentencia.append("FROM tiposervicio ");
		sentencia.append("WHERE id= ?");
		
		Optional<TipoServicioEntity> resultado = Optional.empty();
		
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
	private Optional<TipoServicioEntity> ejecutarConsultaPorId(final PreparedStatement sentenciaPreparada){
		Optional<TipoServicioEntity> resultado = Optional.empty();
		try(final var resultados = sentenciaPreparada.executeQuery()){
			if(resultados.next()) {
				var tipoServicioEntity = 
						TipoServicioEntity.crear(UtilUUID.convertirStringaUUID(resultados.getObject("id").toString()), resultados.getString("nombretiposervicio"));
				
				resultado= Optional.of(tipoServicioEntity);
			}
		}catch( final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000040);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000049);
			throw DataSpaOnlineException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}
		catch( final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000040);
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000050);
			throw DataSpaOnlineException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}
		return resultado;
	}
	
	
	private final String formarSentenciaConsulta(final TipoServicioEntity entity , final List <Object> parametros) {
		final StringBuilder sentencia = new StringBuilder();
		String operadorCondicional ="WHERE";
		
		sentencia.append("SELECT id, nombretiposervicio ");
		sentencia.append("FROM tiposervicio ");
		if(!UtilObjeto.esNulo(entity)) {
			
			if(!UtilObjeto.esNulo(entity.getId())) {
				sentencia.append(operadorCondicional).append(" id = ? ");
				operadorCondicional = "AND";
				parametros.add(entity.getId());
			}
			if(!UtilTexto.estaVacio(entity.getNombreTipoServicio())) {
				sentencia.append(operadorCondicional).append(" nombretiposervicio = ? ");
				operadorCondicional = "AND";
				parametros.add(entity.getNombreTipoServicio());
			}
		}
		sentencia.append("ORDER BY codigo ASC ");
		
		return sentencia.toString();
	}

	@Override
	public final List<TipoServicioEntity> consultar(final TipoServicioEntity entity) {
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
	
	private final List<TipoServicioEntity> ejecutarConsulta (final PreparedStatement sentenciaPreparada){
		
		final var listaResultados = new ArrayList<TipoServicioEntity>();
		try(final var resultados = sentenciaPreparada.executeQuery()){
			while (resultados.next()) {
				var tipoServicioEntity = TipoServicioEntity.crear(UUID.fromString(resultados.getObject("id").toString()), resultados.getString("nombretipoidentificacion"));
				
				listaResultados.add(tipoServicioEntity);
						
					
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
