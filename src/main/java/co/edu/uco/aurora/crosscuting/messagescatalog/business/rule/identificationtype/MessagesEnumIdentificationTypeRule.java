package co.edu.uco.aurora.crosscuting.messagescatalog.business.rule.identificationtype;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;

public enum MessagesEnumIdentificationTypeRule {

    ID_TYPE_EXISTS_BY_ID_RULE_DATA_IS_NULL(
            "Se ha presentado un problema inesperado tratando de llevar a cabo la operación deseada.",
            "No se recibieron los parámetros requeridos para ejecutar la regla IdentificationTypeExistByIdRule."
    ),
    ID_TYPE_EXISTS_BY_ID_RULE_DATA_LENGTH_INVALID(
            "Se ha presentado un problema inesperado tratando de llevar a cabo la operación deseada.",
            "Se requerían 2 parámetros y llegó una cantidad menor para ejecutar la regla IdentificationTypeExistByIdRule."
    ),
    ID_TYPE_EXISTS_BY_ID_RULE_ID_TYPE_NOT_FOUND(
            "El tipo de identificación deseado no existe...",
            "El tipo de identificación con id [{0}] no existe ..."
    );

    private String title;
    private String content;

    private MessagesEnumIdentificationTypeRule(final String title, final String content) {
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