package co.edu.uco.aurora.crosscuting.messagescatalog.messagesenumsqls;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;

public enum MessagesEnumBatchDAO {


    USER_ERROR_SQL_INSERT_BATCH(
            "Error al registrar la información del lote",
            "Se ha presentado un problema tratando de registrar la información del lote. " +
                    "Por favor intente de nuevo y si el problema persiste, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_INSERT_BATCH(
            "Error técnico al registrar la información del lote",
            "Se ha presentado un problema al tratar de ejecutar el proceso de creación de un lote. " +
                    "Por favor valide que la base de datos esté funcionando correctamente."),

    USER_ERROR_SQL_UNEXPECTED_ERROR_INSERT_BATCH(
            "Error inesperado al registrar la información del lote",
            "Se ha presentado un problema inesperado tratando de registrar la información del lote. " +
                    "Por favor intente nuevamente y si el problema persiste, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_INSERT_BATCH(
            "Error técnico inesperado al registrar la información del lote",
            "Se ha presentado un problema técnico inesperado al tratar de ejecutar el proceso de creación del lote. " +
                    "Revise los registros."),



    USER_ERROR_SQL_UPDATE_BATCH(
            "Error al actualizar la información del lote",
            "No fue posible actualizar los datos del lote. Por favor, verifique los datos ingresados e intente de nuevo."),

    TECHNICAL_ERROR_SQL_UPDATE_BATCH(
            "Error técnico al actualizar la información del lote",
            "Se ha presentado un error de tipo SQLException al intentar actualizar el registro del lote en la base de datos."),

    USER_ERROR_SQL_UNEXPECTED_ERROR_UPDATE_BATCH(
            "Error inesperado al actualizar la información del lote",
            "Ha ocurrido un error inesperado al intentar actualizar el registro del lote. Por favor, intente de nuevo más tarde."),

    TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_UPDATE_BATCH(
            "Error técnico inesperado al actualizar la información del lote",
            "Se ha presentado un error inesperado (no-SQL) al actualizar el registro del lote. Revise la traza completa de la excepción."),



    USER_ERROR_SQL_EXECUTING_FIND_BY_FILTER_BATCH(
            "Error consultando información del lote por filtro",
            "Se ha presentado un problema tratando de buscar información del lote por filtro en la base de datos. " +
                    "Por favor, intente de nuevo y si el problema persiste, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_EXECUTING_FIND_BY_FILTER_BATCH(
            "Error técnico ejecutando consulta de lote por filtro",
            "Se ha presentado un problema al tratar de ejecutar la sentencia de consulta por filtro para el lote. " +
                    "Verifique que la sintaxis SQL de la consulta sea correcta."),

    USER_ERROR_SQL_UNEXPECTED_ERROR_FIND_BY_FILTER_BATCH(
            "Error inesperado al consultar información del lote por filtro",
            "Ha ocurrido un problema inesperado al intentar buscar información del lote por filtro. " +
                    "Por favor, intente nuevamente y si el problema persiste, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_FIND_BY_FILTER_BATCH(
            "Error técnico inesperado en la consulta de lote por filtro",
            "Se ha presentado un error técnico inesperado (no-SQL) al intentar ejecutar la consulta por filtro de lote. " +
                    "Revise la traza completa de la excepción."),



    USER_ERROR_SQL_MAPPING_BATCH(
            "Error interpretando la información del lote",
            "Se ha presentado un problema tratando de interpretar la información de un lote consultada desde la base de datos. " +
                    "Por favor, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_MAPPING_BATCH(
            "Error técnico mapeando el ResultSet a BatchEntity",
            "Se ha presentado un problema técnico al mapear un registro del ResultSet a la entidad BatchEntity. " +
                    "Verifique que los nombres de las columnas coincidan."),

    USER_ERROR_SQL_UNEXPECTED_ERROR_MAPPING_BATCH(
            "Error inesperado mapeando la información del lote",
            "Se ha presentado un problema inesperado tratando de interpretar la información del lote." +
                    " Por favor, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_MAPPING_BATCH(
            "Error técnico inesperado en el mapeo de BatchEntity",
            "Se ha presentado un error inesperado (no-SQL) durante el proceso de mapeo del ResultSet a la entidad BatchEntity. " +
                    "Revise la traza completa de la excepción.");


    private String title;
    private String content;

    MessagesEnumBatchDAO (final String title, final String content) {
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