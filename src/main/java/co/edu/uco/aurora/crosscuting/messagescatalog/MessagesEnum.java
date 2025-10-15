package co.edu.uco.aurora.crosscuting.messagescatalog;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;

public enum MessagesEnum {

    USER_ERROR_SQL_CONNECTION_IS_EMPTY("Conexion contra la fuente de informacion deseada vacia",
            "La conexion requerida para llevar a cabo la operacion contra la fuente de informacion deseada está vacia. "
                    + "Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion"),

    TECHNICAL_ERROR_SQL_CONNECTION_IS_EMPTY("Conexion contra la fuente de informacion deseada nula",
            "La conexion requerida para llevar a cabo la operacion contra la base de datos llegó nula."
                    + "Por favor intenta de nuevo y si el problema persiste, contacte al administrador de la aplicación"),

    USER_ERROR_SQL_CONNECTION_IS_CLOSED("Conexion contra la fuente de informacion deseada cerrada",
            "La conexion requerida para llevar a cabo la operacion contra la fuente de informacion deseada está cerrada. "
                    + "Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion"),

    TECHNICAL_ERROR_SQL_CONNECTION_IS_CLOSED("Conexion contra la fuente de informacion deseada cerrada",
            "La conexion requerida para llevar a cabo la operacion contra la base de datos llegó cerrada."
                    + "Por favor intenta de nuevo y si el problema persiste, contacte al administrador de la aplicación"),

    USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS("Problema inesperado contra la fuente de informacion deseada vacia",
            "La conexion requerida para llevar a cabo la operacion contra la fuente de informacion deseada está vacia. "
                    + "Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion"),

    TECHNICAL_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_CONNECTION_STATUS("Problema inesperado contra la fuente de informacion deseada vacia" ,
            "La conexion requerida para llevar a cabo la operacion contra la fuente de informacion deseada está vacia."
                    + "Por favor intenta de nuevo y si el problema persiste, contacte al administrador de la aplicación"),

    TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS("Error técnico inesperado al validar el estado de la conexión",
            "Se presentó un error técnico inesperado al intentar validar el estado de la conexión contra la base de datos. "
                    + "Por favor intente nuevamente y si el problema persiste, contacte al administrador de la aplicación"),

    USER_ERROR_TRANSACTION_IS_NOT_STARTED("Transacción no iniciada",
            "La operación no puede completarse porque la transacción requerida no ha sido iniciada. "
                    + "Por favor inicie la transacción e intente nuevamente. Si el problema persiste, contacte al administrador de la aplicación."),

    TECHNICAL_ERROR_TRANSACTION_IS_NOT_STARTED("Transacción no iniciada en la base de datos",
            "La operación no puede completarse porque la transacción requerida no fue iniciada correctamente en la base de datos. "
                    + "Por favor revise la lógica de inicio de transacciones y si el problema persiste, contacte al administrador de la aplicación."),

    USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_STARTED("Error inesperado al validar el inicio de la transacción",
            "Se presentó un problema inesperado al validar el estado de la transacción. "
                    + "Por favor intente nuevamente y si el problema persiste, contacte al administrador de la aplicación."),

    TECHNICAL_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_TRANSACTION_IS_STARTED("Error SQL al validar el inicio de la transacción",
            "Se produjo una excepción SQL al intentar validar el estado de la transacción. "
                    + "Por favor revise la conexión con la base de datos y si el problema persiste, contacte al administrador de la aplicación."),

    TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_STARTED("Error técnico inesperado al validar el inicio de la transacción",
            "Se presentó un error técnico inesperado al intentar validar el estado de la transacción. "
                    + "Por favor revise los registros del sistema y si el problema persiste, contacte al administrador de la aplicación."),

    USER_ERROR_TRANSACTION_IS_STARTED("Transacción no iniciada",
            "La operación no puede completarse porque la transacción ya ha sido iniciada y debe estar finalizada para proceder"
                    + "Por favor finalice la transacción e intente nuevamente. Si el problema persiste, contacte al administrador de la aplicación."),

