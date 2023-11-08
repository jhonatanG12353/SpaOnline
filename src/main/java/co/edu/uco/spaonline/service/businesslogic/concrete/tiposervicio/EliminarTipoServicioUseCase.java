package co.edu.uco.spaonline.service.businesslogic.concrete.tiposervicio;

import java.util.UUID;

import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.data.dao.ServicioDAO;
import co.edu.uco.spaonline.data.dao.TipoServicioDAO;
import co.edu.uco.spaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.spaonline.service.businesslogic.UseCase;
import co.edu.uco.spaonline.service.domain.tiposervicio.TipoServicioDomain;
import co.edu.uco.spaonline.service.dto.ServicioDTO;
import co.edu.uco.spaonline.service.mapper.dto.concrete.ServicioDTOMapper;
import co.edu.uco.spaonline.service.mapper.dto.concrete.TipoServicioDTOMapper;
import co.edu.uco.spaonline.service.mapper.entity.concrete.ServicioEntityMapper;

public class EliminarTipoServicioUseCase implements UseCase <TipoServicioDomain> {

	private DAOFactory factoria;
	
	public EliminarTipoServicioUseCase(DAOFactory factoria) {
		setFactoria(factoria);
	}
	
	@Override
	public void execute(TipoServicioDomain domain) {
		validarExistenciaRegistro(domain.getId());
		validarNoExistenciaRelacion(domain.getId());
		eliminar(domain.getId());
	}
	
	private final void validarExistenciaRegistro(final UUID id) {
		final var resultados = getTipoServicioDAO().consultarPorId(id);
		
		if(resultados.isEmpty()) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000097);
			throw ServiceSpaOnlineException.crear(mensajeUsuario);
		}
	}
	
	private final void validarNoExistenciaRelacion(final UUID id) {
		final var tipoServicio = TipoServicioDomain.crear(id, null);
		final var Servicio = ServicioDTOMapper.convertToDomain(ServicioDTO.crear().setTipoServicio(TipoServicioDTOMapper.convertToDTO(tipoServicio)));
		
		final var resultados = getServicioDAO().consultar(ServicioEntityMapper.convertToEntity(Servicio));
		
		if(!resultados.isEmpty()) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000098);
			throw ServiceSpaOnlineException.crear(mensajeUsuario);
		}
	}
	
	private void eliminar(final UUID id) {
		getTipoServicioDAO().eliminar(id);
	}
	
	private final DAOFactory getFactoria() {
		return factoria;
	}
	
	private final void setFactoria(final DAOFactory factoria) {
		if(UtilObjeto.esNulo(factoria)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000076);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000077);
			throw ServiceSpaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		this.factoria = factoria;
	}
	
	private final TipoServicioDAO getTipoServicioDAO() {
		return getFactoria().obtenerTipoServicioDAO();
	}
	
	private final ServicioDAO getServicioDAO() {
		return getFactoria().obtenerServicioDAO();
	}
}
