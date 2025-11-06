package co.edu.uco.aurora.business.business.impl;

import co.edu.uco.aurora.business.assembler.entity.impl.CustomerEntityAssembler;
import co.edu.uco.aurora.business.business.CustomerBusiness;
import co.edu.uco.aurora.business.business.rule.validator.customer.*;
import co.edu.uco.aurora.business.business.rule.validator.identidicationtype.ValidateIdentificationTypeExistsById;
import co.edu.uco.aurora.business.domain.CustomerDomain;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;
import co.edu.uco.aurora.data.dao.factory.DAOFactory;
import co.edu.uco.aurora.entity.CustomerEntity;

import java.util.List;
import java.util.UUID;


public final class CustomerBusinessImpl implements CustomerBusiness {

    private final DAOFactory daoFactory;

    public CustomerBusinessImpl(final DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void registerNewCustomer(final CustomerDomain customerDomain) {

        ValidateDataCustomerConsistencyForRegisterNewInformation.executeValidation(customerDomain);

        ValidateCustomerBirthDateIsAtLeastSevenYearsOld.executeValidation(customerDomain);

        ValidateIdentificationTypeExistsById.executeValidation(customerDomain.getIdentificationType().getId(), daoFactory);

        ValidateCustomerIdentificationNumberDoesNotExist.executeValidation(customerDomain.getIdentificationNumber(), daoFactory);

        ValidateCustomerPhoneNumberDoesNotExist.executeValidation(customerDomain.getPhoneNumber(), daoFactory);

        ValidateCustomerDatesConsistency.executeValidation(customerDomain);

        var customerEntity = CustomerEntityAssembler.getCustomerEntityAssembler().toEntity(customerDomain);

        customerEntity.setId(generateId());

        daoFactory.getCustomerDAO().create(customerEntity);
    }

    private UUID generateId() {

        var id = UUIDHelper.getUUIDHelper().generateNewUUID();
        var userEntity = daoFactory.getCustomerDAO().findById(id);

        while (!UUIDHelper.getUUIDHelper().isDefaultUUID(userEntity.getId())) {
            id = UUIDHelper.getUUIDHelper().generateNewUUID();
            userEntity = daoFactory.getCustomerDAO().findById(id);
        }

        return id;
    }

    @Override
    public void updateCustomerInformation(final UUID id, CustomerDomain customer) {

    }

    @Override
    public void generateSendPhoneConfirmationCode(final String phoneNumber) {

    }

    @Override
    public boolean comfirmationPhoneNumber(final UUID id, int code) {
        return false;
    }

    @Override
    public List<CustomerDomain> getCustomerByFilter(final CustomerDomain customer) {
        return List.of();
    }

    @Override
    public List<CustomerDomain> getAllCustomer() {

        final List<CustomerEntity> entityList = daoFactory.getCustomerDAO().findAll();

        return CustomerEntityAssembler.getCustomerEntityAssembler().toDomain(entityList);
    }
}
