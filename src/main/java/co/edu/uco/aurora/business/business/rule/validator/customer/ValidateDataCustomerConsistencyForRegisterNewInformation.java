package co.edu.uco.aurora.business.business.rule.validator.customer;

import co.edu.uco.aurora.business.business.rule.generics.IdValueIsNotDefaultValueRule;
import co.edu.uco.aurora.business.business.rule.generics.StringFormatValuesIsValidRule;
import co.edu.uco.aurora.business.business.rule.generics.StringLengthValuesIsValidRule;
import co.edu.uco.aurora.business.business.rule.generics.StringValueIsPresentRule;

import co.edu.uco.aurora.business.business.rule.validator.Validator;
import co.edu.uco.aurora.business.domain.CustomerDomain;

public final class ValidateDataCustomerConsistencyForRegisterNewInformation implements Validator {

    private static final String NAME_REGEX = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]{3,100}$";

    private static final String PHONE_NUMBER_REGEX = "^[0-9]{8,15}$";

    private static final String ID_NUMBER_REGEX = "^[0-9]{6,25}$";

    private static final Validator instance = new ValidateDataCustomerConsistencyForRegisterNewInformation();

    private ValidateDataCustomerConsistencyForRegisterNewInformation() {

    }

    public static void executeValidation(final Object... data) {
        instance.validate(data);
    }

    @Override
    public void validate(final Object... data) {
        var customerDomainData = (CustomerDomain) data [0];

        sanitizeInputData(customerDomainData);

        validateEmptyData(customerDomainData);

        validateDataLength(customerDomainData);

        validateDataFormat(customerDomainData);

        validateDomainObjectsAndConsistency(customerDomainData);
    }

    private void sanitizeInputData(final CustomerDomain data) {
        if (data.getFullName() != null) {
            String cleanedName = data.getFullName()
                    .replaceAll("\\s+", " ")
                    .trim();
            data.setFullName(cleanedName);
        }
        if (data.getIdentificationNumber() != null) {
            data.setIdentificationNumber(data.getIdentificationNumber().trim());
        }
        if (data.getPhoneNumber() != null) {
            data.setPhoneNumber(data.getPhoneNumber().trim());
        }
    }

    private void validateEmptyData (final CustomerDomain data) {
        StringValueIsPresentRule.executeRule(data.getIdentificationNumber(), "número de identificación", true);
        StringValueIsPresentRule.executeRule(data.getFullName(), "nombre completo", true);
        StringValueIsPresentRule.executeRule(data.getPhoneNumber(), "número de teléfono", true);
    }


    private void validateDataLength (final CustomerDomain data) {
        StringLengthValuesIsValidRule.executeRule(data.getIdentificationNumber(), "número de identificación", 6, 25, true);
        StringLengthValuesIsValidRule.executeRule(data.getFullName(), "nombre completo", 3, 100, true);
        StringLengthValuesIsValidRule.executeRule(data.getPhoneNumber(), "número de teléfono", 8, 15, true);
    }

    private void validateDataFormat(final CustomerDomain data) {
        StringFormatValuesIsValidRule.executeRule(data.getIdentificationNumber(), "número de identificación", ID_NUMBER_REGEX, true);
        StringFormatValuesIsValidRule.executeRule(data.getFullName(), "nombre completo", NAME_REGEX, true);
        StringFormatValuesIsValidRule.executeRule(data.getPhoneNumber(), "número de teléfono", PHONE_NUMBER_REGEX, true);
    }

    private void validateDomainObjectsAndConsistency(final CustomerDomain data) {
        IdValueIsNotDefaultValueRule.executeRule(data.getIdentificationType().getId(), "Tipo de Identificación");
    }
}
