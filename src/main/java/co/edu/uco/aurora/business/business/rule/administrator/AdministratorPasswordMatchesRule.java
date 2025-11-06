package co.edu.uco.aurora.business.business.rule.administrator;

import co.edu.uco.aurora.business.business.rule.Rule;
import co.edu.uco.aurora.crosscuting.exception.AuroraException;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.messagescatalog.business.rule.administrator.MessagesEnumAdministratorRule;
import co.edu.uco.aurora.data.dao.factory.DAOFactory;

public final class AdministratorPasswordMatchesRule implements Rule {

    private static final Rule instance = new AdministratorPasswordMatchesRule();

    private AdministratorPasswordMatchesRule() {

    }

    public static void executeRule(final Object... data) {
        instance.execute(data);
    }

    @Override
    public void execute(Object... data) {
        if (ObjectHelper.isNull(data)) {
            var userMessage = MessagesEnumAdministratorRule.ADMIN_PASSWORD_MATCHES_RULE_DATA_IS_NULL.getTitle();
            var technicalMessage = MessagesEnumAdministratorRule.ADMIN_PASSWORD_MATCHES_RULE_DATA_IS_NULL.getContent();
            throw AuroraException.create(userMessage, technicalMessage);
        }

        if (data.length < 3) {
            var userMessage = MessagesEnumAdministratorRule.ADMIN_PASSWORD_MATCHES_RULE_DATA_LENGTH_INVALID.getTitle();
            var technicalMessage = MessagesEnumAdministratorRule.ADMIN_PASSWORD_MATCHES_RULE_DATA_LENGTH_INVALID.getContent();
            throw AuroraException.create(userMessage, technicalMessage);
        }

        var username = (String) data[0];
        var password = (String) data[1];
        var daoFactory = (DAOFactory) data[2];

        var results = daoFactory.getAdministratorDAO().findByUsername(username);

        if (!results.isEmpty()) {

            var storedPassword = results.get(0).getPassword();

            if (!password.equals(storedPassword)) {
                var userMessage = MessagesEnumAdministratorRule.ADMIN_PASSWORD_MATCHES_RULE_PASSWORD_DOES_NOT_MATCH.getTitle();
                var technicalMessage = TextHelper.format(
                        MessagesEnumAdministratorRule.ADMIN_PASSWORD_MATCHES_RULE_PASSWORD_DOES_NOT_MATCH.getContent(),
                        username
                );
                throw AuroraException.create(userMessage, technicalMessage);
            }
        }
    }
}