    TECHNICAL_ERROR_TRANSACTION_IS_STARTED("Transacción no iniciada en la base de datos",
            "La operación no puede completarse porque la transacción ya fue iniciada en la base de datos y debe estar finalizada. "
                    + "Por favor revise la lógica de transacciones y si el problema persiste, contacte al administrador de la aplicación."),

    USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_NOT_STARTED("Error inesperado al validar el inicio de la transacción",
            "Se presentó un problema inesperado al validar el estado de la transacción. "
                    + "Por favor intente nuevamente y si el problema persiste, contacte al administrador de la aplicación."),

    TECHNICAL_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_TRANSACTION_IS_NOT_STARTED("Error SQL al validar el inicio de la transacción",
            "Se produjo una excepción SQL al intentar validar el estado de la transacción. "
                    + "Por favor revise la conexión con la base de datos y si el problema persiste, contacte al administrador de la aplicación."),

    TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_NOT_STARTED("completa las frases de error y dime cuales carecen de sentido, no toques los subtitulos son importantes",
            "Se presentó un problema inesperado al validar el estado de la transacción. "
                    + "Por favor intente nuevamente y si el problema persiste, contacte al administrador de la aplicación"),



    //DAOFatory

    USER_ERROR_SQL_CANNOT_INIT_TRANSACTION(
            "No fue posible iniciar la transacción con la base de datos",
            "Se presentó un error al intentar iniciar una transacción en la base de datos PostgreSQL. " +
                    "Por favor intente nuevamente y si el problema persiste, contacte al administrador de la aplicación."),

    TECHNICAL_ERROR_SQL_CANNOT_INIT_TRANSACTION(
            "Error SQL al intentar iniciar la transacción con PostgreSQL",
            "Ocurrió una excepción SQL al intentar ejecutar la instrucción de inicio de transacción (BEGIN/COMMIT/ROLLBACK). " +
                    "Verifique que la conexión esté activa y que la base de datos permita transacciones en este contexto. " +
                    "Si el problema persiste, contacte al administrador de la aplicación."),

    USER_ERROR_SQL_UNEXPECTED_ERROR_INIT_TRANSACTION(
            "Error inesperado al intentar iniciar la transacción",
            "Se presentó un problema inesperado al intentar comenzar la transacción con la base de datos. " +
                    "Por favor intente nuevamente y si el problema persiste, contacte al administrador de la aplicación."),

    TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_INIT_TRANSACTION(
            "Error técnico inesperado al intentar iniciar la transacción",
            "Se presentó un error técnico no controlado al intentar iniciar una transacción en la base de datos. " +
                    "Por favor revise los registros del sistema y si el problema persiste, contacte al administrador de la aplicación."),


    USER_ERROR_SQL_DATASOURCE_NOT_AVAILABLE(
			"La fuente de información no está disponible en el sistema",
                    "La fuente de información sobre la cual se va a realizar la transacción seleccionada no está disponible dentro del sistema. "
                    + "Por favor intente nuevamente y si el problema persiste, contacte al administrador de la aplicación."),

    TECHNICAL_ERROR_SQL_DATASOURCE_NOT_AVAILABLE(
			"Error técnico al intentar acceder a la fuente de información",
                    "La factoría correspondiente a la fuente de información solicitada no existe o no se ha implementado correctamente. "
                    + "Verifique que la clase de factoría haya sido creada y registrada en el sistema. "
                    + "Si el problema persiste, contacte al administrador de la aplicación."),

    USER_ERROR_SQL_CANNOT_COMMIT_TRANSACTION(
			"No fue posible confirmar la transacción en la base de datos",
                    "Se presentó un error al intentar confirmar (commit) la transacción en la base de datos PostgreSQL. " +
                    "Por favor intente nuevamente y si el problema persiste, contacte al administrador de la aplicación."),

