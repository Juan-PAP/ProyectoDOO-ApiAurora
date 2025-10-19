package co.edu.uco.aurora.crosscuting.messagescatalog.messagesenumsqls;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;

public enum MessagesEnumIdentificationTypeDAO {

    USER_ERROR_SQL_EXECUTING_FIND_BY_FILTER_IDENTIFICATION_TYPE("Error al consultar los tipos de identificación",
            "Se ha presentado un problema tratando de consultar la información de los tipos de identificación. "
                    + "Por favor intente de nuevo y si el problema persiste, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_EXECUTING_FIND_BY_FILTER_IDENTIFICATION_TYPE("Error técnico al consultar los tipos de identificación",
            "Se ha presentado un problema técnico al tratar de ejecutar la consulta SQL para obtener la información de los tipos de identificación en la base de datos. "
                    + "Por favor valide que la conexión a la base de datos sea correcta. "
                    + "Si el problema persiste, revise la traza de la excepción y contacte al administrador."),

    USER_ERROR_SQL_MAPPING_IDENTIFICATION_TYPE("Error al procesar los datos del tipo de identificación",
            "Se ha presentado un problema tratando de procesar los datos del tipo de identificación consultado. "
                    + "Por favor intente de nuevo y si el problema persiste, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_MAPPING_IDENTIFICATION_TYPE("Error técnico al mapear los datos del tipo de identificación",
            "Se ha presentado un problema técnico al tratar de mapear los datos del tipo de identificación desde el resultado de la consulta SQL (ResultSet) a la entidad correspondiente. "
                    + "Por favor valide que los tipos de datos y nombres de las columnas en la consulta coincidan con la entidad. "
                    + "Si el problema persiste, revise la traza de la excepción."),

    USER_ERROR_SQL_UNEXPECTED_MAPPING_IDENTIFICATION_TYPE("Error inesperado al procesar los datos del tipo de identificación",
            "Se ha presentado un problema inesperado tratando de procesar los datos del tipo de identificación. "
                    + "Por favor intente de nuevo y si el problema persiste, contacte al administrador del sistema."),

    TECHNICAL_ERROR_SQL_UNEXPECTED_MAPPING_IDENTIFICATION_TYPE("Error técnico inesperado al mapear los datos del tipo de identificación",
            "Se ha presentado un problema técnico inesperado y fuera de control al tratar de mapear los datos del tipo de identificación. "
                    + "Por favor revise la traza de la excepción para identificar la causa raíz del inconveniente. "
                    + "Si el problema persiste, contacte al administrador.");



    private String title;
    private String content;

    private MessagesEnumIdentificationTypeDAO (final String title, final String content) {
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
