package co.edu.uco.aurora.controller;

import co.edu.uco.aurora.business.facade.impl.IdentificationTypeFacadeImpl;
import co.edu.uco.aurora.controller.dto.Response;
import co.edu.uco.aurora.crosscuting.exception.AuroraException;
import co.edu.uco.aurora.crosscuting.messagescatalog.controller.MessagesEnumIdentificationTypeController;
import co.edu.uco.aurora.dto.IdentificationTypeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/id-types")
public class IdentificationTypeController {

    @GetMapping
    public ResponseEntity<Response<IdentificationTypeDTO>> findAllIdentificationTypes() {

        Response<IdentificationTypeDTO> responseObjectData = Response.createSuccededResponse();
        HttpStatusCode responseStatusCode = HttpStatus.OK;

        try {
            var facade = new IdentificationTypeFacadeImpl();

            responseObjectData.setData(facade.getAllIdentificationType());
            responseObjectData.addMessage(
                    MessagesEnumIdentificationTypeController.ID_TYPES_LOADED_SUCCESS.getContent()
            );

        } catch (final AuroraException exception) {

            responseObjectData = Response.createFailedResponse();
            responseObjectData.addMessage(exception.getUserMessage());
            responseStatusCode = HttpStatus.BAD_REQUEST;
            exception.printStackTrace();

        } catch (final Exception exception) {
            responseObjectData = Response.createFailedResponse();
            responseObjectData.addMessage(
                    MessagesEnumIdentificationTypeController.ID_TYPES_UNEXPECTED_ERROR.getContent()
            );
            responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            exception.printStackTrace();
        }

        return new ResponseEntity<>(responseObjectData, responseStatusCode);
    }
}