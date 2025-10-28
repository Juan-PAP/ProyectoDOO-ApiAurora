package co.edu.uco.aurora.crosscuting.messagescatalog.messagesenubusiness;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;

public enum MessagesEnumAdministratorBusiness {

    USER_ERROR_INVALID_CREDENTIALS("Invalid Credentials", "The user or password provided are incorrect."),

    USER_ERROR_UNEXPECTED_LOGIN_ERROR ("Unexpected Login Error", "An unexpected error occurred while trying to login. Please try again later."),

    TECHNICAL_ERROR_UNEXPECTED_LOGIN_ERROR ("Technical Unexpected Login Error", "An unexpected error occurred in the system while trying to login."),

    USER_ERROR_EMPTY_CREDENTIALS ("Empty Credentials", "The user and password must be provided.");
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
