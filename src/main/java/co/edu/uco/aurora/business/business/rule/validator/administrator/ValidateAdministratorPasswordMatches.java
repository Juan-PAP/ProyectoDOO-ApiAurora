package co.edu.uco.aurora.business.business.rule.validator.administrator;

import co.edu.uco.aurora.business.business.rule.administrator.AdministratorPasswordMatchesRule;
import co.edu.uco.aurora.business.business.rule.validator.Validator;

public final class ValidateAdministratorPasswordMatches implements Validator {

    private static final Validator instance = new ValidateAdministratorPasswordMatches();

    private ValidateAdministratorPasswordMatches() {

    }

    public static void executeValidation(final Object... data) {
        instance.validate(data);
    }

    @Override
    public void validate(Object... data) {

        AdministratorPasswordMatchesRule.executeRule(data);

    }
}