package co.edu.uco.aurora.crosscuting.messagescatalog.messagesenumsqls;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;

public enum MessagesEnumUnitMeasurementDAO {

    USER_ERROR_SQL_EXECUTING_FIND_BY_FILTER_UNITMEASUREMENT(
            "Error consultando información de la unidad de medida por filtro",
            "Se ha presentado un problema tratando de buscar información de la unidad de medida por filtro en la base de datos. " +
                    "Por favor, intente de nuevo y si el problema persiste, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_EXECUTING_FIND_BY_FILTER_UNITMEASUREMENT(
            "Error técnico ejecutando consulta de unidad de medida por filtro",
            "Se ha presentado un problema al tratar de ejecutar la sentencia de consulta por filtro para la unidad de medida. " +
                    "Verifique que la sintaxis SQL de la consulta sea correcta."),

    USER_ERROR_SQL_UNEXPECTED_ERROR_FIND_BY_FILTER_UNITMEASUREMENT(
            "Error inesperado al consultar información de la unidad de medida por filtro",
            "Ha ocurrido un problema inesperado al intentar buscar información de la unidad de medida por filtro. " +
                    "Por favor, intente nuevamente y si el problema persiste, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_FIND_BY_FILTER_UNITMEASUREMENT(
            "Error técnico inesperado en la consulta de unidad de medida por filtro",
            "Se ha presentado un error técnico inesperado (no-SQL) al intentar ejecutar la consulta por filtro de unidad de medida. " +
                    "Revise la traza completa de la excepción."),



    USER_ERROR_SQL_MAPPING_UNITMEASUREMENT(
            "Error interpretando la información de la unidad de medida",
            "Se ha presentado un problema tratando de interpretar la información de una unidad de medida consultada desde la base de datos. " +
                    "Por favor, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_MAPPING_UNITMEASUREMENT(
            "Error técnico mapeando el ResultSet a UnitMeasurementEntity",
            "Se ha presentado un problema técnico al mapear un registro del ResultSet a la entidad UnitMeasurementEntity. " +
                    "Verifique que los nombres de las columnas coincidan."),

    USER_ERROR_SQL_UNEXPECTED_MAPPING_UNITMEASUREMENT(
            "Error inesperado mapeando la información de la unidad de medida",
            "Se ha presentado un problema inesperado tratando de interpretar la información de la unidad de medida." +
                    " Por favor, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_UNEXPECTED_MAPPING_UNITMEASUREMENT(
            "Error técnico inesperado en el mapeo de UnitMeasurementEntity",
            "Se ha presentado un error inesperado (no-SQL) durante el proceso de mapeo del ResultSet a la entidad UnitMeasurementEntity. " +
                    "Revise la traza completa de la excepción.");


    private String title;
    private String content;

    MessagesEnumUnitMeasurementDAO (final String title, final String content) {
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