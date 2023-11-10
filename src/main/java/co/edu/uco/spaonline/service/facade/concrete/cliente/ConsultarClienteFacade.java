package co.edu.uco.spaonline.service.facade.concrete.cliente;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.spaonline.crosscutting.exception.SpaOnlineException;
import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.spaonline.data.dao.daofactory.TipoDAOFactory;
import co.edu.uco.spaonline.service.businesslogic.concrete.cliente.ConsultarClienteUseCase;
import co.edu.uco.spaonline.service.businesslogic.validator.concrete.cliente.ConsultarClienteValidator;
import co.edu.uco.spaonline.service.domain.cliente.ClienteDomain;
import co.edu.uco.spaonline.service.dto.ClienteDTO;
import co.edu.uco.spaonline.service.facade.FacadeF;
import co.edu.uco.spaonline.service.mapper.dto.concrete.ClienteDTOMapper;

public class ConsultarClienteFacade implements FacadeF<ClienteDTO>{

	@Override
	public List<ClienteDTO> execute(final ClienteDTO dto) {
		final ClienteDomain domain = ClienteDTOMapper.convertToDomain(dto);
		ConsultarClienteValidator.ejecutar(domain);
		List<ClienteDTO> resultados = new ArrayList<>();
		
		DAOFactory daofactory = DAOFactory.obtenerDAOFactory(TipoDAOFactory.POSTGRESQL);
		
		try {
			daofactory.iniciarTransaccion();
			var useCase = new ConsultarClienteUseCase(daofactory);
			resultados = ClienteDTOMapper.convertToListDTO(useCase.execute(domain));
			daofactory.confirmarTransaccion();
		} catch (SpaOnlineException e) {
			daofactory.cancelarTransaccion();
			throw e;
		} catch (Exception e) {
			daofactory.cancelarTransaccion();
			final var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000017);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000017);
			throw ServiceSpaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		} finally {
			daofactory.cerrarConexion();
		}
		return resultados;
	}

}
