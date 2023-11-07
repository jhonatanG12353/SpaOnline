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
import co.edu.uco.spaonline.crosscutting.util.UtilUUID;
import co.edu.uco.spaonline.data.dao.ServicioDAO;
import co.edu.uco.spaonline.data.dao.base.SQLDAO;
import co.edu.uco.spaonline.data.entity.ServicioEntity;
import co.edu.uco.spaonline.data.entity.TipoServicioEntity;
import co.edu.uco.spaonline.data.entity.support.InformacionServicioEntity;
public class ServicioPostgreSQLDAO extends SQLDAO implements ServicioDAO {
	
	public  ServicioPostgreSQLDAO (final Connection conexion) {
		super(conexion);
	}

	@Override
	public final void crear(final ServicioEntity entity) {
		
		final var sentencia = new StringBuilder();
		sentencia.append("INSERT INTO Cliente (id, tiposervicio, nombreservicio,descripcionservicio, precio, duracionhoraservicio ");
		sentencia.append("VALUES(?,?,?,?,?,?)");
		try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString()) ) {
			
			sentenciaPreparada.setObject(1, entity.getId());
			sentenciaPreparada.setObject(2, entity.getTipoServicio().getNombreTipoServicio());
			sentenciaPreparada.setString(3, entity.getInformacionServicio().getNombreServicio());
			sentenciaPreparada.setString(4, entity.getInformacionServicio().getDescripcionServicio());
			sentenciaPreparada.setObject(5, entity.getPrecio());
			sentenciaPreparada.setObject(6, entity.getDuracionHoraServicio());
			
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
	public final void modificar(final ServicioEntity entity) {	
final var sentencia = new StringBuilder();
	    
	    sentencia.append("UPDATE cliente ");
	    sentencia.append ("SET nombretiposervicio = ?, nombreservicio = ?, descripcionservicio = ?, precio = ?, duracionhoraservicio = ? ");
	    sentencia.append ("WHERE id = ?");
	    
	    try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString()) ) {
	        
			sentenciaPreparada.setObject(1, entity.getTipoServicio().getNombreTipoServicio());
			sentenciaPreparada.setString(2, entity.getInformacionServicio().getNombreServicio());
			sentenciaPreparada.setString(3, entity.getInformacionServicio().getDescripcionServicio());
			sentenciaPreparada.setObject(4, entity.getPrecio());
			sentenciaPreparada.setObject(5, entity.getDuracionHoraServicio());
	        sentenciaPreparada.setObject(6, entity.getId());
	        
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
	    sentencia.append("DELETE FROM servicio ");
	    sentencia.append ("WHERE id = ?");
	    
	    try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString()) ) {
	        sentenciaPreparada.setObject(1, id);
	        sentenciaPreparada.executeUpdate();
	    } catch (final SQLException excepcion) {
	        var mensajeUsuario = "Se ha presentado un problema tratando de eliminar la información del servicio...";
	        var mensajeTecnico = "Se ha presentado un problema de tipo SQLException en el método eliminar de la clase servicioPostgreSQL tratando de eliminar el servicio. Por favor, revise la traza completa del problema presentado para identificar lo que sucedió...";
	        throw DataSpaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
	    } catch (final Exception excepcion) {
	        var mensajeUsuario = "Se ha presentado un problema tratando de eliminar la información del cliente...";
	        var mensajeTecnico = "Se ha presentado un problema de tipo Exception en el método eliminar de la clase servicioPostgreSQL tratando de eliminar el servicio. Por favor, revise la traza completa del problema presentado para identificar lo que sucedió...";
	        throw DataSpaOnlineException.crear(excepcion, mensajeUsuario, mensajeTecnico);
	    }
		
	}

	@Override
	public final Optional<ServicioEntity> consultarPorId(final UUID id) {
		final var sentencia = new StringBuilder();
		sentencia.append("SELECT nombretiposervicio, nombreservicio, descripcionservicio, precio, duracionhoraservicio ");
		sentencia.append("FROM servicio ");
		sentencia.append("WHERE id= ?");
		
		Optional<ServicioEntity> resultado = Optional.empty();
		
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

	@Override
	public final List<ServicioEntity> consultar(final ServicioEntity entity) {
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
	private Optional<ServicioEntity> ejecutarConsultaPorId(final PreparedStatement sentenciaPreparada){
		Optional<ServicioEntity> resultado = Optional.empty();
		try(final var resultados = sentenciaPreparada.executeQuery()){
			if(resultados.next()) {
				UUID id = UtilUUID.convertirStringaUUID(resultados.getObject("id").toString());
	            TipoServicioEntity tipoServicio = (TipoServicioEntity) resultados.getObject("tiposervicio");
	            InformacionServicioEntity informacionServicio = (InformacionServicioEntity) resultados.getObject("informacionservicio");
	            Integer precio= resultados.getInt("precio");
	            Integer duracionhoraservicio = resultados.getInt("duracionhoraservicio");
	            
	            var servicioEntity = ServicioEntity.crear(id, tipoServicio, informacionServicio,precio,duracionhoraservicio);

				resultado= Optional.of(servicioEntity);
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
	private final String formarSentenciaConsulta(final ServicioEntity entity , final List <Object> parametros) {
		final StringBuilder sentencia = new StringBuilder();
		String operadorCondicional ="WHERE";
		
		sentencia.append("SELECT nombretiposervicio, nombreservicio, descripcionservicio, precio, duracionhoraservicio ");
		sentencia.append("FROM servicio ");
		if(!UtilObjeto.esNulo(entity)) {
			
			if(!UtilObjeto.esNulo(entity.getId())) {
				sentencia.append(operadorCondicional).append(" id = ? ");
				operadorCondicional = "AND";
				parametros.add(entity.getId());
			}
			if(!UtilObjeto.esNulo(entity.getTipoServicio().getNombreTipoServicio())) {
				sentencia.append(operadorCondicional).append(" nombretiposervicio = ? ");
				operadorCondicional = "AND";
				parametros.add(entity.getTipoServicio().getNombreTipoServicio());
			}
			if(!UtilObjeto.esNulo(entity.getInformacionServicio().getNombreServicio())) {
				sentencia.append(operadorCondicional).append(" nombreservicio = ? ");
				operadorCondicional = "AND";
				parametros.add(entity.getInformacionServicio().getNombreServicio());
			}
			if(!UtilObjeto.esNulo(entity.getInformacionServicio().getDescripcionServicio())) {
				sentencia.append(operadorCondicional).append(" descripcionservicio = ? ");
				parametros.add(entity.getInformacionServicio().getDescripcionServicio());
			}
			if(!UtilObjeto.esNulo(entity.getPrecio())) {
				sentencia.append(operadorCondicional).append(" precio = ? ");
				parametros.add(entity.getPrecio());
			}
			if(!UtilObjeto.esNulo(entity.getDuracionHoraServicio())) {
				sentencia.append(operadorCondicional).append(" duracionhoraservicio = ? ");
				parametros.add(entity.getDuracionHoraServicio());
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
	private final List<ServicioEntity> ejecutarConsulta (final PreparedStatement sentenciaPreparada){
		
		final var listaResultados = new ArrayList<ServicioEntity>();
		try(final var resultados = sentenciaPreparada.executeQuery()){
			while (resultados.next()) {
						
				UUID id = UtilUUID.convertirStringaUUID(resultados.getObject("id").toString());
	            TipoServicioEntity tipoServicio = (TipoServicioEntity) resultados.getObject("tiposervicio");
	            InformacionServicioEntity informacionServicio = (InformacionServicioEntity) resultados.getObject("informacionservicio");
	            Integer precio= resultados.getInt("precio");
	            Integer duracionhoraservicio = resultados.getInt("duracionhoraservicio");
	            
				var servicioEntity = ServicioEntity.crear(id, tipoServicio, informacionServicio,precio,duracionhoraservicio);
				
				listaResultados.add(servicioEntity);
					
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
