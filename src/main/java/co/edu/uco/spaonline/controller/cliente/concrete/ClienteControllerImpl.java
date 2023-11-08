package co.edu.uco.spaonline.controller.cliente.concrete;

import java.sql.Date;
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
import co.edu.uco.spaonline.controller.cliente.ClienteController;
import co.edu.uco.spaonline.controller.support.mapper.ClienteResponse;
import co.edu.uco.spaonline.controller.support.request.SolicitarCliente;
import co.edu.uco.spaonline.controller.support.response.Respuesta;
import co.edu.uco.spaonline.crosscutting.exception.SpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.service.dto.ClienteDTO;
import co.edu.uco.spaonline.service.dto.TipoIdentificacionDTO;
import co.edu.uco.spaonline.service.dto.support.BooleanDTO;
import co.edu.uco.spaonline.service.dto.support.CorreoElectronicoClienteDTO;
import co.edu.uco.spaonline.service.dto.support.NombreCompletoClienteDTO;
import co.edu.uco.spaonline.service.dto.support.NumeroTelefonoMovilClienteDTO;
import co.edu.uco.spaonline.service.facade.concrete.cliente.ConsultarClienteFacade;
import co.edu.uco.spaonline.service.facade.concrete.cliente.EliminarClienteFacade;
import co.edu.uco.spaonline.service.facade.concrete.cliente.ModificarClienteFacade;
import co.edu.uco.spaonline.service.facade.concrete.cliente.RegistrarClienteFacade;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteControllerImpl implements ClienteController{
	
 private static final Logger logger = (Logger) LoggerFactory.getLogger(ClienteControllerImpl.class);
	
	@GetMapping("/dummy")
	public SolicitarCliente obtenerDummy() {
		return new SolicitarCliente();
	}
	
	

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<Respuesta<SolicitarCliente>> modificar(@PathVariable("id") UUID id, @RequestBody SolicitarCliente req){
		final Respuesta<SolicitarCliente> respuesta = new Respuesta<>();
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		
		try {
			ModificarClienteFacade facade = new ModificarClienteFacade();
			
			var dto = ClienteDTO.crear()
					.setId(id)
					.setTipoIdentificacion(TipoIdentificacionDTO.crear()
							.setId(req.getTipoIdentificacion().getId()))
					.setIdentificacion(req.getIdentificacion())
					.setNombreCompleto(NombreCompletoClienteDTO.crear()
							.setPrimerNombre(req.getPrimerNombre())
							.setSegundoNombre(req.getSegundoNombre())
							.setPrimerApellido(req.getPrimerApellido())
							.setSegundoApellido(req.getSegundoApellido()))
					.setCorreoElectronico(CorreoElectronicoClienteDTO.crear()
							.setCorreoElectronico(req.getCorreoElectronico())
							.setCorreoElectronicoConfirmado(BooleanDTO.crear()
									.setValor(req.isCorreoElectronicoConfirmado())
									.setValorDefecto(false)))
					.setNumeroTelefonoMovil(NumeroTelefonoMovilClienteDTO.crear()
							.setNumeroTelefonoMovil(req.getNumeroTelefonoMovil())
							.setNumeroTelefonoMovilConfirmado(BooleanDTO.crear()
									.setValor(req.isCorreoElectronicoConfirmado())
									.setValorDefecto(false)))
					.setFechaNacimiento(req.getFechaNacimiento());
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
	public ResponseEntity<Respuesta<SolicitarCliente>> consultar(	
	        @RequestParam(name = "id", required = false) UUID id,
	        @RequestParam(name = "tipoIdentificacion", required = false) UUID tipoIdentificacion,
	        @RequestParam(name = "identificacion", required = false) String identificacion,
	        @RequestParam(name = "primerNombre", required = false) String primerNombre,
	        @RequestParam(name = "segundoNombre", required = false) String segundoNombre,
	        @RequestParam(name = "primerApellido", required = false) String primerApellido,
	        @RequestParam(name = "segundoApellido", required = false) String segundoApellido,
	        @RequestParam(name = "correoElectronico", required = false) String correoElectronico,
	        @RequestParam(name = "correoElectronicoConfirmado", required = false) Boolean correoElectronicoConfirmado,
	        @RequestParam(name = "numeroTelefonoMovil", required = false) String numeroTelefonoMovil,
	        @RequestParam(name = "numeroTelefonoMovilConfirmado", required = false) Boolean numeroTelefonoMovilConfirmado,
	        @RequestParam(name = "fechaNacimiento", required = false) Date fechaNacimiento
			){
		final Respuesta<SolicitarCliente> respuesta = new Respuesta<>();
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		
		try {
			var dto = ClienteDTO.crear().setId(id)
					.setTipoIdentificacion(TipoIdentificacionDTO.crear().setId(tipoIdentificacion))
					.setIdentificacion(identificacion)
					.setNombreCompleto(
							NombreCompletoClienteDTO.crear().setPrimerNombre(primerNombre).setSegundoNombre(segundoNombre)
									.setPrimerApellido(primerApellido).setSegundoApellido(segundoApellido))
					.setCorreoElectronico(CorreoElectronicoClienteDTO.crear().setCorreoElectronico(correoElectronico)
							.setCorreoElectronicoConfirmado(BooleanDTO.crear()
									.setValor(correoElectronicoConfirmado != null ? correoElectronicoConfirmado : false)
									.setValorDefecto(correoElectronicoConfirmado == null)))
					.setNumeroTelefonoMovil(NumeroTelefonoMovilClienteDTO.crear()
							.setNumeroTelefonoMovil(numeroTelefonoMovil)
							.setNumeroTelefonoMovilConfirmado(BooleanDTO.crear()
									.setValor(numeroTelefonoMovilConfirmado != null ? numeroTelefonoMovilConfirmado : false)
									.setValorDefecto(numeroTelefonoMovilConfirmado == null)))
					.setFechaNacimiento(fechaNacimiento);
			
			ConsultarClienteFacade facade = new ConsultarClienteFacade();
			respuesta.setDatos(ClienteResponse.convertListToResponse(facade.execute(dto)));
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
	public ResponseEntity<Respuesta<SolicitarCliente>> registrar(@RequestBody SolicitarCliente req){
		final Respuesta<SolicitarCliente> respuesta = new Respuesta<>();
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		
		try {
			RegistrarClienteFacade facade = new RegistrarClienteFacade();
			var dto = ClienteDTO.crear()
					.setTipoIdentificacion(TipoIdentificacionDTO.crear().setId(req.getTipoIdentificacion().getId()))
					.setIdentificacion(req.getIdentificacion())
					.setNombreCompleto(
							NombreCompletoClienteDTO.crear().setPrimerNombre(req.getPrimerNombre()).setSegundoNombre(req.getSegundoNombre())
									.setPrimerApellido(req.getPrimerApellido()).setSegundoApellido(req.getSegundoApellido()))
					.setCorreoElectronico(CorreoElectronicoClienteDTO.crear().setCorreoElectronico(req.getCorreoElectronico())
							.setCorreoElectronicoConfirmado(BooleanDTO.crear()
									.setValor(false)
									.setValorDefecto(true)))
					.setNumeroTelefonoMovil(NumeroTelefonoMovilClienteDTO.crear()
							.setNumeroTelefonoMovil(req.getNumeroTelefonoMovil())
							.setNumeroTelefonoMovilConfirmado(BooleanDTO.crear()
									.setValor(false)
									.setValorDefecto(true)))
					.setFechaNacimiento(req.getFechaNacimiento());
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
	public ResponseEntity<Respuesta<SolicitarCliente>> eliminar(@PathVariable("id") UUID id){
		final Respuesta<SolicitarCliente> respuesta = new Respuesta<>();
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		
		try {
			EliminarClienteFacade facade = new EliminarClienteFacade();
			var dto = ClienteDTO.crear().setId(id);
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