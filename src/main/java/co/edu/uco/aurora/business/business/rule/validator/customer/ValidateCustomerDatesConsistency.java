package co.edu.uco.aurora.business.business.rule.validator.customer;

import co.edu.uco.aurora.business.business.rule.generics.DateIsInRangeRule;
import co.edu.uco.aurora.business.business.rule.customer.CustomerAgeIsConsistentWithIdTypeRule;
import co.edu.uco.aurora.business.business.rule.validator.Validator;
import co.edu.uco.aurora.business.domain.CustomerDomain;
import co.edu.uco.aurora.crosscuting.helper.LocalDateHelper;

import java.time.LocalDate;

public final class ValidateCustomerDatesConsistency implements Validator {

    private static final Validator instance = new ValidateCustomerDatesConsistency();

    private ValidateCustomerDatesConsistency() {

    }

    public static void executeValidation(final Object... data) {
        instance.validate(data);
    }

    @Override
    public void validate(final Object... data) {
        var customerDomainData = (CustomerDomain) data[0];

        LocalDate minDate = LocalDateHelper.getDefault();
        LocalDate maxDate = LocalDateHelper.getDateToday().minusYears(7);

        DateIsInRangeRule.executeRule(customerDomainData.getBirthDate(), "Fecha de Nacimiento", minDate, maxDate);

        CustomerAgeIsConsistentWithIdTypeRule.executeRule(customerDomainData.getBirthDate(), customerDomainData.getIdentificationType());
    }
}