package co.edu.uco.spaonline.controller.tiposervicio;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.uco.spaonline.controller.support.request.SolicitarTipoServicio;
import co.edu.uco.spaonline.controller.support.response.Respuesta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "TipoServicioAPI", description = "Ofrece la api de consumo para todas las operaciones relacionadas con Tipo Servicio")
public interface TipoServicioController {
	
	@Operation(summary = "Obtener dummy", description = "Servicio encargado de obetener la estructura de un tipo de Servicio")
	SolicitarTipoServicio obtenerDummy();

	@Operation(summary = "Obtener tipo de Servicio", description = "Servicio encargado de obetener la información de tipos de Servicio que cumples los parametros de consulta")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Tipo Servicio consultado exitosamente"),
			@ApiResponse(responseCode = "400", description = "Problema con consulta de tipo de Servicio"),
			@ApiResponse(responseCode = "500", description = "Problema inesperado") })
	ResponseEntity<Respuesta<SolicitarTipoServicio>> consultar(
			@RequestParam(name = "id", required = false) UUID id,
			@RequestParam(name = "nombre tipo servicio", required = false) String nombreTipoServicio);

	@Operation(summary = "Regisrar tipo de Servicio", description = "Servicio encargado de registrar un tipo de servicio")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Tipo servicio registrado"),
			@ApiResponse(responseCode = "400", description = "Tipo de servicio no registrado"),
			@ApiResponse(responseCode = "500", description = "Problema inesperado") })
	ResponseEntity<Respuesta<SolicitarTipoServicio>> registrar(@RequestBody SolicitarTipoServicio req);

	@Operation(summary = "Modificar tipo de Servicio", description = "Servicio encargado de modificar un tipo de Servicio a partir de su id")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Tipo Servicio modificado"),
			@ApiResponse(responseCode = "400", description = "Tipo de Servicio no modificado"),
			@ApiResponse(responseCode = "500", description = "Problema inesperado") })
	ResponseEntity<Respuesta<SolicitarTipoServicio>> modificar(@PathVariable("id") UUID id,
			@RequestBody SolicitarTipoServicio req);

	@Operation(summary = "Eliminar tipo de Servicio", description = "Servicio encargado de eliminar de forma definitiva un tipo de Servicio a partir de su id")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Tipo Servicio eliminado"),
			@ApiResponse(responseCode = "400", description = "Tipo de Servicio no eliminado"),
			@ApiResponse(responseCode = "500", description = "Problema inesperado") })
	ResponseEntity<Respuesta<SolicitarTipoServicio>> eliminar(@PathVariable("id") UUID id);

}
