package co.edu.uco.spaonline.service.facade;

import java.util.List;

public interface FacadeF <T> {
	
	List<T> execute(T dto);

}
