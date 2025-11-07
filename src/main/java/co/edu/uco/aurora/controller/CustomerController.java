package co.edu.uco.aurora.controller;

import co.edu.uco.aurora.business.facade.impl.CustomerFacadeImpl;
import co.edu.uco.aurora.controller.dto.Response;
import co.edu.uco.aurora.crosscuting.exception.AuroraException;
import co.edu.uco.aurora.crosscuting.messagescatalog.controller.MessagesEnumCustomerController;
import co.edu.uco.aurora.dto.CustomerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @GetMapping
    public ResponseEntity<Response<CustomerDTO>> findAllCustomers() {

        Response<CustomerDTO> responseObjectData = Response.createSuccededResponse();
        HttpStatusCode responseStatusCode = HttpStatus.OK;

        try {
            var facade = new CustomerFacadeImpl();
            responseObjectData.setData(facade.getAllCustomer());
            responseObjectData.addMessage(
                    MessagesEnumCustomerController.CUSTOMERS_FILTERED_SUCCESS.getContent()
            );

        } catch (final AuroraException exception) {
            responseObjectData = Response.createFailedResponse();
            responseObjectData.addMessage(exception.getUserMessage());
            responseStatusCode = HttpStatus.BAD_REQUEST;
            exception.printStackTrace();

        } catch (final Exception exception) {
            responseObjectData = Response.createFailedResponse();
            responseObjectData.addMessage(
                    MessagesEnumCustomerController.CUSTOMERS_UNEXPECTED_ERROR.getContent()
            );
            responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            exception.printStackTrace();
        }
        return new ResponseEntity<>(responseObjectData, responseStatusCode);
    }

    @PostMapping
    public ResponseEntity<Response<CustomerDTO>> registerNewCustomer(@RequestBody CustomerDTO customer) {

        Response<CustomerDTO> responseObjectData = Response.createSuccededResponse();
        HttpStatusCode responseStatusCode = HttpStatus.CREATED;

        try {
            var facade = new CustomerFacadeImpl();
            facade.registerNewCustomer(customer);
            responseObjectData.addMessage(
                    MessagesEnumCustomerController.CUSTOMER_REGISTER_SUCCESS.getContent()
            );

        } catch (final AuroraException exception) {
            responseObjectData = Response.createFailedResponse();
            responseObjectData.addMessage(exception.getUserMessage());
            responseStatusCode = HttpStatus.BAD_REQUEST;
            exception.printStackTrace();

        } catch (final Exception exception) {
            responseObjectData = Response.createFailedResponse();
            responseObjectData.addMessage(
                    MessagesEnumCustomerController.CUSTOMERS_UNEXPECTED_ERROR.getContent()
            );
            responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            exception.printStackTrace();
        }
        return new ResponseEntity<>(responseObjectData, responseStatusCode);
    }
}