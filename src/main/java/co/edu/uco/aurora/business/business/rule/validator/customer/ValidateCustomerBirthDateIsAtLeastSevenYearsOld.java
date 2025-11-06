
package co.edu.uco.aurora.business.business.rule.validator.customer;

import co.edu.uco.aurora.business.business.rule.customer.CustomerBirthDateIsAtLeastSevenYearsOldRule;
import co.edu.uco.aurora.business.business.rule.validator.Validator;
import co.edu.uco.aurora.business.domain.CustomerDomain;

public final class ValidateCustomerBirthDateIsAtLeastSevenYearsOld implements Validator {

    private static final Validator instance = new ValidateCustomerBirthDateIsAtLeastSevenYearsOld();

    private ValidateCustomerBirthDateIsAtLeastSevenYearsOld() { }

    public static void executeValidation(final Object... data) {
        instance.validate(data);
    }

    @Override
    public void validate(final Object... data) {
        var customer = (CustomerDomain) data[0];
        CustomerBirthDateIsAtLeastSevenYearsOldRule.executeRule(customer.getBirthDate());
    }
}