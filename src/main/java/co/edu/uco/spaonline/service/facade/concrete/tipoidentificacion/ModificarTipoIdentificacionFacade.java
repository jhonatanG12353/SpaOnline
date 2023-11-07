package co.edu.uco.spaonline.service.facade.concrete.tipoidentificacion;

import co.edu.uco.spaonline.crosscutting.exception.SpaOnlineException;
import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.spaonline.data.dao.daofactory.TipoDAOFactory;
import co.edu.uco.spaonline.service.businesslogic.concrete.tipoidentificacion.ModificarTipoIdentificacionUseCase;
import co.edu.uco.spaonline.service.businesslogic.validator.concrete.tipoidentificacion.ModificarTipoIdentificacionValidator;
import co.edu.uco.spaonline.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.spaonline.service.dto.TipoIdentificacionDTO;
import co.edu.uco.spaonline.service.facade.Facade;
import co.edu.uco.spaonline.service.mapper.dto.concrete.TipoIdentificacionDTOMapper;

public class ModificarTipoIdentificacionFacade implements Facade<TipoIdentificacionDTO>{

		@Override
		public void execute(final TipoIdentificacionDTO dto) {
			final TipoIdentificacionDomain domain = TipoIdentificacionDTOMapper.convertToDomain(dto);
			ModificarTipoIdentificacionValidator.ejecutar(domain);
			
			DAOFactory daofactory = DAOFactory.obtenerDAOFactory(TipoDAOFactory.POSTGRESQL);
			
			try {
				daofactory.iniciarTransaccion();
				var useCase = new ModificarTipoIdentificacionUseCase(daofactory);
				useCase.execute(domain);
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
		}
}
