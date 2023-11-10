package co.edu.uco.spaonline.service.businesslogic.concrete.tiposervicio;

import java.util.List;

import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.data.dao.TipoServicioDAO;
import co.edu.uco.spaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.spaonline.service.businesslogic.UseCaseF;
import co.edu.uco.spaonline.service.domain.tiposervicio.TipoServicioDomain;
import co.edu.uco.spaonline.service.mapper.entity.concrete.TipoServicioEntityMapper;

public class ConsultarTipoServicioUseCase implements UseCaseF<TipoServicioDomain>{

	private DAOFactory factoria;
	
	public ConsultarTipoServicioUseCase(DAOFactory factoria) {
		setFactoria(factoria);
	}
	
	@Override
	public List<TipoServicioDomain> execute(TipoServicioDomain domain) {
		final var resultadosTmp = getTipoServicioDAO().consultar(TipoServicioEntityMapper.convertToEntity(domain));
		return TipoServicioEntityMapper.convertToListDomain(resultadosTmp);
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
	
	private final TipoServicioDAO getTipoServicioDAO() {
		return getFactoria().obtenerTipoServicioDAO();
	}

}
