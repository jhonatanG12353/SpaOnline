package co.edu.uco.spaonline.data.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


import co.edu.uco.spaonline.data.entity.ServicioEntity;

public interface ServicioDAO {
	void crear(ServicioEntity entity);
	
	void modificar(ServicioEntity entity);
	
	void eliminar(UUID id);
	
	Optional<ServicioEntity> consultarPorId(UUID id);
	
	List<ServicioEntity> consultar(ServicioEntity entity);
}
