package co.edu.uco.spaonline.data.dao.concrete.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import co.edu.uco.spaonline.data.dao.ServicioDAO;
import co.edu.uco.spaonline.data.dao.base.SQLDAO;
import co.edu.uco.spaonline.data.entity.ServicioEntity;

public class ServicioPostgreSQLDAO extends SQLDAO implements ServicioDAO {
	
	public  ServicioPostgreSQLDAO (final Connection conexion) {
		super(conexion);
	}

	@Override
	public final void crear(final ServicioEntity entity) {	
	}

	@Override
	public final void modificar(final ServicioEntity entity) {	
	}

	@Override
	public final void eliminar(final UUID id) {
	}

	@Override
	public final Optional<ServicioEntity> consultarPorId(final UUID id) {
		return Optional.empty();
	}

	@Override
	public final List<ServicioEntity> consultar(final ServicioEntity entity) {
		return null;
	}

}
