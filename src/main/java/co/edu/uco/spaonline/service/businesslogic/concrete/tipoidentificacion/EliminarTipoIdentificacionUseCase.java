package co.edu.uco.spaonline.service.businesslogic.concrete.tipoidentificacion;

import java.util.UUID;

import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.data.dao.ClienteDAO;
import co.edu.uco.spaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.spaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.spaonline.service.businesslogic.UseCase;
import co.edu.uco.spaonline.service.domain.support.BooleanDomain;
import co.edu.uco.spaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.spaonline.service.dto.ClienteDTO;
import co.edu.uco.spaonline.service.mapper.dto.concrete.ClienteDTOMapper;
import co.edu.uco.spaonline.service.mapper.dto.concrete.TipoIdentificacionDTOMapper;
import co.edu.uco.spaonline.service.mapper.entity.concrete.ClienteEntityMapper;

public class EliminarTipoIdentificacionUseCase implements UseCase<TipoIdentificacionDomain> {

	private DAOFactory factoria;
	
	public EliminarTipoIdentificacionUseCase(DAOFactory factoria) {
		setFactoria(factoria);
	}
	
	@Override
	public void execute(TipoIdentificacionDomain domain) {
		validarExistenciaRegistro(domain.getId());
		validarNoExistenciaRelacion(domain.getId());
		eliminar(domain.getId());
	}
	
	private final void validarExistenciaRegistro(final UUID id) {
		final var resultados = getTipoIdentificacionDAO().consultarPorId(id);
		
		if(resultados.isEmpty()) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000097);
			throw ServiceSpaOnlineException.crear(mensajeUsuario);
		}
	}
	
	private final void validarNoExistenciaRelacion(final UUID id) {
		final var tipoIdentificacion = TipoIdentificacionDomain.crear(id, null, null, BooleanDomain.crear(false, true));
		final var cliente = ClienteDTOMapper.convertToDomain(
				ClienteDTO.crear().setTipoIdentificacion(TipoIdentificacionDTOMapper.convertToDTO(tipoIdentificacion)));
		
		final var resultados = getClienteDAO().consultar(ClienteEntityMapper.convertToEntity(cliente));
		
		if(!resultados.isEmpty()) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000098);
			throw ServiceSpaOnlineException.crear(mensajeUsuario);
		}
	}
	
	private void eliminar(final UUID id) {
		getTipoIdentificacionDAO().eliminar(id);
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
	
	private final TipoIdentificacionDAO getTipoIdentificacionDAO() {
		return getFactoria().obtenerTipoIdentificacionDAO();
	}
	
	private final ClienteDAO getClienteDAO() {
		return getFactoria().obtenerClienteDAO();
	}

}
