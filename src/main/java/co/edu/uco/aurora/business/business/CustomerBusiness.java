package co.edu.uco.aurora.business.business;

import co.edu.uco.aurora.business.domain.CustomerDomain;

import java.util.List;
import java.util.UUID;

public interface CustomerBusiness {

     void registerNewCustomer (CustomerDomain customer);

     void updateCustomerInformation (UUID id, CustomerDomain customer);

     void generateSendPhoneConfirmationCode (String phoneNumber);

     boolean comfirmationPhoneNumber (UUID id, int code);

     List<CustomerDomain> getCustomerByFilter(CustomerDomain customer);

     List<CustomerDomain> getAllCustomer();

}
