package co.edu.uco.aurora.business.facade;

import co.edu.uco.aurora.dto.CustomerDTO;

import java.util.List;
import java.util.UUID;

public interface CustomerFacade {

    void registerNewCustomer (CustomerDTO customer);

    void updateCustomerInformation (UUID id, CustomerDTO customer);

    void generateSendPhoneConfirmationCode (String phoneNumber);

    boolean comfirmationPhoneNumber (UUID id, int code);

    List<CustomerDTO> getCustomerByFilter(CustomerDTO customer);

    List<CustomerDTO> getAllCustomer();

}
