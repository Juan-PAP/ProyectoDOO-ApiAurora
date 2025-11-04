package co.edu.uco.aurora.business.business.rule.validator.customer;

import co.edu.uco.aurora.business.business.rule.customer.CustomerPhoneNumberDoesNotExistRule;
import co.edu.uco.aurora.business.business.rule.validator.Validator;

public final class ValidateCustomerPhoneNumberDoesNotExist implements Validator {

    private static final Validator instance = new ValidateCustomerPhoneNumberDoesNotExist();

    private ValidateCustomerPhoneNumberDoesNotExist() {

    }

    public static void executeValidation(final Object... data) {
        instance.validate(data);
    }

    @Override
    public void validate(Object... data) {
        CustomerPhoneNumberDoesNotExistRule.executeRule(data);
    }
}
