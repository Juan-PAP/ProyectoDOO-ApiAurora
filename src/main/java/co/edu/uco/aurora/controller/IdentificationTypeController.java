package co.edu.uco.aurora.controller;

import co.edu.uco.aurora.business.facade.impl.IdentificationTypeFacadeImpl;
import co.edu.uco.aurora.controller.dto.Response;
import co.edu.uco.aurora.crosscuting.exception.AuroraException;
import co.edu.uco.aurora.dto.IdentificationTypeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/identification-types")
public class IdentificationTypeController {

    @GetMapping
    public ResponseEntity<Response<IdentificationTypeDTO>> findAllIdentificationTypes() {

        Response<IdentificationTypeDTO> responseObjectData = Response.createSuccededResponse();
        HttpStatusCode responseStatusCode = HttpStatus.OK;

        try {
            // Sigo el patrón de tu CustomerController
            var facade = new IdentificationTypeFacadeImpl();

            // Asumo que tu fachada tiene un método 'findAll()' que devuelve List<IdentificationTypeDTO>
            responseObjectData.setData(facade.getAllIdentificationType());
            responseObjectData.addMessage("All identification types loaded successfully");

        } catch (final AuroraException exception) {

            responseObjectData = Response.createFailedResponse();
            responseObjectData.addMessage(exception.getUserMessage());
            responseStatusCode = HttpStatus.BAD_REQUEST;
            exception.printStackTrace();

        } catch (final Exception exception) {
            var userMessage = "Unexpected error";
            responseObjectData = Response.createFailedResponse();
            responseObjectData.addMessage(userMessage);
            responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            exception.printStackTrace();
        }

        return new ResponseEntity<>(responseObjectData, responseStatusCode);
        }


}
