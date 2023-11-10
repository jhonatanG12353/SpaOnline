package co.edu.uco.spaonline.controller.servicio.concrete;

import java.util.UUID;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;
import co.edu.uco.spaonline.controller.servicio.ServicioController;
import co.edu.uco.spaonline.controller.support.mapper.ServicioResponse;
import co.edu.uco.spaonline.controller.support.request.SolicitarServicio;
import co.edu.uco.spaonline.controller.support.response.Respuesta;
import co.edu.uco.spaonline.crosscutting.exception.SpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.service.dto.ServicioDTO;
import co.edu.uco.spaonline.service.dto.TipoServicioDTO;
import co.edu.uco.spaonline.service.facade.concrete.servicio.ConsultarServicioFacade;
import co.edu.uco.spaonline.service.facade.concrete.servicio.EliminarServicioFacade;
import co.edu.uco.spaonline.service.facade.concrete.servicio.ModificarServicioFacade;
import co.edu.uco.spaonline.service.facade.concrete.servicio.RegistrarServicioFacade;
import io.swagger.v3.oas.annotations.parameters.RequestBody;



@RestController
@RequestMapping("/api/v1/servicio")
public class ServicioControllerImpl implements ServicioController{
	
 private static final Logger logger = (Logger) LoggerFactory.getLogger(ServicioControllerImpl.class);
	
	@GetMapping("/dummy")
	public SolicitarServicio obtenerDummy() {
		return new SolicitarServicio();
	}
	
	

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<Respuesta<SolicitarServicio>> modificar(@PathVariable("id") UUID id, @RequestBody SolicitarServicio req){
		final Respuesta<SolicitarServicio> respuesta = new Respuesta<>();
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		
		try {
			ModificarServicioFacade facade = new ModificarServicioFacade();
			
			var dto = ServicioDTO.crear()
					.setId(id)
					.setTipoServicio(TipoServicioDTO.crear().setId(req.getId()).setNombreTipoServicio(req.getTiposervicio().getNombreTipoServicio()));
			facade.execute(dto);
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000018));
		} catch (SpaOnlineException e) {
			respuesta.getMensajes().add(e.getMensajeTecnico());
			logger.error(e.getLugar().toString(), e);
		} catch (Exception e) {
			var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000059);
			logger.error(mensajeTecnico);
		}
		
		return new ResponseEntity<>(respuesta, codigoHttp);
	}
	


	
	@Override
	@GetMapping
	public ResponseEntity<Respuesta<SolicitarServicio>> consultar(	
			@RequestParam(name = "tipoIdentificacion", required = false)UUID id, 
			@RequestParam(name = "nombre tipo servcio", required = false)String nombreTipoServicio,
			@RequestParam(name = "nombre servicio", required = false)String nombreServicio, 
			@RequestParam(name = "precio", required = false)Integer precio, 
			@RequestParam(name = "duracion", required = false)Integer duracion){
		final Respuesta<SolicitarServicio> respuesta = new Respuesta<>();
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		
		try {
			var dto = ServicioDTO.crear().setId(id).setTipoServicio(TipoServicioDTO.crear().setNombreTipoServicio(nombreTipoServicio));
			
			ConsultarServicioFacade facade = new ConsultarServicioFacade();
			respuesta.setDatos(ServicioResponse.convertListToResponse(facade.execute(dto)));
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000018));
		} catch (SpaOnlineException e) {
			respuesta.getMensajes().add(e.getMensajeTecnico());
			logger.error(e.getLugar().toString(), e);
		} catch (Exception e) {
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000011));
			logger.error(e.toString());
		}
		
		return new ResponseEntity<>(respuesta, codigoHttp);
	}
	
	@PostMapping
	public ResponseEntity<Respuesta<SolicitarServicio>> registrar(@RequestBody SolicitarServicio req){
		final Respuesta<SolicitarServicio> respuesta = new Respuesta<>();
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		
		try {
			RegistrarServicioFacade facade = new RegistrarServicioFacade();
			var dto = ServicioDTO.crear()
					.setId(req.getId())
					.setTipoServicio(TipoServicioDTO.crear().setId(req.getId()).setNombreTipoServicio(req.getTiposervicio().getNombreTipoServicio()));
			facade.execute(dto);
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000013));
		} catch (SpaOnlineException e) {
			respuesta.getMensajes().add(e.getMensajeTecnico());
			logger.error(e.getLugar().toString(), e);
		} catch (Exception e) {
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000099));
			logger.error(e.toString());
		}
		
		return new ResponseEntity<>(respuesta, codigoHttp);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Respuesta<SolicitarServicio>> eliminar(@PathVariable("id") UUID id){
		final Respuesta<SolicitarServicio> respuesta = new Respuesta<>();
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		
		try {
			EliminarServicioFacade facade = new EliminarServicioFacade();
			var dto = ServicioDTO.crear().setId(id);
			facade.execute(dto);
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000018));
		} catch (SpaOnlineException e) {
			respuesta.getMensajes().add(e.getMensajeTecnico());
			logger.error(e.getLugar().toString(), e);
		} catch (Exception e) {
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000062));
			logger.error(e.toString());
		}
		
		return new ResponseEntity<>(respuesta, codigoHttp);
	}




}
