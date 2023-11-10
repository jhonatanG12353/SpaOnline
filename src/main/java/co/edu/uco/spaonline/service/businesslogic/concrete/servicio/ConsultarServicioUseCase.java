package co.edu.uco.spaonline.service.businesslogic.concrete.servicio;

import java.util.List;

import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.data.dao.ServicioDAO;
import co.edu.uco.spaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.spaonline.service.businesslogic.UseCaseF;
import co.edu.uco.spaonline.service.domain.servicio.ServicioDomain;
import co.edu.uco.spaonline.service.mapper.entity.concrete.ServicioEntityMapper;

public class ConsultarServicioUseCase  implements UseCaseF<ServicioDomain> {
	private DAOFactory factoria;
	
	public ConsultarServicioUseCase(DAOFactory factoria) {
		setFactoria(factoria);
	}
	
	@Override
	public List<ServicioDomain> execute(ServicioDomain domain) {
		final var resultadosTmp = getServicioDAO().consultar(ServicioEntityMapper.convertToEntity(domain));
		
		return ServicioEntityMapper.convertToListDomain(resultadosTmp);
	}

	private final DAOFactory getFactoria() {
		return factoria;
	}

	private final void setFactoria(final DAOFactory factoria) {
		if(UtilObjeto.esNulo(factoria)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000015);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000016);
			throw ServiceSpaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		this.factoria = factoria;
	}
	
	private final ServicioDAO getServicioDAO() {
		return getFactoria().obtenerServicioDAO();
	}

}
