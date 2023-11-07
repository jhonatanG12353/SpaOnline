package co.edu.uco.spaonline.service.businesslogic;

import java.util.List;

public interface UseCaseF  <D>{
	List<D> execute(D domain);
}
