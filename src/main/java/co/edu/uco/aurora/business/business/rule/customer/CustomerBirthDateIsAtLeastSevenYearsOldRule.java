package co.edu.uco.aurora.business.business.rule.customer;

import co.edu.uco.aurora.business.business.rule.Rule;
import co.edu.uco.aurora.crosscuting.exception.AuroraException;
import co.edu.uco.aurora.crosscuting.helper.LocalDateHelper;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.messagescatalog.business.rule.customer.MessagesEnumCustomerRule;

import java.time.LocalDate;
import java.time.Period;

public final class CustomerBirthDateIsAtLeastSevenYearsOldRule implements Rule {

    private static final Rule instance = new CustomerBirthDateIsAtLeastSevenYearsOldRule();

    private CustomerBirthDateIsAtLeastSevenYearsOldRule() { }

    public static void executeRule(final Object... data) {
        instance.execute(data);
    }

    @Override
    public void execute(final Object... data) {
        if (ObjectHelper.isNull(data)) {
            var userMessage = MessagesEnumCustomerRule.CUSTOMER_BIRTHDATE_MIN_AGE_RULE_DATA_IS_NULL.getTitle();
            var technicalMessage = MessagesEnumCustomerRule.CUSTOMER_BIRTHDATE_MIN_AGE_RULE_DATA_IS_NULL.getContent();
            throw AuroraException.create(userMessage, technicalMessage);
        }
        if (data.length < 1) {
            var userMessage = MessagesEnumCustomerRule.CUSTOMER_BIRTHDATE_MIN_AGE_RULE_DATA_LENGTH_INVALID.getTitle();
            var technicalMessage = MessagesEnumCustomerRule.CUSTOMER_BIRTHDATE_MIN_AGE_RULE_DATA_LENGTH_INVALID.getContent();
            throw AuroraException.create(userMessage, technicalMessage);
        }

        var birthDate = (LocalDate) data[0];
        if (ObjectHelper.isNull(birthDate)) {
            var userMessage = MessagesEnumCustomerRule.CUSTOMER_BIRTHDATE_MIN_AGE_RULE_BIRTHDATE_IS_NULL.getTitle();
            var technicalMessage = MessagesEnumCustomerRule.CUSTOMER_BIRTHDATE_MIN_AGE_RULE_BIRTHDATE_IS_NULL.getContent();
            throw AuroraException.create(userMessage, technicalMessage);
        }

        var today = LocalDateHelper.getDateToday();
        int age = Period.between(birthDate, today).getYears();

        if (age < 7) {
            var ageStr = String.valueOf(age);
            var userMessage = TextHelper.format(
                    MessagesEnumCustomerRule.CUSTOMER_BIRTHDATE_MIN_AGE_RULE_AGE_INVALID.getTitle(), ageStr);
            var technicalMessage = TextHelper.format(
                    MessagesEnumCustomerRule.CUSTOMER_BIRTHDATE_MIN_AGE_RULE_AGE_INVALID.getContent(), ageStr);
            throw AuroraException.create(userMessage, technicalMessage);
        }
    }
}