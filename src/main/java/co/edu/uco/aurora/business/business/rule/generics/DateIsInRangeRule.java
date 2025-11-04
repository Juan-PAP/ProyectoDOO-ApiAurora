package co.edu.uco.aurora.business.business.rule.generics;

import co.edu.uco.aurora.business.business.rule.Rule;
import co.edu.uco.aurora.crosscuting.exception.AuroraException;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.messagescatalog.business.rule.generics.MessagesEnumGenericRule;

import java.time.LocalDate;

public final class DateIsInRangeRule implements Rule {

    private static final Rule instance = new DateIsInRangeRule();

    private DateIsInRangeRule() {
        super();
    }

    public static void executeRule(final Object... data) {
        instance.execute(data);
    }

    @Override
    public void execute(Object... data) {

        if (ObjectHelper.isNull(data)) {
            var userMessage = MessagesEnumGenericRule.DATE_IS_IN_RANGE_RULE_DATA_IS_NULL.getTitle();
            var technicalMessage = MessagesEnumGenericRule.DATE_IS_IN_RANGE_RULE_DATA_IS_NULL.getContent();
            throw AuroraException.create(userMessage, technicalMessage);
        }
        if (data.length < 4) {
            var userMessage = MessagesEnumGenericRule.DATE_IS_IN_RANGE_RULE_DATA_LENGTH_INVALID.getTitle();
            var technicalMessage = MessagesEnumGenericRule.DATE_IS_IN_RANGE_RULE_DATA_LENGTH_INVALID.getContent();
            throw AuroraException.create(userMessage, technicalMessage);
        }

        var dateToValidate = (LocalDate) data[0];
        var dataName = (String) data[1];
        var minDate = (LocalDate) data[2];
        var maxDate = (LocalDate) data[3];

        if (ObjectHelper.isNull(dateToValidate)) {
            var userMessage = TextHelper.format(
                    MessagesEnumGenericRule.DATE_IS_IN_RANGE_RULE_DATE_IS_NULL.getTitle(), dataName);
            var technicalMessage = TextHelper.format(
                    MessagesEnumGenericRule.DATE_IS_IN_RANGE_RULE_DATE_IS_NULL.getContent(), dataName);
            throw AuroraException.create(userMessage, technicalMessage);
        }

        if (dateToValidate.isBefore(minDate) || dateToValidate.isAfter(maxDate)) {
            var userMessage = TextHelper.format(
                    MessagesEnumGenericRule.DATE_IS_IN_RANGE_RULE_DATE_OUT_OF_RANGE.getTitle(),
                    dataName, minDate.toString(), maxDate.toString());
            var technicalMessage = TextHelper.format(
                    MessagesEnumGenericRule.DATE_IS_IN_RANGE_RULE_DATE_OUT_OF_RANGE.getContent(),
                    dataName, minDate.toString(), maxDate.toString());
            throw AuroraException.create(userMessage, technicalMessage);
        }
    }
}