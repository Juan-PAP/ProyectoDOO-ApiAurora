package co.edu.uco.aurora.crosscuting.messagescatalog.messagesenumsqls;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;

public enum MessagesEnumSaleDAO {


    USER_ERROR_SQL_INSERT_SALE(
            "Error al registrar la información de la venta",
            "Se ha presentado un problema tratando de registrar la información de la venta. " +
                    "Por favor intente de nuevo y si el problema persiste, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_INSERT_SALE(
            "Error técnico al registrar la información de la venta",
            "Se ha presentado un problema al tratar de ejecutar el proceso de creación de una venta. " +
                    "Por favor valide que la base de datos esté funcionando correctamente."),

    USER_ERROR_SQL_UNEXPECTED_ERROR_INSERT_SALE(
            "Error inesperado al registrar la información de la venta",
            "Se ha presentado un problema inesperado tratando de registrar la información de la venta. " +
                    "Por favor intente nuevamente y si el problema persiste, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_INSERT_SALE(
            "Error técnico inesperado al registrar la información de la venta",
            "Se ha presentado un problema técnico inesperado al tratar de ejecutar el proceso de creación de la venta. " +
                    "Revise los registros."),



    USER_ERROR_SQL_EXECUTING_FIND_BY_FILTER_SALE(
            "Error consultando información de la venta por filtro",
            "Se ha presentado un problema tratando de buscar información de la venta por filtro en la base de datos. " +
                    "Por favor, intente de nuevo y si el problema persiste, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_EXECUTING_FIND_BY_FILTER_SALE(
            "Error técnico ejecutando consulta de venta por filtro",
            "Se ha presentado un problema al tratar de ejecutar la sentencia de consulta por filtro para la venta. " +
                    "Verifique que la sintaxis SQL de la consulta sea correcta."),

    USER_ERROR_SQL_UNEXPECTED_ERROR_FIND_BY_FILTER_SALE(
            "Error inesperado al consultar información de la venta por filtro",
            "Ha ocurrido un problema inesperado al intentar buscar información de la venta por filtro. " +
                    "Por favor, intente nuevamente y si el problema persiste, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_FIND_BY_FILTER_SALE(
            "Error técnico inesperado en la consulta de venta por filtro",
            "Se ha presentado un error técnico inesperado (no-SQL) al intentar ejecutar la consulta por filtro de venta. " +
                    "Revise la traza completa de la excepción."),



    USER_ERROR_SQL_MAPPING_SALE(
            "Error interpretando la información de la venta",
            "Se ha presentado un problema tratando de interpretar la información de una venta consultada desde la base de datos. " +
                    "Por favor, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_MAPPING_SALE(
            "Error técnico mapeando el ResultSet a SaleEntity",
            "Se ha presentado un problema técnico al mapear un registro del ResultSet a la entidad SaleEntity. " +
                    "Verifique que los nombres de las columnas coincidan."),

    USER_ERROR_SQL_UNEXPECTED_ERROR_MAPPING_SALE(
            "Error inesperado mapeando la información de la venta",
            "Se ha presentado un problema inesperado tratando de interpretar la información de la venta." +
                    " Por favor, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_MAPPING_SALE(
            "Error técnico inesperado en el mapeo de SaleEntity",
            "Se ha presentado un error inesperado (no-SQL) durante el proceso de mapeo del ResultSet a la entidad SaleEntity. " +
                    "Revise la traza completa de la excepción.");


    private String title;
    private String content;

    MessagesEnumSaleDAO (final String title, final String content) {
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