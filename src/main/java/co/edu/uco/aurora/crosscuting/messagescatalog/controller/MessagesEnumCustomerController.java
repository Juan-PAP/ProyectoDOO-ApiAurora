package co.edu.uco.aurora.crosscuting.messagescatalog.controller;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;

public enum MessagesEnumCustomerController {

    CUSTOMERS_FILTERED_SUCCESS(
            "Consulta de clientes exitosa",
            "Todos los clientes fueron obtenidos correctamente."
    ),

    CUSTOMER_REGISTER_SUCCESS(
            "Registro de cliente exitoso",
            "La información del cliente se registró correctamente."
    ),

    CUSTOMERS_UNEXPECTED_ERROR(
            "Error inesperado",
            "Ocurrió un error inesperado al procesar la solicitud relacionada con clientes."
    );

    private String title;
    private String content;

    MessagesEnumCustomerController(final String title, final String content) {
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