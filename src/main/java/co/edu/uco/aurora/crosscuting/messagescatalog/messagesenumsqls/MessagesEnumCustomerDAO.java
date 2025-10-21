package co.edu.uco.aurora.crosscuting.messagescatalog.messagesenumsqls;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;

public enum MessagesEnumCustomerDAO {

    // Errores para la operación de Inserción (INSERT) de Cliente (CUSTOMER)

    USER_ERROR_SQL_INSERT_CUSTOMER(
            "Error al registrar la información del cliente",
            "Se ha presentado un problema tratando de registrar la información del cliente. Por favor intente de nuevo y si el problema persiste, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_INSERT_CUSTOMER(
            "Error técnico al registrar la información del cliente",
            "Se ha presentado un problema al tratar de ejecutar el proceso de creación de un cliente. Por favor valide que la base de datos esté funcionando correctamente."),

    USER_ERROR_SQL_UNEXPECTED_ERROR_INSERT_CUSTOMER(
            "Error inesperado al registrar la información del cliente",
            "Se ha presentado un problema inesperado tratando de registrar la información del cliente. Por favor intente nuevamente y si el problema persiste, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_INSERT_CUSTOMER(
            "Error técnico inesperado al registrar la información del cliente",
            "Se ha presentado un problema técnico inesperado al tratar de ejecutar el proceso de creación del cliente. Revise los registros."),


// Errores para la operación de Consulta por Filtro (FIND BY FILTER) de Cliente (CUSTOMER)

    USER_ERROR_SQL_EXECUTING_FIND_BY_FILTER_CUSTOMER(
            "Error consultando información del cliente por filtro",
            "Se ha presentado un problema tratando de buscar información del cliente por filtro en la base de datos. Por favor, intente de nuevo y si el problema persiste, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_EXECUTING_FIND_BY_FILTER_CUSTOMER(
            "Error técnico ejecutando consulta de cliente por filtro",
            "Se ha presentado un problema al tratar de ejecutar la sentencia de consulta por filtro para el cliente. Verifique que la sintaxis SQL de la consulta sea correcta."),

    USER_ERROR_SQL_UNEXPECTED_ERROR_FIND_BY_FILTER_CUSTOMER(
            "Error inesperado al consultar información del cliente por filtro",
            "Ha ocurrido un problema inesperado al intentar buscar información del cliente por filtro. Por favor, intente nuevamente y si el problema persiste, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_FIND_BY_FILTER_CUSTOMER(
            "Error técnico inesperado en la consulta de cliente por filtro",
            "Se ha presentado un error técnico inesperado (no-SQL) al intentar ejecutar la consulta por filtro de cliente. Revise la traza completa de la excepción."),


// Errores para la Operación de Mapeo (MAPPING) de Cliente (CUSTOMER)

    USER_ERROR_SQL_MAPPING_CUSTOMER(
            "Error interpretando la información del cliente",
            "Se ha presentado un problema tratando de interpretar la información de un cliente consultada desde la base de datos. Por favor, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_MAPPING_CUSTOMER(
            "Error técnico mapeando el ResultSet a CustomerEntity",
            "Se ha presentado un problema técnico al mapear un registro del ResultSet a la entidad CustomerEntity. Verifique que los nombres de las columnas coincidan."),

    USER_ERROR_SQL_UNEXPECTED_ERROR_MAPPING_CUSTOMER(
            "Error inesperado mapeando la información del cliente",
            "Se ha presentado un problema inesperado tratando de interpretar la información del cliente. Por favor, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_MAPPING_CUSTOMER(
            "Error técnico inesperado en el mapeo de CustomerEntity",
            "Se ha presentado un error inesperado (no-SQL) durante el proceso de mapeo del ResultSet a la entidad CustomerEntity. Revise la traza completa de la excepción."),


// Errores para la operación de Actualización (UPDATE) de Cliente (CUSTOMER)

    USER_ERROR_SQL_UPDATE_CUSTOMER(
            "Error al actualizar la información del cliente",
            "No fue posible actualizar los datos del cliente. Por favor, verifique los datos ingresados e intente de nuevo."),

    TECHNICAL_ERROR_SQL_UPDATE_CUSTOMER(
            "Error técnico al actualizar la información del cliente",
            "Se ha presentado un error de tipo SQLException al intentar actualizar el registro del cliente en la base de datos."),

    USER_ERROR_SQL_UNEXPECTED_ERROR_UPDATE_CUSTOMER(
            "Error inesperado al actualizar la información del cliente",
            "Ha ocurrido un error inesperado al intentar actualizar el registro del cliente. Por favor, intente de nuevo más tarde."),

    TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_UPDATE_CUSTOMER(
            "Error técnico inesperado al actualizar la información del cliente",
            "Se ha presentado un error inesperado (no-SQL) al actualizar el registro del cliente. Revise la traza completa de la excepción.");

    private String title;
    private String content;

    private MessagesEnumCustomerDAO (final String title, final String content) {
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