package co.edu.uco.aurora.business.business.impl;

import co.edu.uco.aurora.business.assembler.entity.impl.CustomerEntityAssembler;
import co.edu.uco.aurora.business.business.CustomerBusiness;
import co.edu.uco.aurora.business.domain.CustomerDomain;
import co.edu.uco.aurora.crosscuting.exception.AuroraException;
import co.edu.uco.aurora.crosscuting.helper.TextHelper;
import co.edu.uco.aurora.crosscuting.helper.UUIDHelper;
import co.edu.uco.aurora.data.dao.factory.DAOFactory;
import co.edu.uco.aurora.entity.CustomerEntity;
import co.edu.uco.aurora.entity.IdentificationTypeEntity;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

public final class CustomerBusinessImpl implements CustomerBusiness {

    private DAOFactory daoFactory;

    //Constante para la zona horaria en Colombia para el limite de la fecha actual
    private static final ZoneId BOGOTA_ZONE_ID = ZoneId.of("America/Bogota");
    //Constante para la fecha minima de nacimiento
    private static final LocalDate MIN_BIRTH_DATE = LocalDate.of(1900, 1, 1);

    //Para el nombre solo se permiten letras y espacios
    private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$");

    //Para el documento y el telefono solo se permiten digitos
    private static final Pattern DIGIT_PATTERN = Pattern.compile("^\\d+$");

    //Esto para manejar la restriccion de edad y el tipo de documento
    private static final String DOC_TYPE_TI = "Tarjeta de Identidad";
    private static final String DOC_TYPE_CC = "Cedula de Ciudadania";

    public CustomerBusinessImpl(final DAOFactory daoFactory) {
        if (daoFactory == null) {
            throw AuroraException.create("DAOFactory no puede ser nulo.");
        }
        this.daoFactory = daoFactory;
    }

    @Override
    public void registerNewCustomer(final CustomerDomain customerDomain) {

        // 1. Validar integridad en los formatos, longitudes, rangos y obligatoriedad
        validateIntegrityInformation(customerDomain);

        // 2. Validar reglas del tipo de documento y la edad
        validateCustomerAgeAndDocument(customerDomain);

        // 3. Validar que el numero de documento sea unico
        validateCustomerWithSameIdentificationNumberDoesNotExist(customerDomain);

        // 4. Validar que el numero de telefono sea unico
        validateCustomerWithSamePhoneNumberDoesNotExist(customerDomain);

        // 5. Generar un nuevo ID unico
        var id = generateNewUniqueCustomerId();
        customerDomain.setId(id);

        // 6. El telefono incializa como no confirmado
        customerDomain.setPhoneNumberConfirmed(false);

        // 7. Creacion del cliente
        var customerEntity = CustomerEntityAssembler.getCustomerEntityAssembler().toEntity(customerDomain);
        daoFactory.getCustomerDAO().create(customerEntity);
    }

