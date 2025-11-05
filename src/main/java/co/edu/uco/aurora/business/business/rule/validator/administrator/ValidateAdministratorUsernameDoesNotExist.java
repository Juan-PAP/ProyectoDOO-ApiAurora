package co.edu.uco.aurora.business.business.rule.validator.administrator;

import co.edu.uco.aurora.business.business.rule.administrator.AdministratorUsernameDoesNotExistRule;
import co.edu.uco.aurora.business.business.rule.validator.Validator;

public final class ValidateAdministratorUsernameDoesNotExist implements Validator {

    private static final Validator instance = new ValidateAdministratorUsernameDoesNotExist();

    private ValidateAdministratorUsernameDoesNotExist() {
        super();
    }

    public static void executeValidation(final Object... data) {
        instance.validate(data);
    }

    @Override
    public void validate(Object... data) {
        AdministratorUsernameDoesNotExistRule.executeRule(data);
    }
}