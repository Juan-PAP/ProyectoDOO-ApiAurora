package co.edu.uco.aurora.crosscuting.messagescatalog.messagesenubusiness;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;

public enum MessagesEnumAdministratorBusiness {

    USER_ERROR_INVALID_CREDENTIALS("Credenciales invalidas",
            "El usuario o la contraseña son incorrectos."),

    USER_ERROR_UNEXPECTED_LOGIN_ERROR ("Error Inesperado al iniciar de sesión",
            "Ocurrió un error inesperado al intentar iniciar sesión. Por favor, inténtalo de nuevo más tarde."),

    TECHNICAL_ERROR_UNEXPECTED_LOGIN_ERROR ("Error Técnico Inesperado de Inicio de Sesión",
            "Ocurrió un error inesperado en el sistema al intentar iniciar sesión."),

    USER_ERROR_EMPTY_CREDENTIALS ("Credenciales Vacías",
            "Se deben proporcionar el usuario y la contraseña.");

    private String title;
    private String content;

    MessagesEnumAdministratorBusiness(final String title, final String content) {
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
