package co.edu.uco.spaonline.controller.tiposervicio.concrete;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.spaonline.controller.support.mapper.TipoServicioResponse;
import co.edu.uco.spaonline.controller.support.request.SolicitarTipoServicio;
import co.edu.uco.spaonline.controller.support.response.Respuesta;
import co.edu.uco.spaonline.controller.tiposervicio.TipoServicioController;
import co.edu.uco.spaonline.crosscutting.exception.SpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.service.dto.TipoServicioDTO;
import co.edu.uco.spaonline.service.facade.concrete.tiposervicio.ConsultarTipoServicioFacade;
import co.edu.uco.spaonline.service.facade.concrete.tiposervicio.EliminarTipoServicioFacade;
import co.edu.uco.spaonline.service.facade.concrete.tiposervicio.ModificarTipoServicioFacade;
import co.edu.uco.spaonline.service.facade.concrete.tiposervicio.RegistrarTipoServicioFacade;


@RestController
@RequestMapping("/api/v1/tipoServicio")
public class TipoServicioControllerImpl implements TipoServicioController {
	private final Logger logger = LoggerFactory.getLogger(TipoServicioControllerImpl.class);
    
	@GetMapping("/dummy")
	public SolicitarTipoServicio obtenerDummy() {
		return new SolicitarTipoServicio();
	}
	
	

	
	@GetMapping
	@Override
	public ResponseEntity<Respuesta<SolicitarTipoServicio>> consultar(
			@RequestParam(name = "id", required = false) UUID id,
			@RequestParam(name = "nombre tipo servicio", required = false) String nombreTipoServicio){
		final Respuesta<SolicitarTipoServicio> respuesta = new Respuesta<>();
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		var dto = TipoServicioDTO.crear()
				.setId(id).setNombreTipoServicio(nombreTipoServicio);

		try {
			ConsultarTipoServicioFacade facade = new ConsultarTipoServicioFacade();
			respuesta.setDatos(TipoServicioResponse.convertListToResponse(facade.execute(dto)));
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000033));
		} catch (SpaOnlineException e) {
			respuesta.getMensajes().add(e.getMensajeTecnico());
			logger.error(e.getMensajeTecnico(), e.getExcepcionRaiz());
		} catch (Exception e) {
			codigoHttp = HttpStatus.INTERNAL_SERVER_ERROR;
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000088));
			logger.error(CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000088), e);
		}

		return new ResponseEntity<>(respuesta, codigoHttp);
	}
	
	@PostMapping
	public ResponseEntity<Respuesta<SolicitarTipoServicio>> registrar(@RequestBody SolicitarTipoServicio req) {
		final Respuesta<SolicitarTipoServicio> respuesta = new Respuesta<>();
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		
		try {
			RegistrarTipoServicioFacade facade = new RegistrarTipoServicioFacade();
			var dto = TipoServicioDTO.crear()
					.setId(req.getId())
					.setNombreTipoServicio(req.getNombreTipoServicio());
			
			facade.execute(dto);
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000010));
		} catch (SpaOnlineException e) {
			respuesta.getMensajes().add(e.getMensajeTecnico());
			logger.error(e.getMensajeTecnico(), e.getExcepcionRaiz());
		} catch (Exception e) {
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000076));
			logger.error(CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000076), e);
		}
		
		return new ResponseEntity<>(respuesta, codigoHttp);
	}


	
	@PutMapping("/{id}")
	public ResponseEntity<Respuesta<SolicitarTipoServicio>> modificar(@PathVariable("id") UUID id, @RequestBody SolicitarTipoServicio req) {
		final Respuesta<SolicitarTipoServicio> respuesta = new Respuesta<>();
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		
		try {
			ModificarTipoServicioFacade facade = new ModificarTipoServicioFacade();
			var dto = TipoServicioDTO.crear()
			.setId(id).setNombreTipoServicio(req.getNombreTipoServicio());
			facade.execute(dto);
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000018));
		} catch (SpaOnlineException e) {
			respuesta.getMensajes().add(e.getMensajeTecnico());
			logger.error(e.getMensajeTecnico(), e.getExcepcionRaiz());
		} catch (Exception e) {
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000041));
			logger.error(CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000041), e);
		}
		
		return new ResponseEntity<>(respuesta, codigoHttp);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Respuesta<SolicitarTipoServicio>> eliminar(@PathVariable("id") UUID id) {
		final Respuesta<SolicitarTipoServicio> respuesta = new Respuesta<>();
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		
		try {
			EliminarTipoServicioFacade facade = new EliminarTipoServicioFacade();
			var dto = TipoServicioDTO.crear()
			.setId(id);
			facade.execute(dto);
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000013));
		} catch (SpaOnlineException e) {
			respuesta.getMensajes().add(e.getMensajeTecnico());
			logger.error(e.getMensajeTecnico(), e.getExcepcionRaiz());
		} catch (Exception e) {
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000095));
			logger.error(CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000095), e);
		}
		
		return new ResponseEntity<>(respuesta, codigoHttp);
	}




	



	
	

}
