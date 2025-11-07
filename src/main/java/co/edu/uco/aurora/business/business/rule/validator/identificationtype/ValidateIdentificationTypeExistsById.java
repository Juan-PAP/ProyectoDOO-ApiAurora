package co.edu.uco.aurora.business.business.rule.validator.identificationtype;

import co.edu.uco.aurora.business.business.rule.identificationtype.IdentificationTypeExistByIdRule;
import co.edu.uco.aurora.business.business.rule.validator.Validator;

public final class ValidateIdentificationTypeExistsById implements Validator {

    private static final Validator instance = new ValidateIdentificationTypeExistsById();

    private ValidateIdentificationTypeExistsById() {

    }

    public static void executeValidation(final Object... data) {
        instance.validate(data);
    }


    @Override
    public void validate(Object... data) {
        IdentificationTypeExistByIdRule.executeRule(data);
    }
}
