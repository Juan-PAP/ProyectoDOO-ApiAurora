package co.edu.uco.aurora.business.business.rule.customer;

import co.edu.uco.aurora.business.business.rule.Rule;
import co.edu.uco.aurora.business.domain.IdentificationTypeDomain;
import co.edu.uco.aurora.crosscuting.exception.AuroraException;
import co.edu.uco.aurora.crosscuting.helper.LocalDateHelper;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;
import co.edu.uco.aurora.crosscuting.messagescatalog.business.rule.customer.MessagesEnumCustomerRule;
import co.edu.uco.aurora.data.dao.factory.DAOFactory;

import java.time.LocalDate;
import java.time.Period;

public final class CustomerAgeIsConsistentWithIdTypeRule implements Rule {

    private static final String TARJETA_IDENTIDAD_NAME = "Tarjeta de Identidad";
    private static final String CEDULA_CIUDADANIA_NAME = "Cedula de Ciudadania";

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
        if (data.length < 3) {
            var userMessage = MessagesEnumCustomerRule.CUSTOMER_AGE_CONSISTENCY_RULE_DATA_LENGTH_INVALID.getTitle();
            var technicalMessage = MessagesEnumCustomerRule.CUSTOMER_AGE_CONSISTENCY_RULE_DATA_LENGTH_INVALID.getContent();
            throw AuroraException.create(userMessage, technicalMessage);
        }

        var birthDate = (LocalDate) data[0];
        var idType = (IdentificationTypeDomain) data[1];
        var daoFactory = (DAOFactory) data[2];

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

        if (ObjectHelper.isNull(daoFactory)) {
            var userMessage = MessagesEnumCustomerRule.CUSTOMER_AGE_CONSISTENCY_RULE_DAOFACTORY_IS_NULL.getTitle();
            var technicalMessage = MessagesEnumCustomerRule.CUSTOMER_AGE_CONSISTENCY_RULE_DAOFACTORY_IS_NULL.getContent();
            throw AuroraException.create(userMessage, technicalMessage);
        }

        int age = Period.between(birthDate, LocalDateHelper.getDateToday()).getYears();
        String ageStr = String.valueOf(age);

        var idTypeEntity = daoFactory.getIdentificationTypeDAO().findById(idType.getId());

        if (UUIDHelper.getUUIDHelper().isDefaultUUID(idTypeEntity.getId())) {
            var userMessage = MessagesEnumCustomerRule.CUSTOMER_AGE_CONSISTENCY_RULE_IDTYPE_NOT_FOUND_IN_DAO.getTitle();
            var technicalMessage = TextHelper.format(
                    MessagesEnumCustomerRule.CUSTOMER_AGE_CONSISTENCY_RULE_IDTYPE_NOT_FOUND_IN_DAO.getContent(),
                    idType.getId().toString()
            );
            throw AuroraException.create(userMessage, technicalMessage);
        }

        String idTypeName = idTypeEntity.getName();

        if (TARJETA_IDENTIDAD_NAME.equalsIgnoreCase(idTypeName) && (age < 7 || age >= 18)) {
            var userMessage = TextHelper.format(
                    MessagesEnumCustomerRule.CUSTOMER_AGE_CONSISTENCY_RULE_TI_AGE_INVALID.getTitle(), ageStr);
            var technicalMessage = TextHelper.format(
                    MessagesEnumCustomerRule.CUSTOMER_AGE_CONSISTENCY_RULE_TI_AGE_INVALID.getContent(), ageStr, idTypeName);
            throw AuroraException.create(userMessage, technicalMessage);
        }

        if (CEDULA_CIUDADANIA_NAME.equalsIgnoreCase(idTypeName) && age < 18) {
            var userMessage = TextHelper.format(
                    MessagesEnumCustomerRule.CUSTOMER_AGE_CONSISTENCY_RULE_CC_AGE_INVALID.getTitle(), ageStr);
            var technicalMessage = TextHelper.format(
                    MessagesEnumCustomerRule.CUSTOMER_AGE_CONSISTENCY_RULE_CC_AGE_INVALID.getContent(), ageStr, idTypeName);
            throw AuroraException.create(userMessage, technicalMessage);
        }
    }
}