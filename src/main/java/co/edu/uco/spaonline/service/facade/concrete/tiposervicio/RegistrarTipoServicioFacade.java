package co.edu.uco.spaonline.service.facade.concrete.tiposervicio;

import co.edu.uco.spaonline.crosscutting.exception.SpaOnlineException;
import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.spaonline.data.dao.daofactory.TipoDAOFactory;
import co.edu.uco.spaonline.service.businesslogic.concrete.tiposervicio.RegistrarTipoServicioUseCase;
import co.edu.uco.spaonline.service.businesslogic.validator.concrete.tiposervicio.RegistrarTipoServicioValidator;
import co.edu.uco.spaonline.service.domain.tiposervicio.TipoServicioDomain;
import co.edu.uco.spaonline.service.dto.TipoServicioDTO;
import co.edu.uco.spaonline.service.facade.Facade;
import co.edu.uco.spaonline.service.mapper.dto.concrete.TipoServicioDTOMapper;

public class RegistrarTipoServicioFacade implements Facade <TipoServicioDTO>{

	@Override
	public final void execute(TipoServicioDTO dto) {
		final TipoServicioDomain domain = TipoServicioDTOMapper.convertToDomain(dto);
		RegistrarTipoServicioValidator.ejecutar(domain);
		DAOFactory daoFactory = DAOFactory.obtenerDAOFactory(TipoDAOFactory.SQLSERVER);
		
		try {
			daoFactory.iniciarTransaccion();
			var useCase = new RegistrarTipoServicioUseCase(daoFactory);
			useCase.execute(domain);
			daoFactory.confirmarTransaccion();
			
		} catch (SpaOnlineException excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		}catch (final Exception excepcion) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario="se presento un problema inesperado, tratando de registrar un nuevo tipo de servicio";
			var mensajeTecnico="se presento un problema de tipo excepcion en Tipo Servicio Facade intentando registrar un nuevo tipo de  Servicio. revisar el problema...";
			throw ServiceSpaOnlineException.crear(excepcion,mensajeUsuario,mensajeTecnico);
		}
		finally {
			daoFactory.cerrarConexion();
		}
		
	}

}
