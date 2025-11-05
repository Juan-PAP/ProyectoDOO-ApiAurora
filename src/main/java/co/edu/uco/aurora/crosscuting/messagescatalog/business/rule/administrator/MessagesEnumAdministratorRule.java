package co.edu.uco.aurora.crosscuting.messagescatalog.business.rule.administrator;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;

public enum MessagesEnumAdministratorRule {

    // java
// Nuevos enums para agregar a MessagesEnumAdministratorRule

    // Mensajes para AdministratorUsernameExistsRule
    ADMIN_USERNAME_EXISTS_RULE_DATA_IS_NULL("El nombre de usuario no puede ser nulo.", "Los datos para la regla AdministratorUsernameExistsRule son nulos."),
    ADMIN_USERNAME_EXISTS_RULE_DATA_LENGTH_INVALID("La cantidad de datos para validar el nombre de usuario no es válida.", "La cantidad de datos para la regla AdministratorUsernameExistsRule no es la esperada (se esperan 2, DAOFactory y username)."),
    ADMIN_USERNAME_EXISTS_RULE_USERNAME_DOES_NOT_EXIST("Usuario o contraseña no válidos.", "El nombre de usuario '{0}' no existe en la base de datos."),

    // Mensajes para AdministratorPasswordMatchesRule
    ADMIN_PASSWORD_MATCHES_RULE_DATA_IS_NULL("Los datos para validar la contraseña no pueden ser nulos.", "Los datos para la regla AdministratorPasswordMatchesRule son nulos."),
    ADMIN_PASSWORD_MATCHES_RULE_DATA_LENGTH_INVALID("La cantidad de datos para validar la contraseña no es válida.", "La cantidad de datos para la regla AdministratorPasswordMatchesRule no es la esperada (se esperan 3, DAOFactory, username y password)."),
    ADMIN_PASSWORD_MATCHES_RULE_PASSWORD_DOES_NOT_MATCH("Usuario o contraseña no válidos.", "La contraseña proporcionada para el usuario '{0}' no coincide con la almacenada en la base de datos."),

    // --- MENSAJES PARA AdministratorUsernameDoesNotExistRule ---
    ADMIN_USERNAME_DOES_NOT_EXIST_RULE_DATA_IS_NULL(
            "Se ha presentado un problema inesperado tratando de validar la unicidad del nombre de usuario.",
            "No se recibieron los parámetros requeridos para ejecutar la regla AdministratorUsernameDoesNotExistRule."
    ),
    ADMIN_USERNAME_DOES_NOT_EXIST_RULE_DATA_LENGTH_INVALID(
            "Se ha presentado un problema inesperado tratando de validar la unicidad del nombre de usuario.",
            "Se requerían 2 parámetros (String username, DAOFactory) y llegó una cantidad menor para ejecutar la regla AdministratorUsernameDoesNotExistRule."
    ),
    ADMIN_USERNAME_DOES_NOT_EXIST_RULE_ADMIN_ALREADY_EXISTS(
            "Ya existe un administrador registrado con el nombre de usuario ingresado.",
            "La regla AdministratorUsernameDoesNotExistRule falló porque ya existe un administrador con el username: {0}"
    ),

    // --- MENSAJES PARA AdministratorUsernameValidationRule ---
    ADMIN_USERNAME_VALIDATION_RULE_DATA_IS_NULL_OR_INVALID_LENGTH(
            "Se ha presentado un problema inesperado tratando de validar el formato del nombre de usuario.",
            "No se recibió el parámetro requerido (String username) para ejecutar la regla AdministratorUsernameValidationRule."
    ),
    ADMIN_USERNAME_VALIDATION_RULE_FORMAT_INVALID(
            "El nombre de usuario no cumple con el formato requerido.",
            "La regla AdministratorUsernameValidationRule falló. El usuario debe ser alfanumérico y tener entre 4 y 20 caracteres. Valor recibido: {0}"
    ),

    // --- MENSAJES PARA AdministratorPasswordValidationRule ---
    ADMIN_PASSWORD_VALIDATION_RULE_DATA_IS_NULL_OR_INVALID_LENGTH(
            "Se ha presentado un problema inesperado tratando de validar el formato de la contraseña.",
            "No se recibió el parámetro requerido (String password) para ejecutar la regla AdministratorPasswordValidationRule."
    ),
    ADMIN_PASSWORD_VALIDATION_RULE_FORMAT_INVALID(
            "La contraseña no cumple con el formato requerido.",
            "La regla AdministratorPasswordValidationRule falló. La contraseña debe ser alfanumérica y tener entre 8 y 12 caracteres."
    );

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