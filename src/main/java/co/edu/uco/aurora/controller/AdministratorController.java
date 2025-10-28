package co.edu.uco.aurora.controller;

import co.edu.uco.aurora.business.facade.impl.AdministratorFacadeImpl;
import co.edu.uco.aurora.controller.dto.Response;
import co.edu.uco.aurora.crosscuting.exception.AuroraException;
import co.edu.uco.aurora.dto.AdministratorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/api/v1/administrators")
public class AdministratorController {

    @PostMapping("/login")
    public ResponseEntity<Response<AdministratorDTO>> login(@RequestBody AdministratorDTO administrator) {

        Response<AdministratorDTO> responseObjectData = Response.createSuccededResponse();
        HttpStatusCode responseStatusCode = HttpStatus.OK; // 200 OK para un login exitoso

        try {

            var facade = new AdministratorFacadeImpl();

            facade.login(administrator);

            responseObjectData.addMessage("Administrator login successful");

        } catch (final AuroraException exception) {

            responseObjectData = Response.createFailedResponse();
            responseObjectData.addMessage(exception.getUserMessage());

            responseStatusCode = HttpStatus.UNAUTHORIZED;
            exception.printStackTrace();

        } catch (final Exception exception) {

            var userMessage = "Unexpected error during login";
            responseObjectData = Response.createFailedResponse();
            responseObjectData.addMessage(userMessage);
            responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR; // 500
            exception.printStackTrace();
        }

        return new ResponseEntity<>(responseObjectData, responseStatusCode);
    }

}
