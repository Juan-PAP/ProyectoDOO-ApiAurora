package co.edu.uco.aurora.crosscuting.messagescatalog.business.rule.customer;

import co.edu.uco.aurora.crosscuting.helper.TextHelper;

public enum MessagesEnumCustomerRule {

    CUSTOMER_BIRTHDATE_MIN_AGE_RULE_DATA_IS_NULL(
            "Datos nulos para validación de fecha de nacimiento",
            "Los datos recibidos para validar la fecha de nacimiento son nulos."
    ),
    CUSTOMER_BIRTHDATE_MIN_AGE_RULE_DATA_LENGTH_INVALID(
            "Cantidad de datos inválida para validación de fecha de nacimiento",
            "Se esperaba 1 dato: fecha de nacimiento."
    ),
    CUSTOMER_BIRTHDATE_MIN_AGE_RULE_BIRTHDATE_IS_NULL(
            "Fecha de nacimiento requerida",
            "La fecha de nacimiento no puede ser nula."
    ),
    CUSTOMER_BIRTHDATE_MIN_AGE_RULE_AGE_INVALID(
            "La edad ingresada [edad: {0}], es menor a 7 años",
            "La edad calculada ({0} años) es inferior al mínimo permitido de 7 años."
    ),

    CUSTOMER_ID_NUMBER_DOES_NOT_EXIST_RULE_DATA_IS_NULL(
            "Se ha presentado un problema inesperado tratando de llevar a cabo la operación deseada.",
            "No se recibieron los parámetros requeridos para ejecutar la regla CustomerIdentificationNumberDoesNotExistRule."
    ),
    CUSTOMER_ID_NUMBER_DOES_NOT_EXIST_RULE_DATA_LENGTH_INVALID(
            "Se ha presentado un problema inesperado tratando de llevar a cabo la operación deseada.",
            "Se requerían 2 parámetros (String idNumber, DAOFactory) y llegó una cantidad menor para ejecutar la regla CustomerIdentificationNumberDoesNotExistRule."
    ),
    CUSTOMER_ID_NUMBER_DOES_NOT_EXIST_RULE_CUSTOMER_ALREADY_EXISTS(
            "Ya existe un cliente registrado con el número de identificación ingresado.",
            "La regla CustomerIdentificationNumberDoesNotExistRule falló porque ya existe un cliente con el IdNumber: {0}"
    ),


    CUSTOMER_PHONE_NUMBER_DOES_NOT_EXIST_RULE_DATA_IS_NULL(
            "Se ha presentado un problema inesperado tratando de llevar a cabo la operación deseada.",
                    "No se recibieron los parámetros requeridos para ejecutar la regla CustomerPhoneNumberDoesNotExistRule."
    ),
    CUSTOMER_PHONE_NUMBER_DOES_NOT_EXIST_RULE_DATA_LENGTH_INVALID(
            "Se ha presentado un problema inesperado tratando de llevar a cabo la operación deseada.",
                    "Se requerían 2 parámetros (String phoneNumber, DAOFactory) y llegó una cantidad menor para ejecutar la regla CustomerPhoneNumberDoesNotExistRule."
    ),
    CUSTOMER_PHONE_NUMBER_DOES_NOT_EXIST_RULE_CUSTOMER_ALREADY_EXISTS(
            "Ya existe un cliente registrado con el número de teléfono ingresado.",
                    "La regla CustomerPhoneNumberDoesNotExistRule falló porque ya existe un cliente con el número de teléfono: {0}"
    ),


    CUSTOMER_AGE_CONSISTENCY_RULE_DATA_IS_NULL(
            "Se ha presentado un problema inesperado tratando de llevar a cabo la operación deseada.",
            "No se recibieron los parámetros requeridos para ejecutar la regla CustomerAgeIsConsistentWithIdTypeRule."
    ),
    CUSTOMER_AGE_CONSISTENCY_RULE_DATA_LENGTH_INVALID(
            "Se ha presentado un problema inesperado tratando de llevar a cabo la operación deseada.",
            "Se requerían 2 parámetros (LocalDate birthDate, IdentificationTypeDomain idType) y llegó una cantidad menor."
    ),
    CUSTOMER_AGE_CONSISTENCY_RULE_BIRTHDATE_IS_NULL(
            "Se ha presentado un problema inesperado. La fecha de nacimiento es nula.",
            "CustomerAgeIsConsistentWithIdTypeRule falló porque birthDate es nulo."
    ),
    CUSTOMER_AGE_CONSISTENCY_RULE_IDTYPE_IS_NULL(
            "Se ha presentado un problema inesperado. El tipo de identificación es nulo.",
            "CustomerAgeIsConsistentWithIdTypeRule falló porque IdentificationTypeDomain es nulo."
    ),
    CUSTOMER_AGE_CONSISTENCY_RULE_TI_AGE_INVALID(
            "La edad ({0} años) no es válida para una Tarjeta de Identidad. El rango debe ser entre 7 y 17 años.",
            "Inconsistencia: Edad {0} años. Documento: {1}. Rango TI: 7-17."
    ),
    CUSTOMER_AGE_CONSISTENCY_RULE_CC_AGE_INVALID( // <-- ¡Esta es la que causó el 500!
            "La edad ({0} años) no es válida para una Cédula de Ciudadanía. Debe ser mayor o igual a 18 años.",
            "Inconsistencia: Edad {0} años. Documento: {1}. Rango CC: >= 18."
    );


    private String title;
    private String content;

    MessagesEnumCustomerRule(final String title, final String content) {
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