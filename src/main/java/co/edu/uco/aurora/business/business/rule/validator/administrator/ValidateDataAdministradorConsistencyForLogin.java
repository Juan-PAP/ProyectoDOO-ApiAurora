package co.edu.uco.aurora.business.business.rule.validator.administrator;

import co.edu.uco.aurora.business.business.rule.generics.StringLengthValuesIsValidRule;
import co.edu.uco.aurora.business.business.rule.generics.StringValueIsPresentRule;

import co.edu.uco.aurora.business.business.rule.validator.Validator;
import co.edu.uco.aurora.business.domain.AdministratorDomain;

public final class ValidateDataAdministradorConsistencyForLogin implements Validator {

    private static final Validator instance = new ValidateDataAdministradorConsistencyForLogin();

    private ValidateDataAdministradorConsistencyForLogin() {

    }

    public static void executeValidation(final Object... data) {
        instance.validate(data);
    }

    @Override
    public void validate(final Object... data) {

        var adminDomainData = (AdministratorDomain) data [0];

        validateEmptyData(adminDomainData);

        validateDataLength(adminDomainData);

    }

    private void validateEmptyData (final AdministratorDomain data) {
        StringValueIsPresentRule.executeRule(data.getUser(), "nombre de usuario", true);
        StringValueIsPresentRule.executeRule(data.getPassword(), "contraseña", false);
    }

    private void validateDataLength (final AdministratorDomain data) {
        StringLengthValuesIsValidRule.executeRule(data.getUser(), "nombre de usuario", 4, 20, true);
        StringLengthValuesIsValidRule.executeRule(data.getPassword(), "contraseña", 8, 12, false);
    }
}