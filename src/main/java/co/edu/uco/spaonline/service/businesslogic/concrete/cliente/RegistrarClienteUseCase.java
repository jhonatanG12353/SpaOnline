package co.edu.uco.spaonline.service.businesslogic.concrete.cliente;

import java.util.Optional;
import java.util.UUID;

import co.edu.uco.spaonline.crosscutting.exception.concrete.ServiceSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;
import co.edu.uco.spaonline.crosscutting.util.UtilUUID;
import co.edu.uco.spaonline.data.dao.ClienteDAO;
import co.edu.uco.spaonline.data.dao.TipoIdentificacionDAO;
import co.edu.uco.spaonline.data.dao.daofactory.DAOFactory;
import co.edu.uco.spaonline.data.entity.ClienteEntity;
import co.edu.uco.spaonline.data.entity.TipoIdentificacionEntity;
import co.edu.uco.spaonline.service.businesslogic.UseCase;
import co.edu.uco.spaonline.service.domain.cliente.ClienteDomain;
import co.edu.uco.spaonline.service.domain.correoelectronicocliente.CorreoElectronicoClienteDomain;
import co.edu.uco.spaonline.service.domain.nombrecompletocliente.NombreCompletoClienteDomain;
import co.edu.uco.spaonline.service.domain.numerotelefonomovilcliente.NumeroTelefonoMovilClienteDomain;
import co.edu.uco.spaonline.service.dto.TipoIdentificacionDTO;
import co.edu.uco.spaonline.service.dto.support.CorreoElectronicoClienteDTO;
import co.edu.uco.spaonline.service.dto.support.NombreCompletoClienteDTO;
import co.edu.uco.spaonline.service.dto.support.NumeroTelefonoMovilClienteDTO;
import co.edu.uco.spaonline.service.mapper.dto.concrete.TipoIdentificacionDTOMapper;
import co.edu.uco.spaonline.service.mapper.dto.concrete.support.CorreoElectronicoClienteDTOMapper;
import co.edu.uco.spaonline.service.mapper.dto.concrete.support.NombreCompletoClienteDTOMapper;
import co.edu.uco.spaonline.service.mapper.dto.concrete.support.NumeroTelefonoMovilDTOMapper;
import co.edu.uco.spaonline.service.mapper.entity.concrete.ClienteEntityMapper;

public class RegistrarClienteUseCase  implements UseCase<ClienteDomain> {

	private DAOFactory factoria;
	
	public RegistrarClienteUseCase(DAOFactory factoria) {
		setFactoria(factoria);
	}
	
	@Override
	public void execute(ClienteDomain domain) {
		validarNoExistenciaMismoNombre(domain.getNombreCompleto());
		validarNoExistenciaCorreoElectronico(domain.getCorreoElectronico());
		validarNoExistenciaNumeroTelefonoMovil(domain.getNumeroTelefonoMovil());
		validarNoExistenciaIdentificacion(domain);
		validarExistenciaTipoIdentificacion(domain.getTipoIdentificacion().getId());
		domain = obtenerIdentificadorCliente(domain);
		registrar(domain);
	}
	
	private final ClienteDomain obtenerIdentificadorCliente(ClienteDomain domain) {
		Optional<ClienteEntity> optional;
		UUID uuid;
		
		do {
			uuid = UtilUUID.generarUUIDAleatorio();
			optional = getClienteDAO().consultarPorId(uuid);
		} while (optional.isPresent());
		
		return ClienteDomain.crear(uuid, domain.getTipoIdentificacion(), domain.getIdentificacion(), domain.getNombreCompleto(), 
				domain.getCorreoElectronico(), domain.getNumeroTelefonoMovil(), domain.getFechaNacimiento());
	}
	
