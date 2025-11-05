package co.edu.uco.aurora.business.business.rule.administrator;
//login
import co.edu.uco.aurora.business.business.rule.Rule;
import co.edu.uco.aurora.crosscuting.exception.AuroraException;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.messagescatalog.business.rule.administrator.MessagesEnumAdministratorRule;
import co.edu.uco.aurora.data.dao.factory.DAOFactory;
import co.edu.uco.aurora.entity.AdministratorEntity;

public final class AdministratorUsernameExistsRule implements Rule {

    private static final Rule instance = new AdministratorUsernameExistsRule();

    private AdministratorUsernameExistsRule() {
        super();
    }

    @Override
    public void execute(Object... data) {
        if (ObjectHelper.isNull(data)) {
            var userMessage = MessagesEnumAdministratorRule.ADMIN_USERNAME_EXISTS_RULE_DATA_IS_NULL.getTitle();
            var technicalMessage = MessagesEnumAdministratorRule.ADMIN_USERNAME_EXISTS_RULE_DATA_IS_NULL.getContent();
            throw AuroraException.create(userMessage, technicalMessage);
        }

        if (data.length < 2) {
            var userMessage = MessagesEnumAdministratorRule.ADMIN_USERNAME_EXISTS_RULE_DATA_LENGTH_INVALID.getTitle();
            var technicalMessage = MessagesEnumAdministratorRule.ADMIN_USERNAME_EXISTS_RULE_DATA_LENGTH_INVALID.getContent();
            throw AuroraException.create(userMessage, technicalMessage);
        }

        var username = (String) data[0];
        var daoFactory = (DAOFactory) data[1];

        var results = daoFactory.getAdministratorDAO().findByFilter(adminFilter);

        if (results.isEmpty()) {
            var userMessage = MessagesEnumAdministratorRule.ADMIN_USERNAME_EXISTS_RULE_USERNAME_DOES_NOT_EXIST.getTitle();
            var technicalMessage = TextHelper.format(
                    MessagesEnumAdministratorRule.ADMIN_USERNAME_EXISTS_RULE_USERNAME_DOES_NOT_EXIST.getContent(),
                    username
            );
            throw AuroraException.create(userMessage, technicalMessage);
        }
    }
}