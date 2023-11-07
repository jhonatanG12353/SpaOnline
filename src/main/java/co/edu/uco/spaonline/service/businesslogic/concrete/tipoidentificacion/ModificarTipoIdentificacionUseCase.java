package co.edu.uco.spaonline.service.businesslogic.concrete.tipoidentificacion;

import java.util.UUID;

import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.spaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.spaonline.service.businesslogic.UseCase;
import co.edu.uco.spaonline.service.domain.support.BooleanDomain;
import co.edu.uco.spaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.spaonline.service.mapper.entity.concrete.TipoIdentificacionEntityMapper;

public class ModificarTipoIdentificacionUseCase implements UseCase<TipoIdentificacionDomain> {

	private DAOFactory factoria;
	
	public ModificarTipoIdentificacionUseCase(DAOFactory factoria) {
		setFactoria(factoria);
	}

	@Override
	public void execute(TipoIdentificacionDomain domain) {
		validarExistenciaRegistro(domain.getId());
		validarNoExistenciaMismoCodigo(domain.getId(), domain.getCodigo());
		validarNoExistenciaMismoNombre(domain.getId(), domain.getNombre());
		actualizar(domain);
	}
	
	private final void validarExistenciaRegistro(final UUID id) {
		final var resultados = getTipoIdentificacionDAO().consultarPorId(id);
		
		if(resultados.isEmpty()) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000092);
			throw ServiceSpaOnlineException.crear(mensajeUsuario);
		}
	}
	
	private final void validarNoExistenciaMismoCodigo(final UUID id, final String codigo) {
		final var domain = TipoIdentificacionDomain.crear(null, codigo, null, BooleanDomain.crear(false, true));
		final var entity = TipoIdentificacionEntityMapper.convertToEntity(domain);
		final var resultados = getTipoIdentificacionDAO().consultar(entity);
		
		if(!resultados.isEmpty()) {
			for (int i = 0; i < resultados.size(); i++) {
				if(!resultados.get(i).getId().equals(id)) {
					final var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000093);
					throw ServiceSpaOnlineException.crear(mensajeUsuario);		
				}
			}
		}
	}
	
	private final void validarNoExistenciaMismoNombre(final UUID id, final String nombre) {
		final var domain = TipoIdentificacionDomain.crear(null, null, nombre, BooleanDomain.crear(false, true));
		final var entity = TipoIdentificacionEntityMapper.convertToEntity(domain);
		final var resultados = getTipoIdentificacionDAO().consultar(entity);
		
		if(!resultados.isEmpty()) {
			for (int i = 0; i < resultados.size(); i++) {
				if(!resultados.get(i).getId().equals(id)) {
					final var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000094);
					throw ServiceSpaOnlineException.crear(mensajeUsuario);		
				}
			}
		}
	}
	
	private void actualizar(final TipoIdentificacionDomain domain) {
		getTipoIdentificacionDAO().modificar(TipoIdentificacionEntityMapper.convertToEntity(domain));
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
	
	private final TipoIdentificacionDAO getTipoIdentificacionDAO() {
		return getFactoria().obtenerTipoIdentificacionDAO();
	}

}