	private final void validarNoExistenciaMismoNombre(final NombreCompletoClienteDomain nombre) {
		final var domain = ClienteDomain.crear(null,
				TipoIdentificacionDTOMapper.convertToDomain(TipoIdentificacionDTO.crear()), null, nombre,
				CorreoElectronicoClienteDTOMapper.convertToDomain(CorreoElectronicoClienteDTO.crear()),
				NumeroTelefonoMovilDTOMapper.convertToDomain(NumeroTelefonoMovilClienteDTO.crear()), null);
		final var entity = ClienteEntityMapper.convertToEntity(domain);
		final var resultados = getClienteDAO().consultar(entity);
		
		if(!resultados.isEmpty()) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000011);
			throw ServiceSpaOnlineException.crear(mensajeUsuario);
		}
	}
	
	private final void validarNoExistenciaCorreoElectronico(final CorreoElectronicoClienteDomain correoElectronico) {
		final var domain = ClienteDomain.crear(null,
				TipoIdentificacionDTOMapper.convertToDomain(TipoIdentificacionDTO.crear()), null,
				NombreCompletoClienteDTOMapper.convertToDomain(NombreCompletoClienteDTO.crear()), correoElectronico,
				NumeroTelefonoMovilDTOMapper.convertToDomain(NumeroTelefonoMovilClienteDTO.crear()), null);
		final var entity = ClienteEntityMapper.convertToEntity(domain);
		final var resultados = getClienteDAO().consultar(entity);
		
		if(!resultados.isEmpty()) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000012);
			throw ServiceSpaOnlineException.crear(mensajeUsuario);
		}
	}
	
	private final void validarNoExistenciaNumeroTelefonoMovil(final NumeroTelefonoMovilClienteDomain numeroTelefono) {
		final var domain = ClienteDomain.crear(null,
				TipoIdentificacionDTOMapper.convertToDomain(TipoIdentificacionDTO.crear()), null,
				NombreCompletoClienteDTOMapper.convertToDomain(NombreCompletoClienteDTO.crear()),
				CorreoElectronicoClienteDTOMapper.convertToDomain(CorreoElectronicoClienteDTO.crear()), numeroTelefono,
				null);
		final var entity = ClienteEntityMapper.convertToEntity(domain);
		final var resultados = getClienteDAO().consultar(entity);
		
		if(!resultados.isEmpty()) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000003);
			throw ServiceSpaOnlineException.crear(mensajeUsuario);
		}
	}
	
	private final void validarNoExistenciaIdentificacion(final ClienteDomain cliente) {
		final var domain = ClienteDomain.crear(null, TipoIdentificacionDTOMapper.convertToDomain(TipoIdentificacionDTO.crear()), cliente.getIdentificacion(),
				NombreCompletoClienteDTOMapper.convertToDomain(NombreCompletoClienteDTO.crear()),
				CorreoElectronicoClienteDTOMapper.convertToDomain(CorreoElectronicoClienteDTO.crear()),
				NumeroTelefonoMovilDTOMapper.convertToDomain(NumeroTelefonoMovilClienteDTO.crear()), null);
		final var entity = ClienteEntityMapper.convertToEntity(domain);
		final var resultados = getClienteDAO().consultar(entity);
		
		if(!resultados.isEmpty()) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000014);
			throw ServiceSpaOnlineException.crear(mensajeUsuario);
		}
	}
	
	private final void validarExistenciaTipoIdentificacion(final UUID tipoIdentificacion) {
		Optional<TipoIdentificacionEntity> optional;
		optional = getTipoIdentificacionDAO().consultarPorId(tipoIdentificacion);
		
		if(!optional.isPresent()) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000014);
			throw ServiceSpaOnlineException.crear(mensajeUsuario);
		}
	}
	
	private void registrar(final ClienteDomain domain) {
		getClienteDAO().crear(ClienteEntityMapper.convertToEntity(domain));
	}
	
	private final DAOFactory getFactoria() {
		return factoria;
	}
	
	private final void setFactoria(final DAOFactory factoria) {
		if(UtilObjeto.esNulo(factoria)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000099);
			final var mensajeTecnico = CatalogoMensajes.obtenerContenido(CodigoMensaje.M0000010);
			throw ServiceSpaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		this.factoria = factoria;
	}
	
	private final ClienteDAO getClienteDAO() {
		return getFactoria().obtenerClienteDAO();
	}
	
	private final TipoIdentificacionDAO getTipoIdentificacionDAO() {
		return getFactoria().obtenerTipoIdentificacionDAO();
	}
}


