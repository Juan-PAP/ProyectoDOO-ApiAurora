package co.edu.uco.aurora.crosscuting.messagescatalog;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;

public enum MessagesEnum {

    USER_ERROR_SQL_CONNECTION_IS_EMPTY("", ""),
    TECHNICAL_ERROR_SQL_CONNECTION_IS_EMPTY("",""),
    USER_ERROR_SQL_CONNECTION_IS_CLOSED("", ""),
    TECHNICAL_ERROR_SQL_CONNECTION_IS_CLOSED("", ""),
    USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONECTION_STATUS("", ""),
    TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONECTION_STATUS("", "");

    private String title;
    private String content;

    private MessagesEnum (final String title, final String content) {
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
