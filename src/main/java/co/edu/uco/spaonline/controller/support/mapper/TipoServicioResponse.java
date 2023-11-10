package co.edu.uco.spaonline.controller.support.mapper;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.spaonline.controller.support.request.SolicitarTipoServicio;
import co.edu.uco.spaonline.service.dto.TipoServicioDTO;

public class TipoServicioResponse {
	public static final SolicitarTipoServicio convertToResponse(TipoServicioDTO dto) {
		return new SolicitarTipoServicio(dto.getId(), dto.getNombreTipoServicio());
	}
	
	public static final List<SolicitarTipoServicio> convertListToResponse(List<TipoServicioDTO> dto){
		List<SolicitarTipoServicio> resultados = new ArrayList<>();
		for (int i = 0; i < dto.size(); i++) {
			resultados.add(convertToResponse(dto.get(i)));
		}
		
		return resultados;
	}
}
