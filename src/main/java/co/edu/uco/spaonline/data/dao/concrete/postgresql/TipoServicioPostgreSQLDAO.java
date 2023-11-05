package co.edu.uco.spaonline.data.dao.concrete.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


import co.edu.uco.spaonline.data.dao.TipoServicioDAO;
import co.edu.uco.spaonline.data.dao.base.SQLDAO;
import co.edu.uco.spaonline.data.entity.TipoServicioEntity;

public class TipoServicioPostgreSQLDAO extends SQLDAO implements TipoServicioDAO  {
	
	public  TipoServicioPostgreSQLDAO (final Connection conexion) {
		super(conexion);
	}

	@Override
	public final void crear(final TipoServicioEntity entity) {	
	}

	@Override
	public final void modificar(final TipoServicioEntity entity) {	
	}

	@Override
	public final void eliminar(final UUID id) {
	}

	@Override
	public final Optional<TipoServicioEntity> consultarPorId(final UUID id) {
		return Optional.empty();
	}

	@Override
	public final List<TipoServicioEntity> consultar(final TipoServicioEntity entity) {
		return null;
	}

}
