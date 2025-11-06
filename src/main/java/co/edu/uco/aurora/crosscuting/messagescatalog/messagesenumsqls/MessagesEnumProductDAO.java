package co.edu.uco.aurora.crosscuting.messagescatalog.messagesenumsqls;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;

public enum MessagesEnumProductDAO {


    USER_ERROR_SQL_INSERT_PRODUCT(
            "Error al registrar la información del producto",
            "Se ha presentado un problema tratando de registrar la información del producto. " +
                    "Por favor intente de nuevo y si el problema persiste, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_INSERT_PRODUCT(
            "Error técnico al registrar la información del producto",
            "Se ha presentado un problema al tratar de ejecutar el proceso de creación de un producto. " +
                    "Por favor valide que la base de datos esté funcionando correctamente."),

    USER_ERROR_SQL_UNEXPECTED_ERROR_INSERT_PRODUCT(
            "Error inesperado al registrar la información del producto",
            "Se ha presentado un problema inesperado tratando de registrar la información del producto. " +
                    "Por favor intente nuevamente y si el problema persiste, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_INSERT_PRODUCT(
            "Error técnico inesperado al registrar la información del producto",
            "Se ha presentado un problema técnico inesperado al tratar de ejecutar el proceso de creación del producto. " +
                    "Revise los registros."),


    USER_ERROR_SQL_UPDATE_PRODUCT(
            "Error al actualizar la información del producto",
            "No fue posible actualizar los datos del producto. Por favor, verifique los datos ingresados e intente de nuevo."),

    TECHNICAL_ERROR_SQL_UPDATE_PRODUCT(
            "Error técnico al actualizar la información del producto",
            "Se ha presentado un error de tipo SQLException al intentar actualizar el registro del producto en la base de datos."),

    USER_ERROR_SQL_UNEXPECTED_ERROR_UPDATE_PRODUCT(
            "Error inesperado al actualizar la información del producto",
            "Ha ocurrido un error inesperado al intentar actualizar el registro del producto. Por favor, intente de nuevo más tarde."),

    TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_UPDATE_PRODUCT(
            "Error técnico inesperado al actualizar la información del producto",
            "Se ha presentado un error inesperado (no-SQL) al actualizar el registro del producto. Revise la traza completa de la excepción."),



    USER_ERROR_SQL_EXECUTING_FIND_BY_FILTER_PRODUCT(
            "Error consultando información del producto por filtro",
            "Se ha presentado un problema tratando de buscar información del producto por filtro en la base de datos. " +
                    "Por favor, intente de nuevo y si el problema persiste, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_EXECUTING_FIND_BY_FILTER_PRODUCT(
            "Error técnico ejecutando consulta de producto por filtro",
            "Se ha presentado un problema al tratar de ejecutar la sentencia de consulta por filtro para el producto. " +
                    "Verifique que la sintaxis SQL de la consulta sea correcta."),

    USER_ERROR_SQL_UNEXPECTED_ERROR_FIND_BY_FILTER_PRODUCT(
            "Error inesperado al consultar información del producto por filtro",
            "Ha ocurrido un problema inesperado al intentar buscar información del producto por filtro. " +
                    "Por favor, intente nuevamente y si el problema persiste, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_FIND_BY_FILTER_PRODUCT(
            "Error técnico inesperado en la consulta de producto por filtro",
            "Se ha presentado un error técnico inesperado (no-SQL) al intentar ejecutar la consulta por filtro de producto. " +
                    "Revise la traza completa de la excepción."),



    USER_ERROR_SQL_MAPPING_PRODUCT(
            "Error interpretando la información del producto",
            "Se ha presentado un problema tratando de interpretar la información de un producto consultada desde la base de datos. " +
                    "Por favor, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_MAPPING_PRODUCT(
            "Error técnico mapeando el ResultSet a ProductEntity",
            "Se ha presentado un problema técnico al mapear un registro del ResultSet a la entidad ProductEntity. " +
                    "Verifique que los nombres de las columnas coincidan."),

    USER_ERROR_SQL_UNEXPECTED_ERROR_MAPPING_PRODUCT(
            "Error inesperado mapeando la información del producto",
            "Se ha presentado un problema inesperado tratando de interpretar la información del producto." +
                    " Por favor, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_MAPPING_PRODUCT(
            "Error técnico inesperado en el mapeo de ProductEntity",
            "Se ha presentado un error inesperado (no-SQL) durante el proceso de mapeo del ResultSet a la entidad ProductEntity. " +
                    "Revise la traza completa de la excepción.");


    private String title;
    private String content;

    MessagesEnumProductDAO (final String title, final String content) {
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