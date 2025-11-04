package co.edu.uco.aurora.business.business.rule.validator.customer;

import co.edu.uco.aurora.business.business.rule.customer.CustomerIdentificationNumberDoesNotExistRule;
import co.edu.uco.aurora.business.business.rule.validator.Validator;

public final class ValidateCustomerIdentificationNumberDoesNotExist implements Validator {

    private static final Validator instance = new ValidateCustomerIdentificationNumberDoesNotExist();

    private ValidateCustomerIdentificationNumberDoesNotExist() {

    }

    public static void executeValidation(final Object... data) {
        instance.validate(data);
    }

    @Override
    public void validate(Object... data) {
        CustomerIdentificationNumberDoesNotExistRule.executeRule(data);
    }
}
