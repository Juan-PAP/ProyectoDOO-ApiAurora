package co.edu.uco.aurora.business.business.rule.customer;

import co.edu.uco.aurora.business.business.rule.Rule;
import co.edu.uco.aurora.business.domain.IdentificationTypeDomain;
import co.edu.uco.aurora.crosscuting.exception.AuroraException;
import co.edu.uco.aurora.crosscuting.helper.LocalDateHelper;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;
import co.edu.uco.aurora.crosscuting.messagescatalog.business.rule.customer.MessagesEnumCustomerRule;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

public final class CustomerAgeIsConsistentWithIdTypeRule implements Rule {

    private static final UUID TARJETA_IDENTIDAD_ID = UUID.fromString("a1a1a1a1-0001-0001-0001-000000000001");
    private static final UUID CEDULA_CIUDADANIA_ID = UUID.fromString("a1a1a1a1-0001-0001-0001-000000000002");

    private static final Rule instance = new CustomerAgeIsConsistentWithIdTypeRule();

    private CustomerAgeIsConsistentWithIdTypeRule() {

    }


    public static void executeRule(final Object... data) {
        instance.execute(data);
    }


    @Override
    public void execute(Object... data) {
        if (ObjectHelper.isNull(data)) {
            var userMessage = MessagesEnumCustomerRule.CUSTOMER_AGE_CONSISTENCY_RULE_DATA_IS_NULL.getTitle();
            var technicalMessage = MessagesEnumCustomerRule.CUSTOMER_AGE_CONSISTENCY_RULE_DATA_IS_NULL.getContent();
            throw AuroraException.create(userMessage, technicalMessage);
        }
        if (data.length < 2) {
            var userMessage = MessagesEnumCustomerRule.CUSTOMER_AGE_CONSISTENCY_RULE_DATA_LENGTH_INVALID.getTitle();
            var technicalMessage = MessagesEnumCustomerRule.CUSTOMER_AGE_CONSISTENCY_RULE_DATA_LENGTH_INVALID.getContent();
            throw AuroraException.create(userMessage, technicalMessage);
        }

        var birthDate = (LocalDate) data[0];
        var idType = (IdentificationTypeDomain) data[1];

        if (ObjectHelper.isNull(birthDate)) {
            var userMessage = MessagesEnumCustomerRule.CUSTOMER_AGE_CONSISTENCY_RULE_BIRTHDATE_IS_NULL.getTitle();
            var technicalMessage = MessagesEnumCustomerRule.CUSTOMER_AGE_CONSISTENCY_RULE_BIRTHDATE_IS_NULL.getContent();
            throw AuroraException.create(userMessage, technicalMessage);
        }

        if (ObjectHelper.isNull(idType) || ObjectHelper.isNull(idType.getId()) || UUIDHelper.getUUIDHelper().isDefaultUUID(idType.getId())) {
            var userMessage = MessagesEnumCustomerRule.CUSTOMER_AGE_CONSISTENCY_RULE_IDTYPE_IS_NULL.getTitle();
            var technicalMessage = MessagesEnumCustomerRule.CUSTOMER_AGE_CONSISTENCY_RULE_IDTYPE_IS_NULL.getContent();
            throw AuroraException.create(userMessage, technicalMessage);
        }

        int age = Period.between(birthDate, LocalDateHelper.getDateToday()).getYears();
        UUID idTypeUuid = idType.getId();
        String ageStr = String.valueOf(age);

        if (TARJETA_IDENTIDAD_ID.equals(idTypeUuid) && (age < 7 || age >= 18)) {
            var userMessage = TextHelper.format(
                    MessagesEnumCustomerRule.CUSTOMER_AGE_CONSISTENCY_RULE_TI_AGE_INVALID.getTitle(), ageStr);
            var technicalMessage = TextHelper.format(
                    MessagesEnumCustomerRule.CUSTOMER_AGE_CONSISTENCY_RULE_TI_AGE_INVALID.getContent(), ageStr, "Tarjeta de Identidad");
            throw AuroraException.create(userMessage, technicalMessage);
        }

        if (CEDULA_CIUDADANIA_ID.equals(idTypeUuid) && age < 18) {
            var userMessage = TextHelper.format(
                    MessagesEnumCustomerRule.CUSTOMER_AGE_CONSISTENCY_RULE_CC_AGE_INVALID.getTitle(), ageStr);
            var technicalMessage = TextHelper.format(
                    MessagesEnumCustomerRule.CUSTOMER_AGE_CONSISTENCY_RULE_CC_AGE_INVALID.getContent(), ageStr, "Cedula de Ciudadania");
            throw AuroraException.create(userMessage, technicalMessage);
        }
    }
}