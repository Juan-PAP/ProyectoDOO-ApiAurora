package co.edu.uco.aurora.business.facade.impl;

import co.edu.uco.aurora.business.assembler.dto.impl.CustomerDTOAssembler;
import co.edu.uco.aurora.business.business.impl.CustomerBusinessImpl;
import co.edu.uco.aurora.business.facade.CustomerFacade;
import co.edu.uco.aurora.crosscuting.exception.AuroraException;
import co.edu.uco.aurora.data.dao.factory.DAOFactory;
import co.edu.uco.aurora.dto.CustomerDTO;

import java.util.List;
import java.util.UUID;

public final class CustomerFacadeImpl implements CustomerFacade {

    @Override
    public void registerNewCustomer(final CustomerDTO customerDTO) {

        var daoFactory = DAOFactory.getFactory();
        var business = new CustomerBusinessImpl(daoFactory);

        try {

            daoFactory.initTransaction();

            var domain = CustomerDTOAssembler.getCustomerDTOAssembler().toDomain(customerDTO);
            business.registerNewCustomer(domain);

            daoFactory.commitTransaction();

        } catch (final AuroraException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();

            var userMessage = "";
            var technicalMessage = "";

            throw AuroraException.create(exception, userMessage, technicalMessage);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public void updateCustomerInformation(final UUID id, final CustomerDTO customer) {

    }

    @Override
    public void generateSendPhoneConfirmationCode(final String phoneNumber) {

    }

    @Override
    public boolean comfirmationPhoneNumber(final UUID id, final int code) {
        return false;
    }

    @Override
    public List<CustomerDTO> getCustomerByFilter(final CustomerDTO customer) {
        return List.of();
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        return List.of();
    }
}
