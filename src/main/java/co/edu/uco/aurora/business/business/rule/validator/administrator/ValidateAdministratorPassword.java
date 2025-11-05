package co.edu.uco.aurora.business.business.rule.validator.administrator;

import co.edu.uco.aurora.business.business.rule.administrator.AdministratorPasswordValidationRule;
import co.edu.uco.aurora.business.business.rule.validator.Validator;

public final class ValidateAdministratorPassword implements Validator {

    private static final Validator instance = new ValidateAdministratorPassword();

    private ValidateAdministratorPassword() {
        super();
    }

    public static void executeValidation(final Object... data) {
        instance.validate(data);
    }

    @Override
    public void validate(Object... data) {
        AdministratorPasswordValidationRule.executeRule(data);
    }
}