    TECHNICAL_ERROR_SQL_CANNOT_COMMIT_TRANSACTION(
			"Error SQL al intentar confirmar la transacción en PostgreSQL",
                    "Ocurrió una excepción SQL al ejecutar la instrucción COMMIT. " +
                    "Verifique que la conexión esté activa, que la transacción haya sido iniciada correctamente y que no existan bloqueos en la base de datos. " +
                    "Si el problema persiste, contacte al administrador de la aplicación."),

    USER_ERROR_SQL_UNEXPECTED_ERROR_COMMIT_TRANSACTION(
			"Error inesperado al intentar confirmar la transacción",
                    "Se presentó un problema inesperado al intentar confirmar la transacción con la base de datos. " +
                    "Por favor intente nuevamente y si el problema persiste, contacte al administrador de la aplicación."),

    TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_COMMIT_TRANSACTION(
			"Error técnico inesperado al intentar confirmar la transacción",
                    "Se presentó un error técnico no controlado durante la confirmación (commit) de la transacción. " +
                    "Por favor revise los registros del sistema y si el problema persiste, contacte al administrador de la aplicación."),

    USER_ERROR_SQL_CANNOT_ROLLBACK_TRANSACTION(
			"No fue posible revertir la transacción en la base de datos",
                    "Se presentó un error al intentar deshacer (rollback) la transacción en la base de datos PostgreSQL. " +
                    "Por favor intente nuevamente y si el problema persiste, contacte al administrador de la aplicación."),

    TECHNICAL_ERROR_SQL_CANNOT_ROLLBACK_TRANSACTION(
			"Error SQL al intentar revertir la transacción en PostgreSQL",
                    "Ocurrió una excepción SQL al ejecutar la instrucción ROLLBACK. " +
                    "Verifique que la conexión esté activa y que exista una transacción iniciada antes de realizar el rollback. " +
                    "Si el problema persiste, contacte al administrador de la aplicación."),

    USER_ERROR_SQL_UNEXPECTED_ERROR_ROLLBACK_TRANSACTION(
			"Error inesperado al intentar revertir la transacción",
                    "Se presentó un problema inesperado al intentar revertir la transacción con la base de datos. " +
                    "Por favor intente nuevamente y si el problema persiste, contacte al administrador de la aplicación."),

    TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_ROLLBACK_TRANSACTION(
			"Error técnico inesperado al intentar revertir la transacción",
                    "Se presentó un error técnico no controlado durante la reversión (rollback) de la transacción. " +
                    "Por favor revise los registros del sistema y si el problema persiste, contacte al administrador de la aplicación."),

    USER_ERROR_SQL_CANNOT_CLOSE_CONNECTION(
			"No fue posible cerrar la conexión con la base de datos",
                    "Se presentó un error al intentar cerrar la conexión con la base de datos PostgreSQL. " +
                    "Por favor intente nuevamente y si el problema persiste, contacte al administrador de la aplicación."),

    TECHNICAL_ERROR_SQL_CANNOT_CLOSE_CONNECTION(
			"Error SQL al intentar cerrar la conexión con PostgreSQL",
                    "Ocurrió una excepción SQL al ejecutar el método Connection.close(). " +
                    "Verifique que la conexión esté activa y no haya sido cerrada previamente. " +
                    "Si el problema persiste, contacte al administrador de la aplicación."),

    USER_ERROR_SQL_UNEXPECTED_ERROR_CLOSING_CONNECTION(
			"Error inesperado al intentar cerrar la conexión",
                    "Se presentó un problema inesperado al intentar cerrar la conexión con la base de datos. " +
                    "Por favor intente nuevamente y si el problema persiste, contacte al administrador de la aplicación."),

    TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_CLOSING_CONNECTION(
			"Error técnico inesperado al intentar cerrar la conexión",
                    "Se presentó un error técnico no controlado durante el cierre de la conexión con la base de datos. " +
                    "Por favor revise los registros del sistema y si el problema persiste, contacte al administrador de la aplicación.");


    private String title;
    private String content;

    private MessagesEnum (final String title, final String content) {
        setTitle(title);
        setContent(content);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = TextHelper.getDefaultWithTrim(title);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = TextHelper.getDefaultWithTrim(content);
    }
}
