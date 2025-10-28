package co.edu.uco.aurora.crosscuting.messagescatalog.messagesenumfacade;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;

public enum MessagesEnumFacade {

    USER_ERROR_UNEXPECTED_ERROR ("Unexpected Error", "An unexpected error occurred while processing the request. Please try again later."),
    TECHNICAL_ERROR_UNEXPECTED_ERROR ("Technical Unexpected Error", "An unexpected error occurred in the system while processing the request.");

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
