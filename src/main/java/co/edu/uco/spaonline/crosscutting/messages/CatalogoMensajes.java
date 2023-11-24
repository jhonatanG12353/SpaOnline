package co.edu.uco.spaonline.crosscutting.messages;

import java.util.HashMap;
import java.util.Map;

import co.edu.uco.spaonline.crosscutting.exception.concrete.CrosscuttingSpaOnlineException;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CategoriaMensaje;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.spaonline.crosscutting.messages.enumerator.TipoMensaje;
import co.edu.uco.spaonline.crosscutting.util.UtilObjeto;

public final class CatalogoMensajes {
	
	private static final Map<CodigoMensaje, Mensaje> MENSAJES = new HashMap<>();
	
	
	
	static {
		cargarMensajes();
	}
	
	private CatalogoMensajes() {
		super();
	}
	
	private static final void cargarMensajes() {
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000001, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, "No se recibio el codigo del mensaje que se queria crear. No es posible continuar con el proceso..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000002, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, "No existe un Mensaje con el codigo indicado. No es posible continuar con el proceso..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000003, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, "No es posible obtener un mensaje con un codigo basio o nulo. No es posible continuar con el proceso..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000004, TipoMensaje.USUARIO, CategoriaMensaje.FATAL, "Se ha presentado un problema inesperado tratando de llevar a cabo la operacion deseada. por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000005, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema tratando de validar si la conexion SQL estaba abierta. Se presento una excepcion SQLException. por favor verifique que la traza completa del error presentado, para asi poder diagnosticar con mayor certeza que sucedio..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000006, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema tratando de validar si la conexion SQL estaba abierta. Se presento una excepcion Generica SQLException . por favor verifique que la traza completa del error presentado, para asi poder diagnosticar con mayor certeza que sucedio..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000007, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "No es posible validar si una conexion esta  abierta cuando es nula. Se presento una excepcion SQLException. por favor verifique que la traza completa del error presentado, para asi poder diagnosticar con mayor certeza que sucedio..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000008, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "No es posible cerrar una conexion que esta nula. por favor verifique que la traza completa del error presentado, para asi poder diagnosticar con mayor certeza que sucedio..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000009, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "No es posible cerrar una conexion que ya esta cerrada. por favor verifique que la traza completa del error presentado, para asi poder diagnosticar con mayor certeza que sucedio..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000010, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "No es posible iniciar una transaccion que esta nula. Se presento una excepcion SQLException. por favor verifique que la traza completa del error presentado, para asi poder diagnosticar con mayor certeza que sucedio..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000011, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "No es posible iniciar una transacción con una conexión cerrada..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000012, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "No es posible iniciar una transacción que ya ha sido iniciada..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000013, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema tratando de cerrar una conexión SQL. Se presentó una excepción de tipo SQLException. Por favor verifique la traza completa del error presentado, para así poder diagnosticar con mayor certeza qué sucedió..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000014, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema inesperado tratando de cerrar la conexión. Se presentó una excepción genérica de tipo Exception. Por favor verifique la traza completa del error presentado, para así poder diagnosticar con mayor certeza qué sucedió..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000015, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema tratando de iniciar la transacción de una conexión SQL. Se presentó una excepción de tipo SQLException. Por favor verifique la traza completa del error presentado, para así poder diagnosticar con mayor certeza qué sucedió..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000016, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "Se ha presentado un problema inesperado tratando de iniciar la transacción de una conexión. Se presentó una excepción genérica de tipo Exception. Por favor verifique la traza completa del error presentado, para así poder diagnosticar con mayor certeza qué sucedió..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000017, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"No es posible confirmar una transacción con una conexión que está nula..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000018, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"No es posible confirmar una transacción con una conexión cerrada..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000019, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"No es posible confirmar una transacción que no fue iniciada..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000020, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema tratando de confirmar la transacción de una conexión SQL. Se presentó una excepción de tipo SQLException. Por favor verifique la traza completa del error presentado, para así poder diagnosticar con mayor certeza qué sucedió..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000021, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema inesperado tratando de confirmar la transacción de una conexión. Se presentó una excepción genérica de tipo Exception. Por favor verifique la traza completa del error presentado, para así poder diagnosticar con mayor certeza qué sucedió..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000022, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"No es posible cancelar una transacción con una conexión que está nula..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000023, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"No es posible cancelar una transacción con una conexión cerrada..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000024, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"No es posible cancelar una transacción que no fue iniciada..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000025, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema tratando de cancelar la transacción de una conexión SQL. Se presentó una excepción de tipo SQLException. Por favor verifique la traza completa del error presentado, para así poder diagnosticar con mayor certeza qué sucedió..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000026, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema inesperado cancelar de confirmar la transacción de una conexión. Se presentó una excepción genérica de tipo Exception. Por favor verifique la traza completa del error presentado, para así poder diagnosticar con mayor certeza qué sucedió..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000027, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"No es posible cerrar una conexión que está nula..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000028, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema tratando de obtener la conexión con SQL Server. Se presentó una excepción de tipo SQLException. Por favor verifique la traza completa del error presentado, para así poder diagnosticar con mayor certeza qué sucedió..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000029, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema inesperado tratando de obtener la conexión con SQL Server. Se presentó una excepción genérica de tipo Exception. Por favor verifique la traza completa del error presentado, para así poder diagnosticar con mayor certeza qué sucedió..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000030, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"La Factorìa de datos para PostgreSQL no se encuentra implementada..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000031, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"La Factorìa de datos para MySQL no se encuentra implementada..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000032, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"La Factorìa de datos para Oracle no se encuentra implementada..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000033, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"La Factorìa de datos deseada no se encuentra implementada..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000034, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema tratando de obtener el DAO de ClienteSQLServerDAO debido a que la conexiòn actualmente està cerrada, por lo que no hay una conexiòn vàlida disponible..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000035, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema tratando de obtener el DAO de TipoIdentificacionSQLServerDAO debido a que la conexiòn actualmente està cerrada, por lo que no hay una conexiòn vàlida disponible..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000036, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema tratando de crear el DAO deseado, debido a que la conexiòn actualmente està cerrada, por lo que no hay una conexiòn vàlida disponible..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000037, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"Se ha presentado un problema tratando de registrar la informacion del nuevo tipo de identificacio..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000038, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"Se ha presentado un problema tratando de modificar la información del tipo de identificación..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000039, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"Se ha presentado un problema tratando de eliminar la información del tipo de identificación..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000040, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"Se ha presentado un problema tratando de consultar la informacion del tipo de identificacion por el identificador deseado...."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000041, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema de tipo SQLException en el metodo crea de la clase TipoIdentificacionSQLServer tratando de llevar a cabo el registro del nuevo Tipo de Identificacion. Por favor revise la traza completa del problema presentado para asi poder identificar que sucedio..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000042, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema inesperado de tipo SQLException en el metodo crea de la clase TipoIdentificacionSQLServer traatande de llevar a cabo el registro del nuevo Tipo de Identificacion. Por favor revise la traza completa del problema presentado para asi poder identificar que sucedio..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000043, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema de tipo SQLException en el método modificar de la clase TipoIdentificacionSQLServer tratando de llevar a cabo la modificación del Tipo de Identificación. Por favor, revise la traza completa del problema presentado para identificar lo que sucedió..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000044, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema inesperado de tipo SQLException en el método modificar de la clase TipoIdentificacionSQLServer tratando de llevar a cabo la modificación del Tipo de Identificación. Por favor, revise la traza completa del problema presentado para identificar lo que sucedió..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000045, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema de tipo SQLException en el método eliminar de la clase TipoIdentificacionSQLServer tratando de eliminar el Tipo de Identificación. Por favor, revise la traza completa del problema presentado para identificar lo que sucedió..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000046, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema inesperado de tipo SQLException en el método eliminar de la clase TipoIdentificacionSQLServer tratando de eliminar el Tipo de Identificación. Por favor, revise la traza completa del problema presentado para identificar lo que sucedió..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000047, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema  de tipo SQLException en el metodo consultar por Id de la clase TipoIdentificacionSQLServer tratando de preparar la sentencia SQL de la consulta del tipo identificacion. Por favor revise la traza completa del problema presentado para asi poder identificar que sucedio..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000048, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema  de tipo Exception en el metodo consultar por Id de la clase TipoIdentificacionSQLServer tratando de preparar la sentencia SQL de la consulta del tipo identificacion. Por favor revise la traza completa del problema presentado para asi poder identificar que sucedio..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000049, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema  de tipo SQLException en el metodo crea de la clase TipoIdentificacionSQLServer tratandotratando de consultar la sentencia SQL de la consulta del tipo identificacion. Por favor revise la traza completa del problema presentado para asi poder identificar que sucedio..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000050, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema  inesperado de tipo Exception en el metodo crea de la clase TipoIdentificacionSQLServer tratandotratando de consultar la sentencia SQL de la consulta del tipo identificacion. Por favor revise la traza completa del problema presentado para asi poder identificar que sucedio..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000051, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema de tipo SQLException en el metodoprepararEjecutarSentenciaConsulta de la Clase TipoIdentificacionSQLDAO tratando de preparar la sentencia SQL. por favor revise la traza completadelproblema presentado"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000052, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema de tipo Exception en el metodoprepararEjecutarSentenciaConsulta de la Clase TipoIdentificacionSQLDAO tratando de preparar la sentencia SQL. por favor revise la traza completadelproblema presentado"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000053, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema de tipo SQLException en el metodo colocarParametroConsulta de la Clase TipoIdentificacionSQLDAO tratando de colocar los parametros de la consulta SQL. por favor revise la traza completadelproblema presentado"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000054, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema inesperado de tipo Exception en el metodo colocarParametroConsulta de la Clase TipoIdentificacionSQLDAO tratando de colocar los parametros de la consulta SQL. por favor revise la traza completadelproblema presentado"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000055, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema  de tipo SQLException en el metodo crea de la clase TipoIdentificacionSQLServer tratandotratando de consultar la sentencia SQL de la consulta del tipo identificacion. Por favor revise la traza completa del problema presentado para asi poder identificar que sucedio..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000056, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema  inesperado de tipo Exception en el metodo crea de la clase TipoIdentificacionSQLServer tratandotratando de consultar la sentencia SQL de la consulta del tipo identificacion. Por favor revise la traza completa del problema presentado para asi poder identificar que sucedio..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000057, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema tratando de convertir el UUID de String a UUID"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000058, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"Se ha presentado un problema con el Identificador.  por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicacion..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000059, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema tratando de registrar la informacion del nuevo Cliente..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000060, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema de tipo SQLException en el metodo crea de la clase ClienteSQLServer, tratando de llevar a cabo el registro del nuevo Cliente. Por favor revise la traza completa del problema presentado para asi poder identificar que sucedio..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000061, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema inesperado de tipo SQLException en el metodo crea de la clase ClienteSQLServer traatande de llevar a cabo el registro del nuevo Cliente. Por favor revise la traza completa del problema presentado para asi poder identificar que sucedio..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000062, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"Se ha presentado un problema tratando de modificar la información del Cliente..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000063, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema de tipo SQLException en el método modificar de la clase ClienteSQLServer tratando de llevar a cabo la modificación del Cliente. Por favor, revise la traza completa del problema presentado para identificar lo que sucedió..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000064, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema inesperado de tipo SQLException en el método modificar de la clase Cliente. Por favor, revise la traza completa del problema presentado para identificar lo que sucedió..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000065, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"Se ha presentado un problema tratando de eliminar la información del Cliente..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000066, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema de tipo SQLException en el método eliminar de la clase ClienteSQLServer tratando de eliminar el Cliente. Por favor, revise la traza completa del problema presentado para identificar lo que sucedió..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000067, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"Se ha presentado un problema inesperado de tipo SQLException en el método eliminar de la clase ClienteSQLServer tratando de eliminar el Cliente. Por favor, revise la traza completa del problema presentado para identificar lo que sucedió..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000068, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,"se ha presentado un problema tratando de llevar a cabo el registro de la informacion del nuevo tipo de identificacion..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000069, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"se ha presentado un problema en el metodo setFactoria de la clase RegistrarTipoIdentificacionUseCase, debido a que la factoria con la cual se desea crear esta nula..."));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000070, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"se ha presentado un problema en el metodo toDomain de la Clase TipoIdentificacion. No es Posible mapear un tipo de identificacion dominio a partir de una entidad de tipo identificacion entity nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000071, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"se ha presentado un problema en el metodo toEntity de la Clase TipoIdentificacion. No es Posible mapear un tipo de identificacion entity a partir de una entidad de tipo identificacion domain nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000072, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,"se ha presentado un problema en el metodo toDomain de la Clase Cliente. No es Posible mapear un Cliente dominio a partir de una entidad de Cliente entity nula"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000073, TipoMensaje.USUARIO, CategoriaMensaje.CONFIRMACION,"Transaccion Existosa!!"));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000074, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000075, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000076, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000077, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000078, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000079, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000080, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000081, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000082, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000083, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000084, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000085, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000086, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000087, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000088, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000089, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000090, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000091, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000092, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000093, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000094, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000095, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000096, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000097, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000098, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		agregarMensaje(Mensaje.crear(CodigoMensaje.M0000099, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,""));
		
		
	}
	
	private static final void agregarMensaje ( final Mensaje mensaje) {
		MENSAJES.put(mensaje.getCodigo(), mensaje);
	}
	
	public static final Mensaje obtenerMensaje (final CodigoMensaje codigo) {
		if (UtilObjeto.esNulo(codigo)) {
			var mensajeUsuario=obtenerContenido(CodigoMensaje.M0000004);
			var  mensajeTecnico=obtenerContenido(CodigoMensaje.M0000003);
			throw CrosscuttingSpaOnlineException.crear(mensajeUsuario, mensajeTecnico);
		}
		if (!MENSAJES.containsKey(codigo)) {
			var mensajeUsuario=obtenerContenido(CodigoMensaje.M0000004);
			var  mensajeTecnico=obtenerContenido(CodigoMensaje.M0000002);
			throw CrosscuttingSpaOnlineException.crear(mensajeUsuario, mensajeTecnico);
			
		}
		return MENSAJES.get(codigo);
	}
	public static final String obtenerContenido(final CodigoMensaje codigo) {
		return obtenerMensaje(codigo).getContenido();
	}
	
}
