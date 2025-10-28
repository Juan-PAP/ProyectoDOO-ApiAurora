package co.edu.uco.aurora.business.facade.impl;

import co.edu.uco.aurora.business.assembler.dto.impl.AdministratorDTOAssembler;
import co.edu.uco.aurora.business.business.AdministratorBusiness;
import co.edu.uco.aurora.business.business.impl.AdministratorBusinessImpl;
import co.edu.uco.aurora.business.domain.AdministratorDomain;
import co.edu.uco.aurora.business.facade.AdministratorFacade;
import co.edu.uco.aurora.crosscuting.exception.AuroraException;
import co.edu.uco.aurora.crosscuting.messagescatalog.messagesenumfacade.MessagesEnumFacade;
import co.edu.uco.aurora.data.dao.factory.DAOFactory;
import co.edu.uco.aurora.dto.AdministratorDTO;

import java.util.List;
import java.util.UUID;

public final class AdministratorFacadeImpl implements AdministratorFacade {


    @Override
    public void registerNewAdministrator(AdministratorDTO administrator) {

    }

    @Override
    public void updateAdministratorInformation(UUID id, AdministratorDTO administrator) {

    }

    @Override
    public void login(AdministratorDTO administrator) {

        var daoFactory = DAOFactory.getFactory();

        AdministratorBusiness business = new AdministratorBusinessImpl(daoFactory);

        try {
            daoFactory.initTransaction();

            final AdministratorDomain domain = AdministratorDTOAssembler.getAdministratorDTOAssembler().toDomain(administrator);

            business.login(domain);

            daoFactory.commitTransaction();

        } catch (final AuroraException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();

            var userMessage = MessagesEnumFacade.USER_ERROR_UNEXPECTED_ERROR.getContent();
            var technicalMessage = MessagesEnumFacade.TECHNICAL_ERROR_UNEXPECTED_ERROR.getContent()
                    + ": " + exception.getMessage();

            throw AuroraException.create(exception, userMessage, technicalMessage);
        } finally {
            daoFactory.closeConnection();
        }

    }

    @Override
    public List<AdministratorDTO> getAdministratorByFilter(AdministratorDTO administrator) {
        return List.of();
    }

    @Override
    public List<AdministratorDTO> getAllAdministrator() {
        return List.of();
    }
}
