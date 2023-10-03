package co.edu.uco.spaonline.data.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


import co.edu.uco.spaonline.data.entity.TipoServicioEntity;

public interface TipoServicioDAO {
void crear(TipoServicioEntity entity);
	
	void modificar(TipoServicioEntity entity);
	
	void eliminar(UUID id);
	
	Optional<TipoServicioEntity> consultarPorId(UUID id);
	
	List<TipoServicioEntity> consultar(TipoServicioEntity entity);

}
