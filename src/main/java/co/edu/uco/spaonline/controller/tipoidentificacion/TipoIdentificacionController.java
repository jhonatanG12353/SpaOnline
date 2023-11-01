package co.edu.uco.spaonline.controller.tipoidentificacion;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.spaonline.controller.support.response.Respuesta;
import co.edu.uco.spaonline.crosscutting.exception.SpaOnlineException;
import co.edu.uco.spaonline.service.dto.TipoIdentificacionDTO;
import co.edu.uco.spaonline.service.facade.concrete.tipoidentificacion.RegistrarTipoIdentificacionFacade;

@RestController
@RequestMapping("/api/v1/tipoidentificacion")
public class TipoIdentificacionController {
	
	@GetMapping("/dummy")
	public final TipoIdentificacionDTO obtenerDummy() {
		return TipoIdentificacionDTO.crear();
	}
	@GetMapping
	public final TipoIdentificacionDTO consultar( @RequestBody TipoIdentificacionDTO dto) {
		return dto;
	}
	
	@GetMapping ("/{id}")
	public final UUID consultarPorId(@PathVariable ("id") UUID id) {
		return id;
	}
	
	@PostMapping
	public final ResponseEntity<Respuesta<TipoIdentificacionDTO>> registrar(@RequestBody TipoIdentificacionDTO dto) {
		Respuesta<TipoIdentificacionDTO> respuesta = new Respuesta<TipoIdentificacionDTO>();
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		try {
			RegistrarTipoIdentificacionFacade facade = new RegistrarTipoIdentificacionFacade ();
				facade.execute(dto);
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add("El tipo de identificacion fue registrado exitosamente");
		}catch(final SpaOnlineException excepcion) {
			respuesta.getMensajes().add(excepcion.getMensajeUsuario());
			System.err.println(excepcion.getMensajeTecnico());
			System.err.println(excepcion.getLugar());
			excepcion.getExcepcionRaiz().printStackTrace();
			//TODO: Hacer Logging de la excepcion presentada
		}catch(final Exception excepcion) {
			respuesta.getMensajes().add("se ha presentado un problema inesperado tratando de registrar el tipo de identificacion");
			//TODO: Hacer Logging de la excepcion presentada
		}
		return new ResponseEntity<>(respuesta, codigoHttp);
	}
	
	@PutMapping ("/{id}")
	public final TipoIdentificacionDTO modificar(@PathVariable ("id") UUID id, @RequestBody TipoIdentificacionDTO dto) {
		dto.setId(id);
		return dto;
	}
	
	@DeleteMapping ("/{id}")
	public final UUID eliminar(@PathVariable ("id") UUID id) {
		return id;
	}
}
