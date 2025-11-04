package co.edu.uco.aurora.crosscuting.messagescatalog.facade;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;

public enum MessagesEnumFacade {

    USER_ERROR_UNEXPECTED_ERROR("Error Inesperado al procesar la solicitud en la fachada, por favor contacte al administrador del sistema",
            "Se ha presentado un error inesperado procesando su solicitud en la fachada. Por favor, intente de nuevo o contacte al administrador del sistema."),

    TECHNICAL_ERROR_UNEXPECTED_ERROR("Error Técnico Inesperado en la Fachada",
            "Se ha presentado un error inesperado (no-AuroraException) en la capa de Fachada (Facade) al procesar una solicitud. "
                    + "Revise la traza de error adjunta para determinar la causa raíz.");

    private String title;
    private String content;

    private MessagesEnumFacade (final String title, final String content) {
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
