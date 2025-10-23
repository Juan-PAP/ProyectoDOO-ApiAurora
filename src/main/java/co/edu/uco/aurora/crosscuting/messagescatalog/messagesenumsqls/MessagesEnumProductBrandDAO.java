package co.edu.uco.aurora.crosscuting.messagescatalog.messagesenumsqls;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;

public enum MessagesEnumProductBrandDAO {

    // Errores para la operación de Inserción (INSERT) de ProductoMarca (PRODUCTBRAND)

    USER_ERROR_SQL_INSERT_PRODUCTBRAND(
            "Error al registrar la información del producto y marca",
            "Se ha presentado un problema tratando de registrar la información del producto-marca. " +
                    "Por favor intente de nuevo y si el problema persiste, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_INSERT_PRODUCTBRAND(
            "Error técnico al registrar la información del producto y marca",
            "Se ha presentado un problema al tratar de ejecutar el proceso de creación de un registro en ProductoMarca. " +
                    "Por favor valide que la base de datos esté funcionando correctamente."),

    USER_ERROR_SQL_UNEXPECTED_ERROR_INSERT_PRODUCTBRAND(
            "Error inesperado al registrar la información del producto y marca",
            "Se ha presentado un problema inesperado tratando de registrar la información del producto-marca. " +
                    "Por favor intente nuevamente y si el problema persiste, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_INSERT_PRODUCTBRAND(
            "Error técnico inesperado al registrar la información del producto y marca",
            "Se ha presentado un problema técnico inesperado al tratar de ejecutar el proceso de creación del producto-marca. " +
                    "Revise los registros."),


    // Errores para la operación de Actualización (UPDATE) de ProductoMarca (PRODUCTBRAND)

    USER_ERROR_SQL_UPDATE_PRODUCTBRAND(
            "Error al actualizar la información del producto y marca",
            "No fue posible actualizar los datos del producto-marca. Por favor, verifique los datos ingresados e intente de nuevo."),

    TECHNICAL_ERROR_SQL_UPDATE_PRODUCTBRAND(
            "Error técnico al actualizar la información del producto y marca",
            "Se ha presentado un error de tipo SQLException al intentar actualizar el registro del producto-marca en la base de datos."),

    USER_ERROR_SQL_UNEXPECTED_ERROR_UPDATE_PRODUCTBRAND(
            "Error inesperado al actualizar la información del producto y marca",
            "Ha ocurrido un error inesperado al intentar actualizar el registro del producto-marca. Por favor, intente de nuevo más tarde."),

    TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_UPDATE_PRODUCTBRAND(
            "Error técnico inesperado al actualizar la información del producto y marca",
            "Se ha presentado un error inesperado (no-SQL) al actualizar el registro del producto-marca. Revise la traza completa de la excepción."),


    // Errores para la operación de Consulta por Filtro (FIND BY FILTER) de ProductoMarca (PRODUCTBRAND)

    USER_ERROR_SQL_EXECUTING_FIND_BY_FILTER_PRODUCTBRAND(
            "Error consultando información del producto y marca por filtro",
            "Se ha presentado un problema tratando de buscar información del producto-marca por filtro en la base de datos. " +
                    "Por favor, intente de nuevo y si el problema persiste, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_EXECUTING_FIND_BY_FILTER_PRODUCTBRAND(
            "Error técnico ejecutando consulta de producto y marca por filtro",
            "Se ha presentado un problema al tratar de ejecutar la sentencia de consulta por filtro para el producto-marca. " +
                    "Verifique que la sintaxis SQL de la consulta sea correcta."),

    USER_ERROR_SQL_UNEXPECTED_ERROR_FIND_BY_FILTER_PRODUCTBRAND(
            "Error inesperado al consultar información del producto y marca por filtro",
            "Ha ocurrido un problema inesperado al intentar buscar información del producto-luca por filtro. " +
                    "Por favor, intente nuevamente y si el problema persiste, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_FIND_BY_FILTER_PRODUCTBRAND(
            "Error técnico inesperado en la consulta de producto y marca por filtro",
            "Se ha presentado un error técnico inesperado (no-SQL) al intentar ejecutar la consulta por filtro de producto-marca. " +
                    "Revise la traza completa de la excepción."),


    // Errores para la Operación de Mapeo (MAPPING) de ProductoMarca (PRODUCTBRAND)

    USER_ERROR_SQL_MAPPING_PRODUCTBRAND(
            "Error interpretando la información del producto y marca",
            "Se ha presentado un problema tratando de interpretar la información de un producto-marca consultada desde la base de datos. " +
                    "Por favor, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_MAPPING_PRODUCTBRAND(
            "Error técnico mapeando el ResultSet a ProductBrandEntity",
            "Se ha presentado un problema técnico al mapear un registro del ResultSet a la entidad ProductBrandEntity. " +
                    "Verifique que los nombres de las columnas coincidan."),

    USER_ERROR_SQL_UNEXPECTED_MAPPING_PRODUCTBRAND(
            "Error inesperado mapeando la información del producto y marca",
            "Se ha presentado un problema inesperado tratando de interpretar la información del producto-marca." +
                    " Por favor, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_UNEXPECTED_MAPPING_PRODUCTBRAND(
            "Error técnico inesperado en el mapeo de ProductBrandEntity",
            "Se ha presentado un error inesperado (no-SQL) durante el proceso de mapeo del ResultSet a la entidad ProductBrandEntity. " +
                    "Revise la traza completa de la excepción.");


    private String title;
    private String content;

    private MessagesEnumProductBrandDAO (final String title, final String content) {
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