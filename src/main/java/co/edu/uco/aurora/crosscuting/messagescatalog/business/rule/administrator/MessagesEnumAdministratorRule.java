package co.edu.uco.aurora.crosscuting.messagescatalog.business.rule.administrator;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;

public enum MessagesEnumAdministratorRule {

    // Mensajes para AdministratorUsernameExistsRule
    ADMIN_USERNAME_EXISTS_RULE_DATA_IS_NULL("El nombre de usuario no puede ser nulo.",
            "Los datos para la regla AdministratorUsernameExistsRule son nulos."),
    ADMIN_USERNAME_EXISTS_RULE_DATA_LENGTH_INVALID("La cantidad de datos para validar el nombre de usuario no es válida.",
            "La cantidad de datos para la regla AdministratorUsernameExistsRule no es la esperada (se esperan 2, DAOFactory y username)."),
    ADMIN_USERNAME_EXISTS_RULE_USERNAME_DOES_NOT_EXIST("Usuario o contraseña no válidos.",
            "El nombre de usuario '{0}' no existe en la base de datos."),

    // Mensajes para AdministratorPasswordMatchesRule
    ADMIN_PASSWORD_MATCHES_RULE_DATA_IS_NULL("Los datos para validar la contraseña no pueden ser nulos.", "Los datos para la regla AdministratorPasswordMatchesRule son nulos."),
    ADMIN_PASSWORD_MATCHES_RULE_DATA_LENGTH_INVALID("La cantidad de datos para validar la contraseña no es válida.", "La cantidad de datos para la regla AdministratorPasswordMatchesRule no es la esperada (se esperan 3, DAOFactory, username y password)."),
    ADMIN_PASSWORD_MATCHES_RULE_PASSWORD_DOES_NOT_MATCH("Usuario o contraseña no válidos.", "La contraseña proporcionada para el usuario '{0}' no coincide con la almacenada en la base de datos.");

    private String title;
    private String content;

    private MessagesEnumAdministratorRule(final String title, final String content) {
        setTitle(title);
        setContent(content);
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = TextHelper.getDefaultWithTrim(title);
    }

    public String getContent() {
        return content;
    }

    private void setContent(String content) {
        this.content = TextHelper.getDefaultWithTrim(content);
    }
}