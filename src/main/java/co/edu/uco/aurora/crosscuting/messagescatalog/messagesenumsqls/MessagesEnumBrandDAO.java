package co.edu.uco.aurora.crosscuting.messagescatalog.messagesenumsqls;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;

public enum MessagesEnumBrandDAO {

    USER_ERROR_SQL_INSERT_BRAND("Error al registrar la información de la nueva marca",
            "Se ha presentado un problema tratando de registrar la información de la nueva marca. "
                    + "Por favor intente de nuevo y si el problema persiste, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_INSERT_BRAND("Error técnico al registrar la información de la nueva marca",
            "Se ha presentado un problema al tratar de ejecutar el proceso de creación de una nueva marca. "
                    + "Por favor valide que la base de datos esté funcionando correctamente. "
                    + "Si el problema persiste, contacte al administrador del sistema."),

    USER_ERROR_SQL_UNEXPECTED_ERROR_INSERT_BRAND("Error inesperado al registrar la información de la marca",
            "Se ha presentado un problema inesperado tratando de registrar la información de la nueva marca. "
                    + "Por favor intente nuevamente y si el problema persiste, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_INSERT_BRAND("Error técnico inesperado al registrar la información de la marca",
            "Se ha presentado un problema técnico inesperado al tratar de ejecutar el proceso de creación de la marca. "
                    + "Por favor valide que la base de datos esté funcionando correctamente y revise los registros. "
                    + "Si el problema persiste, contacte al administrador del sistema."),


    USER_ERROR_SQL_EXECUTING_FIND_BY_FILTER_BRAND(
            "Error consultando información de la marca por filtro",
            "Se ha presentado un problema tratando de buscar información de la marca por filtro en la base de datos. "
                    + "Por favor, intente de nuevo y si el problema persiste, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_EXECUTING_FIND_BY_FILTER_BRAND(
            "Error técnico ejecutando consulta de marca por filtro",
            "Se ha presentado un problema al tratar de ejecutar la sentencia de consulta por filtro para la marca en la base de datos. "
                    + "Verifique que la sintaxis SQL de la consulta sea correcta y que la conexión esté activa."),

    USER_ERROR_SQL_UNEXPECTED_ERROR_FIND_BY_FILTER_BRAND(
            "Error inesperado al consultar información de la marca por filtro",
            "Ha ocurrido un problema inesperado al intentar buscar información de la marca por filtro. "
                    + "Por favor, intente nuevamente y si el problema persiste, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_FIND_BY_FILTER_BRAND(
            "Error técnico inesperado en la consulta de marca por filtro",
            "Se ha presentado un error técnico inesperado (no-SQL) al intentar ejecutar la consulta por filtro de marca. "
                    + "Revise la traza completa de la excepción para determinar la causa raíz del fallo en el proceso de búsqueda."),


    USER_ERROR_SQL_MAPPING_BRAND(
    "Error interpretando la información de la marca",
            "Se ha presentado un problema tratando de interpretar la información de una marca consultada desde la base de datos. "
            + "Por favor, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_MAPPING_BRAND(
    "Error técnico mapeando el ResultSet a BrandEntity",
            "Se ha presentado un problema técnico al mapear un registro del ResultSet a la entidad BrandEntity. "
            + "Verifique que los nombres de las columnas en la consulta SQL coincidan con los esperados por el método de mapeo."),

    USER_ERROR_SQL_UNEXPECTED_ERROR_MAPPING_BRAND(
    "Error inesperado mapeando la información de la marca",
            "Se ha presentado un problema inesperado tratando de interpretar la información de la marca. "
            + "Por favor, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_MAPPING_BRAND(
    "Error técnico inesperado en el mapeo de BrandEntity",
            "Se ha presentado un error inesperado (no-SQL) durante el proceso de mapeo del ResultSet a la entidad BrandEntity. "
            + "Revise la traza completa de la excepción para determinar la causa raíz."),


    USER_ERROR_SQL_UPDATE_BRAND(
            "Error al actualizar la información de la marca",
            "No fue posible actualizar los datos de la marca. Por favor, verifique los datos ingresados e intente de nuevo."),

    TECHNICAL_ERROR_SQL_UPDATE_BRAND(
            "Error técnico al actualizar la información de la marca",
            "Se ha presentado un error de tipo SQLException al intentar actualizar el registro de la marca en la base de datos."),

    USER_ERROR_SQL_UNEXPECTED_ERROR_UPDATE_BRAND(
            "Error inesperado al actualizar la información de la marca",
            "Ha ocurrido un error inesperado al intentar actualizar el registro de la marca. Por favor, intente de nuevo más tarde."),

    TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_UPDATE_BRAND(
            "Error técnico inesperado al actualizar la información de la marca",
            "Se ha presentado un error inesperado (no-SQL) al actualizar el registro de la marca. Revise la traza completa de la excepción para determinar la causa raíz.");

    private String title;
    private String content;

    MessagesEnumBrandDAO(final String title, final String content) {
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
