package co.edu.uco.spaonline.service.businesslogic.concrete.cliente;

import java.util.List;

import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.data.dao.ClienteDAO;
import co.edu.uco.spaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.spaonline.service.businesslogic.UseCaseF;
import co.edu.uco.spaonline.service.domain.cliente.ClienteDomain;
import co.edu.uco.spaonline.service.mapper.entity.concrete.ClienteEntityMapper;

public class ConsultarClienteUseCase implements UseCaseF<ClienteDomain> {
	private DAOFactory factoria;
	
	public ConsultarClienteUseCase(DAOFactory factoria) {
		setFactoria(factoria);
	}
	
	@Override
	public List<ClienteDomain> execute(ClienteDomain domain) {
		final var resultadosTmp = getClienteDAO().consultar(ClienteEntityMapper.convertToEntity(domain));
		
		return ClienteEntityMapper.convertToListDomain(resultadosTmp);
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
	
	private final ClienteDAO getClienteDAO() {
		return getFactoria().obtenerClienteDAO();
	}
}
