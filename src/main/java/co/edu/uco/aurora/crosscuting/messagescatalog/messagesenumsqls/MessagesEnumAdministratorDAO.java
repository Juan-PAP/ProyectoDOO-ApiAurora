package co.edu.uco.aurora.crosscuting.messagescatalog.messagesenumsqls;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;

public enum MessagesEnumAdministratorDAO {

    //AdministratorSqlServerDAO

    //mapper
    USER_ERROR_SQL_MAPPING_ADMINISTRATOR ("Error interpretando la información del administrador",
            "Se ha presentado un problema tratando de interpretar la información de un administrador consultada desde la base de datos. " +
                    "Por favor, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_MAPPING_ADMINISTRATOR ("Error técnico mapeando el ResultSet a AdministratorEntity",
            "Se ha presentado un problema técnico al mapear un registro del ResultSet a la entidad AdministratorEntity. " +
                    "Verifique que los nombres de las columnas en la consulta SQL coincidan con los esperados por el método de mapeo."),

    USER_ERROR_SQL_UNEXPECTED_ERROR_MAPPING_ADMINISTRATOR ("Error inesperado mapeando la información del administrador",
            "Se ha presentado un problema inesperado tratando de interpretar la información del administrador. "
                    + "Por favor, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_MAPPING_ADMINISTRATOR ("Error técnico inesperado en el mapeo de AdministratorEntity",
            "Se ha presentado un error inesperado (no-SQL) durante el proceso de mapeo del ResultSet a la entidad AdministratorEntity. "
                    + "Revise la traza completa de la excepción para determinar la causa raíz."),

    //INSERTAR
    USER_ERROR_SQL_INSERT_ADMINISTRATOR("Error al registrar la información del nuevo administrador",
            "Se ha presentado un problema tratando de registrar la información del nuevo administrador. "
                    + "Por favor intente de nuevo y si el problema persiste, contacte al administrador del sistema."),


    TECHNICAL_ERROR_SQL_INSERT_ADMINISTRATOR("Error técnico al registrar la información del nuevo administrador",
            "Se ha presentado un problema al tratar de ejecutar el proceso de creación de un nuevo administrador en la base de datos. "
                    + "Por favor valide que la base de datos esté funcionando correctamente. "
                    + "Si el problema persiste, contacte al administrador del sistema."),

    USER_ERROR_SQL_UNEXPECTED_ERROR_INSERT_ADMINISTRATOR("Error inesperado al registrar la información del nuevo administrador",
            "Se ha presentado un problema inesperado tratando de registrar la información del nuevo administrador. "
                    + "Por favor intente nuevamente y si el problema persiste, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_INSERT_ADMINISTRATOR("Error técnico inesperado al registrar la información del nuevo usuario",
            "Se ha presentado un problema técnico inesperado al tratar de ejecutar el proceso de creación de un nuevo usuario. "
                    + "Por favor valide que la base de datos esté funcionando correctamente y revise los registros del sistema. "
                    + "Si el problema persiste, contacte al administrador del sistema."),

    //FINDALL
    USER_ERROR_SQL_EXECUTING_FIND_ALL_ADMINISTRATOR ("Error al consultar todos los administradores",
            "Se ha presentado un problema tratando de consultar la información de todos los administradores. "
                    + "Por favor intente de nuevo y si el problema persiste, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_EXECUTING_FIND_ALL_ADMINISTRATOR ("Error técnico al consultar todos los administradores",
            "Se ha presentado un problema técnico al tratar de ejecutar la consulta SQL para obtener la información de todos los administradores en la base de datos. "
                    + "Por favor valide que la conexión a la base de datos sea correcta. "
                    + "Si el problema persiste, revise la traza de la excepción y contacte al administrador."),

    USER_ERROR_SQL_UNEXPECTED_ERROR_FIND_ALL_ADMINISTRATOR ("Error inesperado al consultar todos los administradores",
            "Se ha presentado un problema inesperado tratando de consultar la información de todos los administradores. "
                    + "Por favor intente de nuevo y si el problema persiste, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_FIND_ALL_ADMINISTRATOR ("Error técnico inesperado al consultar todos los administradores",
            "Se ha presentado un problema técnico inesperado y fuera de control al tratar de consultar la información de todos los administradores. "
                    + "Por favor revise la traza de la excepción para identificar la causa raíz del inconveniente. "
                    + "Si el problema persiste, contacte al administrador."),
    //find by filter
    USER_ERROR_SQL_EXECUTING_FIND_BY_FILTER_ADMINISTRATOR ("Error al filtrar los administradores",
            "Se ha presentado un problema tratando de consultar los administradores que cumplen con los criterios de búsqueda especificados. "
                    + "Por favor intente de nuevo y si el problema persiste, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_EXECUTING_FIND_BY_FILTER_ADMINISTRATOR ("Error técnico al filtrar los administradores",
            "Se ha presentado un problema técnico al tratar de ejecutar la consulta SQL para filtrar la información de los administradores en la base de datos. "
                    + "Por favor valide que la conexión a la base de datos sea correcta. "
                    + "Si el problema persiste, revise la traza de la excepción y contacte al administrador."),

    USER_ERROR_SQL_UNEXPECTED_ERROR_FIND_BY_FILTER_ADMINISTRATOR ("Error inesperado al filtrar los usuarios",
            "Se ha presentado un problema inesperado tratando de filtrar la información de los usuarios. "
                    + "Por favor intente de nuevo y si el problema persiste, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_FIND_BY_FILTER_ADMINISTRATOR("Error técnico inesperado al filtrar los usuarios",
            "Se ha presentado un problema técnico inesperado y fuera de control al tratar de filtrar la información de los usuarios. "
                    + "Por favor revise la traza de la excepción para identificar la causa raíz del inconveniente. "
                    + "Si el problema persiste, contacte al administrador."),

    // Errores para la operación de Actualización (UPDATE)
    USER_ERROR_SQL_UPDATE_ADMINISTRATOR("Error al actualizar la información del administrador",
            "Se ha presentado un problema tratando de actualizar la información del administrador. "
                    + "Por favor intente de nuevo y si el problema persiste, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_UPDATE_ADMINISTRATOR("Error técnico al actualizar la información del administrador",
            "Se ha presentado un problema al tratar de ejecutar el proceso de actualización de un administrador. "
                    + "Por favor valide que la base de datos esté funcionando correctamente. "
                    + "Si el problema persiste, contacte al administrador del sistema."),

    // Errores Inesperados para la operación de Actualización (UPDATE)
    USER_ERROR_SQL_UNEXPECTED_ERROR_UPDATE_ADMINISTRATOR("Error inesperado al actualizar la información del administrador",
            "Se ha presentado un problema inesperado tratando de actualizar la información del administrador. "
                    + "Por favor intente nuevamente y si el problema persiste, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_UPDATE_ADMINISTRATOR("Error técnico inesperado al actualizar la información del administrador",
            "Se ha presentado un problema técnico inesperado al tratar de ejecutar el proceso de actualización del administrador. "
                    + "Por favor valide que la base de datos esté funcionando correctamente y revise los registros. "
                    + "Si el problema persiste, contacte al administrador del sistema.");

    private String title;
    private String content;

    MessagesEnumAdministratorDAO(final String title, final String content) {
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
