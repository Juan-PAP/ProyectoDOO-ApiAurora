package co.edu.uco.aurora.business.business.rule.administrator;
//seria como para registro

import co.edu.uco.aurora.business.business.rule.Rule;
import co.edu.uco.aurora.crosscuting.exception.AuroraException;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.messagescatalog.business.rule.administrator.MessagesEnumAdministratorRule;

public final class AdministratorUsernameValidationRule implements Rule {

    private static final Rule instance = new AdministratorUsernameValidationRule();
    private static final String USERNAME_REGEX = "^[a-zA-Z0-9]{4,20}$";

    private AdministratorUsernameValidationRule() {
        super();
    }

    public static void executeRule(final Object... data) {
        instance.execute(data);
    }

    @Override
    public void execute(Object... data) {
        if (ObjectHelper.isNull(data) || data.length < 1) {
            var userMessage = MessagesEnumAdministratorRule.ADMIN_USERNAME_VALIDATION_RULE_DATA_IS_NULL_OR_INVALID_LENGTH.getTitle();
            var technicalMessage = MessagesEnumAdministratorRule.ADMIN_USERNAME_VALIDATION_RULE_DATA_IS_NULL_OR_INVALID_LENGTH.getContent();
            throw AuroraException.create(userMessage, technicalMessage);
        }

        var username = (String) data[0];

        if (ObjectHelper.isNull(username) || !username.matches(USERNAME_REGEX)) {
            var userMessage = MessagesEnumAdministratorRule.ADMIN_USERNAME_VALIDATION_RULE_FORMAT_INVALID.getTitle();
            var technicalMessage = TextHelper.format(
                    MessagesEnumAdministratorRule.ADMIN_USERNAME_VALIDATION_RULE_FORMAT_INVALID.getContent(),
                    username == null ? "null" : username
            );
            throw AuroraException.create(userMessage, technicalMessage);
        }
    }
}