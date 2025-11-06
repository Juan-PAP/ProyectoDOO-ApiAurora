package co.edu.uco.aurora.crosscuting.messagescatalog.controller;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;

public enum MessagesEnumIdentificationTypeController {

    ID_TYPES_LOADED_SUCCESS(
            "Carga de tipos de identificación exitosa",
            "Todos los tipos de identificación fueron cargados correctamente."
    ),

    ID_TYPES_UNEXPECTED_ERROR(
            "Error inesperado",
            "Ocurrió un error inesperado al cargar los tipos de identificación."
    );

    private String title;
    private String content;

    MessagesEnumIdentificationTypeController(final String title, final String content) {
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