package co.edu.uco.aurora.business.business.rule.validator.administrator;

import co.edu.uco.aurora.business.business.rule.administrator.AdministratorUsernameExistsRule;
import co.edu.uco.aurora.business.business.rule.validator.Validator;

public final class ValidateAdministratorUsernameExist implements Validator {

    private static final Validator instance = new ValidateAdministratorUsernameExist();

    private ValidateAdministratorUsernameExist() {

    }

    public static void executeValidation(final Object... data) {
        instance.validate(data);
    }

    @Override
    public void validate(final Object... data) {

        AdministratorUsernameExistsRule.executeRule(data);

    }
}