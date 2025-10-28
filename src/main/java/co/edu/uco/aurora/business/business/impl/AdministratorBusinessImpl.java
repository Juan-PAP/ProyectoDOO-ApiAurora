package co.edu.uco.aurora.business.business.impl;

import co.edu.uco.aurora.business.business.AdministratorBusiness;
import co.edu.uco.aurora.business.domain.AdministratorDomain;
import co.edu.uco.aurora.crosscuting.exception.AuroraException;
import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.messagescatalog.messagesenubusiness.MessagesEnumAdministratorBusiness;
import co.edu.uco.aurora.data.dao.entity.AdministratorDAO;
import co.edu.uco.aurora.data.dao.factory.DAOFactory;
import co.edu.uco.aurora.entity.AdministratorEntity;

import java.util.List;
import java.util.UUID;

public class AdministratorBusinessImpl implements AdministratorBusiness {

    private final DAOFactory factory;

    public AdministratorBusinessImpl(final DAOFactory factory) {
        // Idealmente, validar que factory no sea null
        this.factory = factory;
    }

    @Override
    public void registerNewAdministrator(AdministratorDomain administrator) {

    }

    @Override
    public void updateAdministratorInformation(UUID id, AdministratorDomain administrator) {

    }

    @Override
    public void login(AdministratorDomain administrator) {

        try {
            validateLoginCredentials(administrator);

            final AdministratorDAO administratorDAO = factory.getAdministratorDAO();

            final List<AdministratorEntity> entities = administratorDAO.findByUsername(administrator.getUser());

            if (entities.isEmpty()) {
                var userMessage = MessagesEnumAdministratorBusiness.USER_ERROR_INVALID_CREDENTIALS.getContent();

                throw AuroraException.create(userMessage, userMessage);
            }

            final AdministratorEntity storedEntity = entities.get(0);

            if (!administrator.getPassword().equals(storedEntity.getPassword())) {
                var userMessage = MessagesEnumAdministratorBusiness.USER_ERROR_INVALID_CREDENTIALS.getContent();
                throw AuroraException.create(userMessage, userMessage);
            }

        } catch (final AuroraException exception) {
            throw exception;

        } catch (final Exception exception) {
            var userMessage = MessagesEnumAdministratorBusiness.USER_ERROR_UNEXPECTED_LOGIN_ERROR.getContent();
            var technicalMessage = MessagesEnumAdministratorBusiness.TECHNICAL_ERROR_UNEXPECTED_LOGIN_ERROR.getContent() + ": " + exception.getMessage();
            throw AuroraException.create(exception, userMessage, technicalMessage);

        }
    }

    private void validateLoginCredentials(AdministratorDomain administrator) {
        if (TextHelper.isEmptyWithTrim(administrator.getUser()) ||
                TextHelper.isEmptyWithTrim(administrator.getPassword())) {

            var userMessage = MessagesEnumAdministratorBusiness.USER_ERROR_EMPTY_CREDENTIALS.getContent();
            throw AuroraException.create(userMessage, userMessage);
        }

    }

    @Override
    public List<AdministratorDomain> getAdministratorByFilter(AdministratorDomain administrator) {
        return List.of();
    }

    @Override
    public List<AdministratorDomain> getAllAdministrator() {
        return List.of();
    }
}
