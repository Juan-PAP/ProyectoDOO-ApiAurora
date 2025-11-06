package co.edu.uco.aurora.crosscuting.messagescatalog.controller;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;

public enum MessagesEnumAdministratorController {

    ADMIN_LOGIN_SUCCESS(
            "Inicio de sesión de administrador exitosa",
            "El administrador ha iniciado sesión correctamente."
    ),

    ADMIN_LOGIN_UNEXPECTED_ERROR(
            "Error inesperado al iniciar sesión",
            "Ocurrió un error inesperado durante el inicio de sesión del administrador."
    );

    private String title;
    private String content;

    MessagesEnumAdministratorController(final String title, final String content) {
        setTitle(title);
        setContent(content);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = TextHelper.getDefaultWithTrim(title);
    }

    public String getContent() {
        return content;
    }

    public void setContent(final String content) {
        this.content = TextHelper.getDefaultWithTrim(content);
    }
}