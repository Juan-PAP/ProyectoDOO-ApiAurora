package co.edu.uco.aurora.controller.exception;

import co.edu.uco.aurora.controller.dto.Response;

import co.edu.uco.aurora.crosscuting.messagescatalog.controller.exception.MessagesEnumController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public final class GlobalApiExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Response<String>> handleHttpMessageNotReadableException(
            HttpMessageNotReadableException ex, WebRequest request) {

        Response<String> responseObjectData = Response.createFailedResponse();
        HttpStatus responseStatusCode = HttpStatus.BAD_REQUEST;

        String userMessage = MessagesEnumController.ERROR_HTTP_MESSAGE_NOT_READABLE_GENERIC.getContent();

        if (ex.getCause() != null && ex.getCause() instanceof com.fasterxml.jackson.databind.exc.InvalidFormatException) {
            if (ex.getCause().getMessage().contains("LocalDate")) {
                userMessage = MessagesEnumController.ERROR_HTTP_MESSAGE_NOT_READABLE_INVALID_DATE.getContent();
            }
        }

        responseObjectData.addMessage(userMessage);

        ex.printStackTrace();

        return new ResponseEntity<>(responseObjectData, responseStatusCode);
    }
}