package com.omexit.mifospaymentbridge.util;

import com.google.i18n.phonenumbers.NumberParseException;
import com.omexit.mifospaymentbridge.exception.ResourceNotFoundException;
import com.omexit.mifospaymentbridge.exception.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.NoResultException;
import javax.validation.ConstraintViolationException;

/**
 * Created by aomeri on 12/3/16.
 */
@ControllerAdvice(annotations = RestController.class)
public class ErrorControllerAdvice {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<RestError> handleConstraintViolationException(
            ConstraintViolationException cre) {
        logger.error("- ConstraintViolationException: ", cre);
        RestError error = new RestError(HttpStatus.BAD_REQUEST.value(), 500, "Constraint violation error!",
                "Constraint violation error!", cre.getMessage());
        return new ResponseEntity<RestError>(error, HttpStatus.BAD_REQUEST);
    }


    /**
     * Handles JPA NoResultExceptions thrown from web service controller
     * methods. Creates a response with an empty body and HTTP status code 404,
     * not found.
     *
     * @param nre A NoResultException instance.
     * @return A ResponseEntity with an empty response body and HTTP status code
     * 404.
     */
    @ExceptionHandler(NoResultException.class)
    public ResponseEntity<Exception> handleNoResultException(
            NoResultException nre) {
        logger.error("- NoResultException: ", nre);
        RestError error = new RestError(HttpStatus.NOT_FOUND.value(), 500, "No results found",
                "No results found", nre.getMessage());
        return new ResponseEntity<Exception>(HttpStatus.NOT_FOUND);
    }

    /**
     * Handles all Exceptions not addressed by more specific
     * <code>@ExceptionHandler</code> methods. Creates a response with the
     * Exception detail in the response body as JSON and a HTTP status code of
     * 500, internal server error.
     *
     * @param e An Exception instance.
     * @return A ResponseEntity containing a the Exception attributes in the
     * response body and a HTTP status code 500.
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<RestError> handleException(Exception e) {
        logger.error("- Exception: ", e);
        RestError error = new RestError(HttpStatus.INTERNAL_SERVER_ERROR.value(), 500, "Error occurred in the server",
                null, e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Handles HttpMessageNotReadableException Exceptions not addressed by more specific
     * <code>@ExceptionHandler</code> methods. Creates a response with the
     * Exception detail in the response body as JSON and a HTTP status code of
     * 500, internal server error.
     *
     * @param e An Exception instance.
     * @return A ResponseEntity containing a the Exception attributes in the
     * response body and a HTTP status code 500.
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ResponseEntity<RestError> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        logger.error("- HttpMessageNotReadableException: ", e);
//        logger.error("< handleException");
        RestError error = new RestError(HttpStatus.BAD_REQUEST.value(), 1002, "Request not readable",
                e.getMessage(), e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseBody
    public ResponseEntity<RestError> handleValidationException(ValidationException e) {
        logger.error("- ValidationException: " + e.getMessage());

        RestError error = new RestError(HttpStatus.BAD_REQUEST.value(), 1002, "Request validation errors",
                e.getMessage(), e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseBody
    public ResponseEntity<RestError> handleRetailerNotFoundException(ResourceNotFoundException e) {
        logger.error("- ResourceNotFoundException: " + e.getMessage());

        RestError error = new RestError(HttpStatus.NOT_FOUND.value(), 1002, e.getMessage(),
                "Resource not found exception.", e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(NumberParseException.class)
    @ResponseBody
    public ResponseEntity<RestError> handlePhonenUmbersNumberParseException(NumberParseException e) {
        logger.error("- NumberParseException: " + e.getMessage());

        RestError error = new RestError(HttpStatus.BAD_REQUEST.value(), 1003, e.getMessage(),
                "Unable to parse phone number", e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
