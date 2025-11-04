package co.edu.uco.aurora.business.business.rule.customer;

import co.edu.uco.aurora.business.business.rule.Rule;
import co.edu.uco.aurora.crosscuting.exception.AuroraException;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;
import co.edu.uco.aurora.data.dao.factory.DAOFactory;
import co.edu.uco.aurora.entity.CustomerEntity;

import co.edu.uco.aurora.crosscuting.messagescatalog.business.rule.customer.MessagesEnumCustomerRule;

import java.util.List;

public final class CustomerIdentificationNumberDoesNotExistRule implements Rule {

    private static final Rule instance = new CustomerIdentificationNumberDoesNotExistRule();

    private CustomerIdentificationNumberDoesNotExistRule() {
        super();
    }

    public static void executeRule(final Object... data) {
        instance.execute(data);
    }

    @Override
    public void execute(Object... data) {

        if (ObjectHelper.isNull(data)){
            var userMessage = MessagesEnumCustomerRule.CUSTOMER_ID_NUMBER_DOES_NOT_EXIST_RULE_DATA_IS_NULL.getTitle();
            var technicalMessage = MessagesEnumCustomerRule.CUSTOMER_ID_NUMBER_DOES_NOT_EXIST_RULE_DATA_IS_NULL.getContent();
            throw AuroraException.create(userMessage, technicalMessage);
        }
        if (data.length < 2){
            var userMessage = MessagesEnumCustomerRule.CUSTOMER_ID_NUMBER_DOES_NOT_EXIST_RULE_DATA_LENGTH_INVALID.getTitle();
            var technicalMessage = MessagesEnumCustomerRule.CUSTOMER_ID_NUMBER_DOES_NOT_EXIST_RULE_DATA_LENGTH_INVALID.getContent();
            throw AuroraException.create(userMessage, technicalMessage);
        }

        var idNumber = (String) data[0];
        var daoFactory = (DAOFactory) data[1];

        var customerFilter = new CustomerEntity();
        customerFilter.setIdentificationNumber(idNumber);

        List<CustomerEntity> results = daoFactory.getCustomerDAO().findByFilter(customerFilter);

        var customer = results.stream()
                .findFirst()
                .orElse(new CustomerEntity());

        if (!UUIDHelper.getUUIDHelper().isDefaultUUID(customer.getId())) {

            var userMessage = MessagesEnumCustomerRule.CUSTOMER_ID_NUMBER_DOES_NOT_EXIST_RULE_CUSTOMER_ALREADY_EXISTS.getTitle();
            var technicalMessage = TextHelper.format(
                    MessagesEnumCustomerRule.CUSTOMER_ID_NUMBER_DOES_NOT_EXIST_RULE_CUSTOMER_ALREADY_EXISTS.getContent(),
                    idNumber
            );
            throw AuroraException.create(userMessage,technicalMessage);
        }
    }
}