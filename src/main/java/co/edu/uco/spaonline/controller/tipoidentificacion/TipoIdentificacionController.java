package co.edu.uco.spaonline.controller.tipoidentificacion;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import co.edu.uco.spaonline.controller.support.response.Respuesta;
import co.edu.uco.spaonline.service.dto.TipoIdentificacionDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "TipoIdenficicacionAPI", description = "Ofrece la api de consumo para todas las operaciones relacionadas con Tipo Identificacion")
public interface TipoIdentificacionController {
		
	@Operation(summary = "Obtener Dummy", description = "Servicio ecargado de obtener la estructura JSON basica de un Tipo Identificacion")
	 TipoIdentificacionDTO obtenerDummy();
	
	@Operation(summary = "Consultar", description = "Obtener la informacion de todos los tipos de identificacion que cumplelos parametros de filtrado enviado")
	 ResponseEntity<Respuesta<TipoIdentificacionDTO>> consultar( @RequestBody TipoIdentificacionDTO dto);
	
	@Operation(summary = "Consultar por  id", description = "servicio encargado de obtener los tipos de identificacion que cumplen con el parametro de id")
	 ResponseEntity<Respuesta<TipoIdentificacionDTO>> consultarPorId(@PathVariable ("id") UUID id);
	
	@Operation(summary = "Registrar", description = "servicio encargado de registrar la informacion del nuevo tipo de identificacion enviado")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Tipo de identifiacion registrado exitosamente"), 
			@ApiResponse(responseCode = "400", description = "Tipo de identifiacion no registrado exitosamente por algun problema desconocido"),
			 @ApiResponse(responseCode = "500", description = "Tipo de identifiacion no registrado exitosamente por un problema inesperado")})
	ResponseEntity<Respuesta<TipoIdentificacionDTO>> registrar(@RequestBody TipoIdentificacionDTO dto);
	
	@Operation(summary = "Modificar", description = "servicio encargado de modificar la informacion  del tipo identificacion correspondiente enviado como parametro")
	 ResponseEntity<Respuesta<TipoIdentificacionDTO>> modificar(@PathVariable ("id") UUID id, @RequestBody TipoIdentificacionDTO dto);
	@Operation(summary = "Eliminar", description = "servicio encargado de eliminar la informacion del tipo identificacion correspondiente enviado como parametro")
	 ResponseEntity<Respuesta<TipoIdentificacionDTO>> eliminar(@PathVariable ("id") UUID id);
}
