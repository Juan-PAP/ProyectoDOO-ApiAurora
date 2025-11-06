package co.edu.uco.aurora.business.business.rule.validator.administrator;

import co.edu.uco.aurora.business.business.rule.administrator.AdministratorPasswordMatchesRule;
import co.edu.uco.aurora.business.business.rule.administrator.AdministratorPasswordValidationRule;
import co.edu.uco.aurora.business.business.rule.administrator.AdministratorUsernameExistsRule;
import co.edu.uco.aurora.business.business.rule.administrator.AdministratorUsernameValidationRule;
import co.edu.uco.aurora.business.business.rule.validator.Validator;
import co.edu.uco.aurora.data.dao.factory.DAOFactory;
import co.edu.uco.aurora.business.domain.AdministratorDomain;

public final class ValidateAdministratorLogin implements Validator {

    private static final Validator instance = new ValidateAdministratorLogin();

    private ValidateAdministratorLogin() {

    }

    public static void executeValidation(final Object... data) {
        instance.validate(data);
    }

    @Override
    public void validate(final Object... data) {

        var domain = (AdministratorDomain) data[0];
        var daoFactory = (DAOFactory) data[1];

        AdministratorUsernameValidationRule.executeRule(domain.getUser());
        AdministratorPasswordValidationRule.executeRule(domain.getPassword());

        AdministratorUsernameExistsRule.executeRule(domain.getUser(), daoFactory);

        AdministratorPasswordMatchesRule.executeRule(domain.getUser(), domain.getPassword(), daoFactory);
    }
}