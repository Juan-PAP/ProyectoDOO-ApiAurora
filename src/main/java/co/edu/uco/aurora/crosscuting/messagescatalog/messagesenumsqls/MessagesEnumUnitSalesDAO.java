package co.edu.uco.aurora.crosscuting.messagescatalog.messagesenumsqls;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;

public enum MessagesEnumUnitSalesDAO {

    // Errores para la Operación de Mapeo (MAPPING) de la Unidad de Venta (UNITSALES)

    USER_ERROR_SQL_MAPPING_UNIT_SALES(
            "Error interpretando la información de la unidad de venta",
            "Se ha presentado un problema tratando de interpretar la información de una unidad de venta consultada desde la base de datos. "
                    + "Por favor, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_MAPPING_UNIT_SALES(
            "Error técnico mapeando el ResultSet a UnitSalesEntity",
            "Se ha presentado un problema técnico al mapear un registro del ResultSet a la entidad UnitSalesEntity. "
                    + "Verifique que los nombres de las columnas en la consulta SQL ('id', 'unidadMedida') coincidan con los esperados."),

    USER_ERROR_SQL_UNEXPECTED_ERROR_MAPPING_UNIT_SALES(
            "Error inesperado mapeando la información de la unidad de venta",
            "Se ha presentado un problema inesperado tratando de interpretar la información de la unidad de venta. "
                    + "Por favor, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_MAPPING_UNIT_SALES(
            "Error técnico inesperado en el mapeo de UnitSalesEntity",
            "Se ha presentado un error inesperado (no-SQL) durante el proceso de mapeo del ResultSet a la entidad UnitSalesEntity. "
                    + "Revise la traza completa de la excepción para determinar la causa raíz."),

        USER_ERROR_SQL_EXECUTING_FIND_BY_FILTER_UNIT_SALES( "Error consultando información de la unidad de venta por filtro",
                                                                   "Se ha presentado un problema tratando de buscar información de la unidad de venta por filtro en la base de datos. "
                                                                   + "Por favor, intente de nuevo y si el problema persiste, contacte al administrador del sistema."),

        TECHNICAL_ERROR_SQL_EXECUTING_FIND_BY_FILTER_UNIT_SALES(
    "Error técnico ejecutando consulta de unidad de venta por filtro",
            "Se ha presentado un problema al tratar de ejecutar la sentencia de consulta por filtro para la unidad de venta en la base de datos. "
            + "Verifique que la sintaxis SQL de la consulta sea correcta y que la conexión esté activa."),

        USER_ERROR_SQL_UNEXPECTED_ERROR_FIND_BY_FILTER_UNIT_SALES(
    "Error inesperado al consultar información de la unidad de venta por filtro",
            "Ha ocurrido un problema inesperado al intentar buscar información de la unidad de venta por filtro. "
            + "Por favor, intente nuevamente y si el problema persiste, contacte al administrador del sistema."),

        TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_FIND_BY_FILTER_UNIT_SALES(
    "Error técnico inesperado en la consulta de unidad de venta por filtro",
            "Se ha presentado un error técnico inesperado (no-SQL) al intentar ejecutar la consulta por filtro de unidad de venta. "
            + "Revise la traza completa de la excepción para determinar la causa raíz del fallo en el proceso de búsqueda.");

        private String title;
        private String content;

        private MessagesEnumUnitSalesDAO (final String title, final String content) {
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