    /**
     * Regla 1: Valida formatos, longitudes, rangos y obligatoriedad.
     */
    private void validateIntegrityInformation(CustomerDomain customer) {
        // Reglas para Tipo de Identificacion
        if (customer == null) {
            throw AuroraException.create("La información del cliente es obligatoria.");
        }
        if (customer.getIdentificationType() == null || UUIDHelper.getUUIDHelper().isDefaultUUID(customer.getIdentificationType().getId())) {
            throw AuroraException.create("El tipo de identificación del cliente es obligatorio.");
        }
        if (TextHelper.isEmptyWithTrim(customer.getIdentificationType().getName())) {
            throw AuroraException.create("El nombre del tipo de identificación es obligatorio para validar las reglas de edad.");
        }

        // Reglas para Numero de Identificacion
        String idNumber = customer.getIdentificationNumber();
        if (TextHelper.isEmptyWithTrim(idNumber)) {
            throw AuroraException.create("El número de identificación es obligatorio.");
        }
        if (!DIGIT_PATTERN.matcher(idNumber).matches()) {
            throw AuroraException.create("El número de identificación solo debe contener dígitos.");
        }
        if (idNumber.length() < 6 || idNumber.length() > 25) {
            throw AuroraException.create("El número de identificación debe tener entre 6 y 25 dígitos.");
        }

        // Reglas para el Nombre
        String fullName = customer.getFullName();
        if (TextHelper.isEmptyWithTrim(fullName)) {
            throw AuroraException.create("El nombre completo es obligatorio.");
        }
        if (!NAME_PATTERN.matcher(fullName).matches()) {
            throw AuroraException.create("El nombre completo no debe contener caracteres especiales o números.");
        }
        if (fullName.length() < 3 || fullName.length() > 100) {
            throw AuroraException.create("El nombre completo debe tener entre 3 y 100 caracteres.");
        }

        // Reglas para Telefono
        String phoneNumber = customer.getPhoneNumber();
        if (TextHelper.isEmptyWithTrim(phoneNumber)) {
            throw AuroraException.create("El número de teléfono es obligatorio.");
        }
        if (!DIGIT_PATTERN.matcher(phoneNumber).matches()) {
            throw AuroraException.create("El número de teléfono solo debe contener dígitos.");
        }
        if (phoneNumber.length() < 8 || phoneNumber.length() > 15) {
            throw AuroraException.create("El número de teléfono debe tener entre 8 y 15 dígitos.");
        }

        // Reglas para Fecha de Nacimiento
        LocalDate birthDate = customer.getBirthDate();
        if (birthDate == null) {
            throw AuroraException.create("La fecha de nacimiento es obligatoria.");
        }
        LocalDate today = LocalDate.now(BOGOTA_ZONE_ID);
        if (birthDate.isAfter(today)) {
            throw AuroraException.create("La fecha de nacimiento no puede ser una fecha futura.");
        }
        if (birthDate.isBefore(MIN_BIRTH_DATE)) {
            throw AuroraException.create("La fecha de nacimiento no puede ser anterior al 01/01/1900.");
        }
    }
    /**
     * Regla 2: Valida la coherencia entre la edad y el tipo de documento.
     */
    private void validateCustomerAgeAndDocument(CustomerDomain customer) {

        LocalDate birthDate = customer.getBirthDate();
        LocalDate today = LocalDate.now(BOGOTA_ZONE_ID);
        int age = Period.between(birthDate, today).getYears();

        String docType = TextHelper.getDefaultWithTrim(customer.getIdentificationType().getName());

        if (age >= 18) { //Si es mayor de edad
            if (DOC_TYPE_TI.equalsIgnoreCase(docType)) {//Y Si el documento es Tarjeta de Identidad
                throw AuroraException.create("Un cliente mayor de 18 años no puede tener 'Tarjeta de Identidad' (TI).");
            }
        } else {//De lo contrario, si es menor de edad
            if (DOC_TYPE_CC.equalsIgnoreCase(docType)) {//Y Si el documento es Cedula de Ciudadania
                throw AuroraException.create("Un cliente menor de 18 años no puede tener 'Cédula de Ciudadanía' (CC).");
            }
        }
        //Si el documento es diferente a Tarjeta o Cedula, no pasa por la validación
        //Osea pasa derecho
    }
    /**
     * Regla 3: Valida que la identificación no exista.
     */
    private void validateCustomerWithSameIdentificationNumberDoesNotExist(CustomerDomain customer) {
        var idTypeFilter = new IdentificationTypeEntity();
        idTypeFilter.setId(customer.getIdentificationType().getId());

        var filter = new CustomerEntity();
        filter.setIdentificationType(idTypeFilter);
        filter.setIdentificationNumber(customer.getIdentificationNumber());

        List<CustomerEntity> results = daoFactory.getCustomerDAO().findByFilter(filter);

        if (!results.isEmpty()) {
            throw AuroraException.create("Ya existe un cliente con el mismo tipo y número de identificación.");
        }
    }
    /**
     * Regla 3: Valida que el teléfono no exista.
     */
    private void validateCustomerWithSamePhoneNumberDoesNotExist(CustomerDomain customer) {
        var filter = new CustomerEntity();
        filter.setPhoneNumber(customer.getPhoneNumber());

        List<CustomerEntity> results = daoFactory.getCustomerDAO().findByFilter(filter);

        if (!results.isEmpty()) {
            throw AuroraException.create("Ya existe un cliente con el mismo número de teléfono.");
        }
    }
    /**
     * Regla 4: Genera un UUID y verificar que sea unico
     */
    private UUID generateNewUniqueCustomerId() {
        UUID newId;
        boolean exists;

        do {
            newId = UUIDHelper.getUUIDHelper().generateNewUUID();

            CustomerEntity filter = new CustomerEntity();
            filter.setId(newId);

            exists = !daoFactory.getCustomerDAO().findByFilter(filter).isEmpty();

        } while (exists); // Se repetira y generara un nuevo UUID hasta que no exista

        return newId;
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

        // Se obtiene la lista de entidades desde la capa de datos por una consulta
        final List<CustomerEntity> entityList = daoFactory.getCustomerDAO().findAll();

        // Se convierte la lista de entidades a una lista de dominios
        final List<CustomerDomain> domainList = new ArrayList<>();

        // Se itera sobre cada entidad y convertirla a dominio
        for (final CustomerEntity entity : entityList) {
            domainList.add(CustomerEntityAssembler.getCustomerEntityAssembler().toDomain(entity));
        }

        // Se retorna la lista de dominios
        return domainList;
    }
}
