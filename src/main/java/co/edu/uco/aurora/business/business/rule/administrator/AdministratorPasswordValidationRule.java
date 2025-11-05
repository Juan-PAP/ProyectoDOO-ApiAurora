package co.edu.uco.aurora.business.business.rule.administrator;
//seria como para registro
import co.edu.uco.aurora.business.business.rule.Rule;
import co.edu.uco.aurora.crosscuting.exception.AuroraException;
import co.edu.uco.aurora.crosscuting.helper.ObjectHelper;
import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.messagescatalog.business.rule.administrator.MessagesEnumAdministratorRule;

public final class AdministratorPasswordValidationRule implements Rule {

    private static final Rule instance = new AdministratorPasswordValidationRule();
    private static final String PASSWORD_REGEX = "^[a-zA-Z0-9]{8,12}$";

    private AdministratorPasswordValidationRule() {
        super();
    }

    public static void executeRule(final Object... data) {
        instance.execute(data);
    }

    @Override
    public void execute(Object... data) {
        if (ObjectHelper.isNull(data) || data.length < 1) {
            var userMessage = MessagesEnumAdministratorRule.ADMIN_PASSWORD_VALIDATION_RULE_DATA_IS_NULL_OR_INVALID_LENGTH.getTitle();
            var technicalMessage = MessagesEnumAdministratorRule.ADMIN_PASSWORD_VALIDATION_RULE_DATA_IS_NULL_OR_INVALID_LENGTH.getContent();
            throw AuroraException.create(userMessage, technicalMessage);
        }

        var password = (String) data[0];

        if (ObjectHelper.isNull(password) || !password.matches(PASSWORD_REGEX)) {
            var userMessage = MessagesEnumAdministratorRule.ADMIN_PASSWORD_VALIDATION_RULE_FORMAT_INVALID.getTitle();
            var technicalMessage = MessagesEnumAdministratorRule.ADMIN_PASSWORD_VALIDATION_RULE_FORMAT_INVALID.getContent();
            throw AuroraException.create(userMessage, technicalMessage);
        }
    }
}