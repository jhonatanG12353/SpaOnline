package co.edu.uco.spaonline.controller.tipoidentificacion.concrete;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.spaonline.controller.support.response.Respuesta;
import co.edu.uco.spaonline.crosscutting.exception.SpaOnlineException;
import co.edu.uco.spaonline.service.dto.TipoIdentificacionDTO;
import co.edu.uco.spaonline.service.facade.concrete.tipoidentificacion.RegistrarTipoIdentificacionFacade;
import co.edu.uco.spaonline.controller.tipoidentificacion.TipoIdentificacionController;

@RestController
@RequestMapping("/api/v1/tipoidentificacion")
public class TipoIdentificacionControllerImpl implements TipoIdentificacionController {
	
	private static final Logger LOGGER =  LoggerFactory.getLogger(TipoIdentificacionController.class);
	
	@GetMapping("/dummy")
	@Override 
	public final TipoIdentificacionDTO obtenerDummy() {
		LOGGER.info("El Dummy de tipo de identificacion se genero exitosamente");
		return TipoIdentificacionDTO.crear();
	}
	
	@PostMapping
	@Override 
	public final ResponseEntity<Respuesta<TipoIdentificacionDTO>> registrar(@RequestBody TipoIdentificacionDTO dto) {
		Respuesta<TipoIdentificacionDTO> respuesta = new Respuesta<TipoIdentificacionDTO>();
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		try {
			RegistrarTipoIdentificacionFacade facade = new RegistrarTipoIdentificacionFacade ();
				facade.execute(dto);
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add("El tipo de identificacion fue registrado exitosamente");
			LOGGER.info("El tipo de identificacion fue registrado exitosamente");
		}catch(final SpaOnlineException excepcion) {
			respuesta.getMensajes().add(excepcion.getMensajeUsuario());
			LOGGER.error(excepcion.getMensajeTecnico(), excepcion.getExcepcionRaiz());

		}catch(final Exception excepcion) {
			codigoHttp = HttpStatus.INTERNAL_SERVER_ERROR;
			respuesta.getMensajes().add("se ha presentado un problema inesperado tratando de registrar el tipo de identificacion");
			LOGGER.error("se ha presentado un problema inesperado tratando de registrar el tipo de identificacion", excepcion);
		}
		return new ResponseEntity<>(respuesta, codigoHttp);
	}
	@GetMapping
	@Override
	public ResponseEntity<Respuesta<TipoIdentificacionDTO>> consultar(TipoIdentificacionDTO dto) {
		  Respuesta<TipoIdentificacionDTO> respuesta = new Respuesta<>();
		    HttpStatus codigoHttp = HttpStatus.OK;

		    try {
		        
		    	List<TipoIdentificacionDTO> facade = null;//consultar(dto);
		        

		        if (facade != null) {
		            respuesta.setDatos(facade);
		            respuesta.getMensajes().add("Consulta exitosa");
		            LOGGER.info("Consulta de tipo de identificación exitosa");
		        } else {
		            codigoHttp = HttpStatus.NOT_FOUND;
		            respuesta.getMensajes().add("No se encontró el tipo de identificación con el ID proporcionado");
		            LOGGER.info("Tipo de identificación no encontrado para el ID: " + dto);
		        }
		    } catch (final Exception excepcion) {
		        codigoHttp = HttpStatus.INTERNAL_SERVER_ERROR;
		        respuesta.getMensajes().add("Se ha producido un error inesperado al consultar el tipo de identificación");
		        LOGGER.error("Error al consultar tipo de identificación", excepcion);
		    }

		    return new ResponseEntity<>(respuesta, codigoHttp);
	}
	
	@Override
	public ResponseEntity<Respuesta<TipoIdentificacionDTO>> consultarPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}
	@PutMapping("/{id}")
	@Override
	public ResponseEntity<Respuesta<TipoIdentificacionDTO>> modificar(UUID id, TipoIdentificacionDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
	@DeleteMapping("/{id}")
	@Override
	public ResponseEntity<Respuesta<TipoIdentificacionDTO>> eliminar(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}
}
