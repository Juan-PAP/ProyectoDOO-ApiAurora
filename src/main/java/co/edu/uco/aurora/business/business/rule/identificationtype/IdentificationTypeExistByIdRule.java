package co.edu.uco.aurora.business.business.rule.identificationtype;

import co.edu.uco.aurora.business.business.rule.Rule;
import co.edu.uco.aurora.crosscuting.exception.AuroraException;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;
import co.edu.uco.aurora.data.dao.factory.DAOFactory;
import co.edu.uco.aurora.crosscuting.messagescatalog.business.rule.identificationtype.MessagesEnumIdentificationTypeRule;

import java.util.UUID;

public final class IdentificationTypeExistByIdRule implements Rule {

    private static final Rule instance = new IdentificationTypeExistByIdRule();

    private IdentificationTypeExistByIdRule() {

    }

    public static void executeRule(final Object... data) {
        instance.execute(data);
    }

    @Override
    public void execute(Object... data) {

        if (ObjectHelper.isNull(data)){
            var userMessage = MessagesEnumIdentificationTypeRule.ID_TYPE_EXISTS_BY_ID_RULE_DATA_IS_NULL.getTitle();
            var technicalMessage = MessagesEnumIdentificationTypeRule.ID_TYPE_EXISTS_BY_ID_RULE_DATA_IS_NULL.getContent();
            throw AuroraException.create(userMessage, technicalMessage);
        }
        if (data.length < 2){
            var userMessage = MessagesEnumIdentificationTypeRule.ID_TYPE_EXISTS_BY_ID_RULE_DATA_LENGTH_INVALID.getTitle();
            var technicalMessage = MessagesEnumIdentificationTypeRule.ID_TYPE_EXISTS_BY_ID_RULE_DATA_LENGTH_INVALID.getContent();
            throw AuroraException.create(userMessage, technicalMessage);
        }

        var id = (UUID) data[0];
        var daoFactory = (DAOFactory) data[1];

        var identificationType = daoFactory.getIdentificationTypeDAO().findById(id);

        if (ObjectHelper.isNull(identificationType) || UUIDHelper.getUUIDHelper().isDefaultUUID(identificationType.getId())) {

            var userMessage = MessagesEnumIdentificationTypeRule.ID_TYPE_EXISTS_BY_ID_RULE_ID_TYPE_NOT_FOUND.getTitle();
            var technicalMessage = TextHelper.format(
                    MessagesEnumIdentificationTypeRule.ID_TYPE_EXISTS_BY_ID_RULE_ID_TYPE_NOT_FOUND.getContent(),
                    id.toString()
            );
            throw AuroraException.create(userMessage,technicalMessage);
        }
    }
}