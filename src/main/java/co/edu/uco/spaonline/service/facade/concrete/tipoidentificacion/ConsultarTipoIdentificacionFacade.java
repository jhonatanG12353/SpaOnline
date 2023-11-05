package co.edu.uco.spaonline.service.facade.concrete.tipoidentificacion;

import co.edu.uco.spaonline.crosscutting.exception.SpaOnlineException;
import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.spaonline.data.dao.daofactory.TipoDAOFactory;
import co.edu.uco.spaonline.service.businesslogic.concrete.tipoidentificacion.RegistrarTipoIdentificacionUseCase;
import co.edu.uco.spaonline.service.businesslogic.validator.concrete.tipoidentificacion.RegistrarTipoIdentificacionValidator;
import co.edu.uco.spaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.spaonline.service.dto.TipoIdentificacionDTO;
import co.edu.uco.spaonline.service.facade.Facade;
import co.edu.uco.spaonline.service.mapper.dto.concrete.TipoIdentificacionDTOMapper;

public class ConsultarTipoIdentificacionFacade implements Facade <TipoIdentificacionDTO> {

	@Override
	public void execute(TipoIdentificacionDTO dto) {
		final TipoIdentificacionDomain domain = TipoIdentificacionDTOMapper.convertToDomain(dto);
		RegistrarTipoIdentificacionValidator.ejecutar(domain);
		DAOFactory daoFactory = DAOFactory.obtenerDAOFactory(TipoDAOFactory.SQLSERVER);
		
		try {
			daoFactory.iniciarTransaccion();
			var useCase = new RegistrarTipoIdentificacionUseCase(daoFactory);
			useCase.execute(domain);
			daoFactory.confirmarTransaccion();
			
		} catch (SpaOnlineException excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		}catch (final Exception excepcion) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario="se presento un problema inesperado, tratando de registrar un nuevo tipo de identificacion";
			var mensajeTecnico="se presento un problema de tipo excepcion en Tipo Identificacion Facade intentando registrar un nuevo tipo de identificacion. revisar el problema...";
			throw ServiceSpaOnlineException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}
		finally {
			daoFactory.cerrarConexion();
		}
	}

}
