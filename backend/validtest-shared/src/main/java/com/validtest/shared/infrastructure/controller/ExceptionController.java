package com.validtest.shared.infrastructure.controller;

import com.validtest.shared.domain.DomainObjectAlreadyExist;
import com.validtest.shared.domain.DomainUserAlreadyAddedToAClient;
import com.validtest.shared.domain.EmailAlreadyTaken;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Exception manager 
 */
@Component
@ControllerAdvice
public class ExceptionController {

    private static final Logger LOG = LogManager.getLogger(ExceptionController.class);

    @ExceptionHandler(value
            = { IllegalStateException.class, DomainUserAlreadyAddedToAClient.class })
    protected ResponseEntity<ExceptionResponseData> handleArgumentError(HttpServletRequest req, Exception e)  {
        LOG.error("Request: " + req.getRequestURL() + " raised ", e);

        ExceptionResponseData exceptionResponseData  = new ExceptionResponseData();
        exceptionResponseData.setStatus(HttpStatus.CONFLICT.value());
        exceptionResponseData.setMessage(e.getMessage());

        return new ResponseEntity<ExceptionResponseData>(exceptionResponseData, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = { IllegalArgumentException.class })
    protected ResponseEntity<ExceptionResponseData> handleIllegalArgumentError(HttpServletRequest req, Exception ex)  {
        LOG.error("Request: " + req.getRequestURL() + " raised ", ex);

        ExceptionResponseData exceptionResponseData  = new ExceptionResponseData();
        exceptionResponseData.setStatus(HttpStatus.EXPECTATION_FAILED.value());
        exceptionResponseData.setMessage(ex.getMessage());

        return new ResponseEntity<ExceptionResponseData>(exceptionResponseData, HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    protected ResponseEntity<ExceptionResponseData> handleMethodArgumentNotValid(HttpServletRequest req, MethodArgumentNotValidException e)  {
        LOG.error("Request: " + req.getRequestURL() + " raised ", e);

        BindingResult result = e.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();


        String errors = fieldErrors.stream().map(error -> error.getDefaultMessage())
                .collect(Collectors.joining(", "));

        ExceptionResponseData exceptionResponseData  = new ExceptionResponseData();
        exceptionResponseData.setStatus(HttpStatus.CONFLICT.value());
        exceptionResponseData.setMessage(errors);

        return new ResponseEntity<ExceptionResponseData>(exceptionResponseData, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = DomainObjectAlreadyExist.class)
    public ResponseEntity<ExceptionResponseData> handleExistingDomainObjectError(HttpServletRequest req, Exception ex) {
        LOG.error("Request: " + req.getRequestURL() + " raised ", ex);

        ExceptionResponseData exceptionResponseData  = new ExceptionResponseData();
        exceptionResponseData.setStatus(HttpStatus.CONFLICT.value());
        exceptionResponseData.setMessage(ex.getMessage());

        return new ResponseEntity<ExceptionResponseData>(exceptionResponseData, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = EmailAlreadyTaken.class)
    public ResponseEntity<ExceptionResponseData> handleEmailAlreadyTakenError(HttpServletRequest req, Exception ex) {
        LOG.error("Request: " + req.getRequestURL() + " raised ", ex);

        ExceptionResponseData exceptionResponseData  = new ExceptionResponseData();
        exceptionResponseData.setStatus(HttpStatus.BAD_REQUEST.value());
        exceptionResponseData.setMessage(ex.getMessage());

        return new ResponseEntity<ExceptionResponseData>(exceptionResponseData, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ExceptionResponseData> handleError(HttpServletRequest req, Exception e) {
        LOG.error("Request: " + req.getRequestURL() + " raised ", e);

        ExceptionResponseData exceptionResponseData  = new ExceptionResponseData();
        exceptionResponseData.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        exceptionResponseData.setMessage(e.getMessage());

        return new ResponseEntity<ExceptionResponseData>(exceptionResponseData, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}