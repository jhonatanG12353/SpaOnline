package co.edu.uco.spaonline.service.mapper.dto.concrete;

import co.edu.uco.spaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.spaonline.service.dto.TipoIdentificacionDTO;
import co.edu.uco.spaonline.service.mapper.dto.DTOMapper;

public class TipoIdentificacionDTOMapper implements DTOMapper <TipoIdentificacionDTO, TipoIdentificacionDomain>{

	
	private static final DTOMapper<TipoIdentificacionDTO, TipoIdentificacionDomain> instancia = new TipoIdentificacionDTOMapper();
	
	private TipoIdentificacionDTOMapper() {
		super();
	}
	@Override
	public TipoIdentificacionDomain toDomain(TipoIdentificacionDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoIdentificacionDTO toDTO(TipoIdentificacionDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}
	public static final TipoIdentificacionDomain convertToDomain(final TipoIdentificacionDTO dto) {
		return instancia.toDomain(dto);
	}
	public static final TipoIdentificacionDTO convertToDTO(final TipoIdentificacionDomain domain) {
		return instancia.toDTO(domain);
	}
	

}
