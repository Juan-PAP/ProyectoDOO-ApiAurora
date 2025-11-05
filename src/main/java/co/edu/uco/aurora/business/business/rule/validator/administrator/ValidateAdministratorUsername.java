package co.edu.uco.aurora.business.business.rule.validator.administrator;

import co.edu.uco.aurora.business.business.rule.administrator.AdministratorUsernameValidationRule;
import co.edu.uco.aurora.business.business.rule.validator.Validator;

public final class ValidateAdministratorUsername implements Validator {

    private static final Validator instance = new ValidateAdministratorUsername();

    private ValidateAdministratorUsername() {
        super();
    }

    public static void executeValidation(final Object... data) {
        instance.validate(data);
    }

    @Override
    public void validate(Object... data) {
        AdministratorUsernameValidationRule.executeRule(data);
    }
}