package co.edu.uco.aurora.business.business.rule.validator.administrator;

import co.edu.uco.aurora.business.business.rule.administrator.AdministratorPasswordMatchesRule;
import co.edu.uco.aurora.business.business.rule.administrator.AdministratorUsernameExistsRule;
import co.edu.uco.aurora.business.business.rule.validator.Validator;
import co.edu.uco.aurora.business.domain.AdministratorDomain;
import co.edu.uco.aurora.data.dao.factory.DAOFactory;

public final class ValidateAdministratorLogin implements Validator {

    private static final Validator instance = new ValidateAdministratorLogin();

    private ValidateAdministratorLogin() { }

    public static void executeValidation(final Object... data) {
        instance.validate(data);
    }

    @Override
    public void validate(final Object... data) {
        final var domain = (AdministratorDomain) data[0];
        final var daoFactory = (DAOFactory) data[1];

        ValidateDataAdministradorConsistencyForLogin.executeValidation(domain);

        AdministratorUsernameExistsRule.executeRule(domain.getUser(), daoFactory);
        AdministratorPasswordMatchesRule.executeRule(domain.getUser(), domain.getPassword(), daoFactory);
    }
}