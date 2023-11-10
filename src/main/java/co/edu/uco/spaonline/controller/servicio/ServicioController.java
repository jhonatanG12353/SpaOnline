package co.edu.uco.spaonline.controller.servicio;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.uco.spaonline.controller.support.request.SolicitarServicio;
import co.edu.uco.spaonline.controller.support.response.Respuesta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;



@Tag(name = "ServicioAPI", description = "Ofrece la api de consumo para todas las operaciones relacionadas con Servicio")
public interface ServicioController {

	@Operation(summary = "Obtener dummy", description = "Servicio encargado de obetener la estructura de un Servicio")
	SolicitarServicio obtenerDummy();

	@Operation(summary = "Obtener Servicio", description = "Servicio encargado de obetener la información de Servicio que cumple los parametros de consulta")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Cliente consultado exitosamente"),
			@ApiResponse(responseCode = "400", description = "Problema con consulta de Servicio"),
			@ApiResponse(responseCode = "500", description = "Problema inesperado") })
	ResponseEntity<Respuesta<SolicitarServicio>> consultar(
			 @RequestParam(name = "id", required = false) UUID id,
		        @RequestParam(name = "nombre tipo servicio", required = false) String nombreTipoServicio,
		        @RequestParam(name = "nombre servicio", required = false) String nombreServicio,
		        @RequestParam(name = "precio", required = false) Integer precio,
		        @RequestParam(name = "duracion", required = false) Integer duracion);

	@Operation(summary = "Regisrar Servicio", description = "Servicio encargado de registrar un Servicio")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Servicio registrado"),
			@ApiResponse(responseCode = "400", description = "Servicio no registrado"),
			@ApiResponse(responseCode = "500", description = "Problema inesperado") })
	ResponseEntity<Respuesta<SolicitarServicio>> registrar(@RequestBody SolicitarServicio req);

	@Operation(summary = "Modificar Servicio", description = "Servicio encargado de modificar un Servicio a partir de su id")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Cliente modificado"),
			@ApiResponse(responseCode = "400", description = "Servicio no modificado"),
			@ApiResponse(responseCode = "500", description = "Problema inesperado") })
	ResponseEntity<Respuesta<SolicitarServicio>> modificar(@PathVariable("id") UUID id,
			@RequestBody SolicitarServicio req);

	@Operation(summary = "Eliminar Servicio", description = "Servicio encargado de eliminar de forma definitiva un Servicio a partir de su id")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Servicio eliminado"),
			@ApiResponse(responseCode = "400", description = "Servicio no eliminado"),
			@ApiResponse(responseCode = "500", description = "Problema inesperado") })
	ResponseEntity<Respuesta<SolicitarServicio>> eliminar(@PathVariable("id") UUID id);
}
