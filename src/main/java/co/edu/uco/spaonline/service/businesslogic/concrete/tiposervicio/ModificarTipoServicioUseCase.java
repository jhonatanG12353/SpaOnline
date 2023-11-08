package co.edu.uco.spaonline.service.businesslogic.concrete.tiposervicio;

import java.util.UUID;

import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.data.dao.TipoServicioDAO;
import co.edu.uco.spaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.spaonline.service.businesslogic.UseCase;
import co.edu.uco.spaonline.service.domain.tiposervicio.TipoServicioDomain;
import co.edu.uco.spaonline.service.mapper.entity.concrete.TipoServicioEntityMapper;

public class ModificarTipoServicioUseCase  implements UseCase<TipoServicioDomain> {

	private DAOFactory factoria;
	
	public ModificarTipoServicioUseCase(DAOFactory factoria) {
		setFactoria(factoria);
	}
	
	@Override
	public void execute(TipoServicioDomain domain) {
		validarExistenciaRegistro(domain.getId());
		validarNoExistenciaMismoNombre(domain.getId(), domain.getNombreTipoServicio());
		actualizar(domain);
		
	}
	

	private final void validarExistenciaRegistro(final UUID id) {
		final var resultados = getTipoServicioDAO().consultarPorId(id);
		
		if(resultados.isEmpty()) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000092);
			throw ServiceSpaOnlineException.crear(mensajeUsuario);
		}
	}
	

	
	private final void validarNoExistenciaMismoNombre(final UUID id, final String nombre) {
		final var domain = TipoServicioDomain.crear(id,nombre);
		final var entity = TipoServicioEntityMapper.convertToEntity(domain);
		final var resultados = getTipoServicioDAO().consultar(entity);
		
		if(!resultados.isEmpty()) {
			for (int i = 0; i < resultados.size(); i++) {
				if(!resultados.get(i).getId().equals(id)) {
					final var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000094);
					throw ServiceSpaOnlineException.crear(mensajeUsuario);		
				}
			}
		}
	}
	
	private void actualizar(final TipoServicioDomain domain) {
		getTipoServicioDAO().modificar(TipoServicioEntityMapper.convertToEntity(domain));
	}
	
	private final DAOFactory getFactoria() {
		return factoria;
	}
	
	private final void setFactoria(final DAOFactory factoria) {
		if(UtilObjeto.esNulo(factoria)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000090);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000091);
			throw ServiceSpaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		this.factoria = factoria;
	}
	
	private final TipoServicioDAO getTipoServicioDAO() {
		return getFactoria().obtenerTipoServicioDAO();
	}
}
