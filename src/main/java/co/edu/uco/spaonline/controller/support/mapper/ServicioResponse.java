package co.edu.uco.spaonline.controller.support.mapper;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.spaonline.controller.support.request.SolicitarInformacion;
import co.edu.uco.spaonline.controller.support.request.SolicitarServicio;
import co.edu.uco.spaonline.controller.support.request.SolicitarTipoServicio;
import co.edu.uco.spaonline.service.dto.ServicioDTO;

public class ServicioResponse {
	
	private ServicioResponse() {
		super();
	}
	
	public static final SolicitarServicio convertToResponse(ServicioDTO dto) {
		return new SolicitarServicio(dto.getId(),new SolicitarTipoServicio(dto.getTipoServicio().getId(),dto.getTipoServicio().getNombreTipoServicio()),
				new SolicitarInformacion(dto.getInformacionServicio().getNombreServicio(),dto.getInformacionServicio().getDescripcionServicio()),
				dto.getPrecio(), dto.getDuracionHoraServicio());
	}
	
	public static final List<SolicitarServicio> convertListToResponse(List<ServicioDTO> dto){
		List<SolicitarServicio> resultados = new ArrayList<>();
		for (int i = 0; i < dto.size(); i++) {
			resultados.add(convertToResponse(dto.get(i)));
		}
		
		return resultados;
	}

}
