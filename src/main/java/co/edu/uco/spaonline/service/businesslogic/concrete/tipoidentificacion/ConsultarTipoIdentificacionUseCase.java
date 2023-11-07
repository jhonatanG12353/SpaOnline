package co.edu.uco.spaonline.service.businesslogic.concrete.tipoidentificacion;

import java.util.List;

import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.spaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.spaonline.service.businesslogic.UseCaseF;
import co.edu.uco.spaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.spaonline.service.mapper.entity.concrete.TipoIdentificacionEntityMapper;

public class ConsultarTipoIdentificacionUseCase implements UseCaseF<TipoIdentificacionDomain>{

	private DAOFactory factoria;
	
	public ConsultarTipoIdentificacionUseCase(DAOFactory factoria) {
		setFactoria(factoria);
	}
	
	@Override
	public List<TipoIdentificacionDomain> execute(TipoIdentificacionDomain domain) {
		final var resultadosTmp = getTipoIdentificacionDAO().consultar(TipoIdentificacionEntityMapper.convertToEntity(domain));
		return TipoIdentificacionEntityMapper.convertToListDomain(resultadosTmp);
	}

	private final DAOFactory getFactoria() {
		return factoria;
	}

	private final void setFactoria(final DAOFactory factoria) {
		if(UtilObjeto.esNulo(factoria)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000088);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000089);
			throw ServiceSpaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		this.factoria = factoria;
	}
	
	private final TipoIdentificacionDAO getTipoIdentificacionDAO() {
		return getFactoria().obtenerTipoIdentificacionDAO();
	}
}
