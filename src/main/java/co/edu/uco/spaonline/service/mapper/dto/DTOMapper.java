package co.edu.uco.spaonline.service.mapper.dto;

public interface DTOMapper <T,D>{
	
	D toDomain (T dto);
	
	T toDTO (D domain);

}
