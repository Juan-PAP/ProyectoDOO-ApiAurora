package co.edu.uco.aurora.crosscuting.messagescatalog.messagesenumsqls;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;

public enum MessagesEnumCategoryDAO {

    //Crear
    USER_ERROR_SQL_INSERT_CATEGORY("Error al crear la categoría",
            "Se ha presentado un problema tratando de crear la nueva categoría. "
                    + "Por favor intente de nuevo y si el problema persiste, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_INSERT_CATEGORY("Error técnico al crear la categoría",
            "Se ha presentado un problema técnico al tratar de ejecutar la sentencia SQL para insertar la categoría en la base de datos. "
                    + "Por favor valide la traza de la excepción para identificar la causa."),

    USER_ERROR_SQL_UNEXPECTED_ERROR_INSERT_CATEGORY("Error inesperado al crear la categoría",
            "Se ha presentado un problema inesperado tratando de crear la nueva categoría. "
                    + "Por favor intente de nuevo y si el problema persiste, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_INSERT_CATEGORY("Error técnico inesperado al crear la categoría",
            "Se ha presentado un problema técnico inesperado y fuera de control al tratar de crear la nueva categoría. "
                    + "Por favor revise la traza de la excepción para identificar la causa raíz del inconveniente."),


    //Actualizar
    USER_ERROR_SQL_UPDATE_CATEGORY("Error al actualizar la categoría",
            "Se ha presentado un problema tratando de actualizar la información de la categoría. "
                    + "Por favor intente de nuevo y si el problema persiste, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_UPDATE_CATEGORY("Error técnico al actualizar la categoría",
            "Se ha presentado un problema técnico al tratar de ejecutar la sentencia SQL para actualizar la categoría en la base de datos. "
                    + "Por favor valide la traza de la excepción para identificar la causa."),

    USER_ERROR_SQL_UNEXPECTED_ERROR_UPDATE_CATEGORY("Error inesperado al actualizar la categoría",
            "Se ha presentado un problema inesperado tratando de actualizar la información de la categoría. "
                    + "Por favor intente de nuevo y si el problema persiste, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_UPDATE_CATEGORY("Error técnico inesperado al actualizar la categoría",
            "Se ha presentado un problema técnico inesperado y fuera de control al tratar de actualizar la información de la categoría. "
                    + "Por favor revise la traza de la excepción para identificar la causa raíz del inconveniente."),

    // Para la Ejecución de Consultas (findByFilter)
    USER_ERROR_SQL_EXECUTING_FIND_BY_FILTER_CATEGORY("Error al consultar las categorías",
            "Se ha presentado un problema tratando de consultar la información de las categorías. "
                    + "Por favor intente de nuevo y si el problema persiste, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_EXECUTING_FIND_BY_FILTER_CATEGORY("Error técnico al consultar las categorías",
            "Se ha presentado un problema técnico al tratar de ejecutar la consulta SQL para obtener la información de las categorías en la base de datos. "
                    + "Por favor valide que la conexión a la base de datos sea correcta."),


    // Para el Mapeo de Resultados (ResultSet a Entidad)
    USER_ERROR_SQL_MAPPING_CATEGORY("Error al procesar los datos de la categoría",
            "Se ha presentado un problema tratando de procesar los datos de la categoría consultada. "
                    + "Por favor intente de nuevo y si el problema persiste, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_MAPPING_CATEGORY("Error técnico al mapear los datos de la categoría",
            "Se ha presentado un problema técnico al tratar de mapear los datos de la categoría desde el resultado de la consulta SQL (ResultSet) a la entidad correspondiente."),

    USER_ERROR_SQL_UNEXPECTED_MAPPING_CATEGORY("Error inesperado al procesar los datos de la categoría",
            "Se ha presentado un problema inesperado tratando de procesar los datos de la categoría. "
                    + "Por favor intente de nuevo y si el problema persiste, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_UNEXPECTED_MAPPING_CATEGORY("Error técnico inesperado al mapear los datos de la categoría",
            "Se ha presentado un problema técnico inesperado y fuera de control al tratar de mapear los datos de la categoría.");


    private String title;
    private String content;

    private MessagesEnumCategoryDAO (final String title, final String content) {
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
