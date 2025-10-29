package co.edu.uco.aurora.business.facade.impl;

import co.edu.uco.aurora.business.assembler.dto.impl.IdentificationTypeDTOAssembler;
import co.edu.uco.aurora.business.business.impl.IdentificationTypeBusinessImpl;
import co.edu.uco.aurora.business.domain.IdentificationTypeDomain;
import co.edu.uco.aurora.business.facade.IdentificationTypeFacade;
import co.edu.uco.aurora.crosscuting.exception.AuroraException;
import co.edu.uco.aurora.data.dao.factory.DAOFactory;
import co.edu.uco.aurora.dto.IdentificationTypeDTO;

import java.util.List;

public class IdentificationTypeFacadeImpl implements IdentificationTypeFacade {
    @Override
    public List<IdentificationTypeDTO> getIdentificationTypeByFilter(IdentificationTypeDTO identificationType) {
        return List.of();
    }

    @Override
    public List<IdentificationTypeDTO> getAllIdentificationType() {

        var daoFactory = DAOFactory.getFactory();
        var business = new IdentificationTypeBusinessImpl(daoFactory);

        try {
            daoFactory.initTransaction();

            List<IdentificationTypeDomain> domainList = business.getAllIdentificationType();

            return IdentificationTypeDTOAssembler.getIdentificationTypeDTOAssembler().toDTO(domainList);

        } catch (final AuroraException exception) {
            daoFactory.rollbackTransaction();
            throw exception;

        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();

            var userMessage = "An unexpected error occurred while retrieving identification types.";
            var technicalMessage = "Unexpected error: " + exception.getMessage();

            throw AuroraException.create(exception, userMessage, technicalMessage);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public IdentificationTypeDTO getIdentificationTypeById(IdentificationTypeDTO identificationType) {
        return null;
    }
}
