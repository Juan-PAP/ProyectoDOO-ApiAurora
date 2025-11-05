package co.edu.uco.aurora.business.business.rule.validator.administrator;
//login
import co.edu.uco.aurora.business.business.rule.administrator.AdministratorPasswordMatchesRule;
import co.edu.uco.aurora.business.business.rule.administrator.AdministratorPasswordValidationRule;
import co.edu.uco.aurora.business.business.rule.administrator.AdministratorUsernameExistsRule;
import co.edu.uco.aurora.business.business.rule.administrator.AdministratorUsernameValidationRule;
import co.edu.uco.aurora.business.business.rule.validator.Validator;
import co.edu.uco.aurora.data.dao.factory.DAOFactory;
import co.edu.uco.aurora.entity.AdministratorEntity;

public final class ValidateAdministratorLogin implements Validator {

    private static final Validator instance = new ValidateAdministratorLogin();

    private ValidateAdministratorLogin() {
        super();
    }

    public static void executeValidation(final Object... data) {
        instance.validate(data);
    }

    @Override
    public void validate(final Object... data) {
        var entity = (AdministratorEntity) data[0];
        var daoFactory = (DAOFactory) data[1];

        // 1. Validar formato de datos de entrada
        AdministratorUsernameValidationRule.executeRule(entity.getUser());
        AdministratorPasswordValidationRule.executeRule(entity.getPassword());

        // 2. Validar que el usuario exista
        AdministratorUsernameExistsRule.executeRule(entity.getUser(), daoFactory);

        // 3. Validar que la contraseña coincida
        AdministratorPasswordMatchesRule.executeRule(entity.getUser(), entity.getPassword(), daoFactory);
    }
}