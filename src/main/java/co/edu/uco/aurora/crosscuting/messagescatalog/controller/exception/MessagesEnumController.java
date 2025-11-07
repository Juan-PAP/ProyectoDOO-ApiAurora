package co.edu.uco.aurora.crosscuting.messagescatalog.controller.exception;

public enum MessagesEnumController {

    ERROR_HTTP_MESSAGE_NOT_READABLE_GENERIC(
            "Formato de Datos Inválido",
            "El formato de los datos enviados no es válido. Por favor, revise los campos."
    ),
    ERROR_HTTP_MESSAGE_NOT_READABLE_INVALID_DATE(
            "Formato de Fecha Inválido",
            "La fecha proporcionada no es válida. Use el formato AAAA-MM-DD (ej: 2000-10-20)."
    );

    private String title;
    private String content;

    MessagesEnumController(String title, String content) {
        setTitle(title);
        setContent(content);
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    private void setContent(String content) {
        this.content = content;
    }
}