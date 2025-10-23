package co.edu.uco.aurora.business.business.impl;

import co.edu.uco.aurora.business.assembler.entity.impl.CustomerEntityAssembler;
import co.edu.uco.aurora.business.business.CustomerBusiness;
import co.edu.uco.aurora.business.domain.CustomerDomain;
import co.edu.uco.aurora.crosscuting.exception.AuroraException;
import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;
import co.edu.uco.aurora.data.dao.factory.DAOFactory;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

public final class CustomerBusinessImpl implements CustomerBusiness {

    private DAOFactory daoFactory;

    private static final int MIN_NAME_LENGTH = 3;
    private static final int MAX_NAME_LENGTH = 15;
    private static final int MIN_ID_NUMBER_LENGTH = 6;
    private static final int MAX_ID_NUMBER_LENGTH = 25;
    private static final int MIN_PHONE_NUMBER_LENGTH = 8;
    private static final int MAX_PHONE_NUMBER_LENGTH = 20;

    private static final ZoneId BOGOTA_ZONE_ID = ZoneId.of("America/Bogota");
    private static final String ID_TYPE_TI = "TI"; // Tarjeta de Identidad
    private static final String ID_TYPE_CC = "CC"; // Cédula de Ciudadanía

    public CustomerBusinessImpl(final DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void registerNewCustomer(final CustomerDomain customerDomain) {

        validateIntegrityInformationToRegisterNewCustomer(customerDomain);
        validateCustomerWithSameIdentificationNumberDoesNotExist(customerDomain);
        validateCustomerWithSamePhoneNumberDoesNotExist(customerDomain);
        validateCustomerAgeAndDocument(customerDomain);

        var id = UUIDHelper.getUUIDHelper().generateNewUUID();

        var customerDomainToCreate = new CustomerDomain(
                id,
                customerDomain.getIdentificationType(),
                customerDomain.getIdentificationNumber(),
                customerDomain.getFullName(),
                customerDomain.getPhoneNumber(),
                customerDomain.isConfirmedPhoneNumber(),
                customerDomain.getBirthDate()
        );

        var customerEntity = CustomerEntityAssembler.getCustomerEntityAssembler().toEntity(customerDomain);
        daoFactory.getCustomerDAO().create(customerEntity);

    }

    private void validateIntegrityInformationToRegisterNewCustomer (CustomerDomain customer){

    }


    private void validateCustomerWithSameIdentificationNumberDoesNotExist (CustomerDomain customer){

    }

    private void validateCustomerWithSamePhoneNumberDoesNotExist (CustomerDomain customer) {

    }

    private void validateCustomerAgeAndDocument(CustomerDomain customer) throws AuroraException {
        if (customer.getBirthDate() == null || TextHelper.isEmpty(customer.getIdentificationType().getNombre())) {
            throw AuroraException.create("La fecha de nacimiento y el tipo de documento son obligatorios.");
        }

        LocalDate birthDate = customer.getBirthDate();
        LocalDate today = LocalDate.now(BOGOTA_ZONE_ID);

        if (birthDate.isAfter(today)) {
            throw AuroraException.create("La fecha de nacimiento no puede ser una fecha futura.");
        }

        int age = Period.between(birthDate, today).getYears();
        String docType = customer.getIdentificationType().getNombre();

        if (age >= 18) {
            if (ID_TYPE_TI.equalsIgnoreCase(docType)) {
                throw AuroraException.create("Para mayores de 18 años, el tipo de documento no puede ser Tarjeta de Identidad (TI).");
            }
        } else {
            if (ID_TYPE_CC.equalsIgnoreCase(docType)) {
                throw AuroraException.create("Para menores de 18 años, el tipo de documento no puede ser Cédula de Ciudadanía (CC).");
            }
        }
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
        return List.of();
    }
}
