package com.validtest.shared.infrastructure.controller;

import com.validtest.shared.domain.PatientNotExist;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RestExceptionHandler {

  private static final String METhOD_ARGUMENT_DETAIL = "Value %s not valid";

  @ExceptionHandler({MethodArgumentNotValidException.class})
  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  public ExceptionResponse validationErrorHandler(MethodArgumentNotValidException e) {

    List<Error> errors = new ArrayList<>();

    List<FieldError> fieldErrors =
            e.getBindingResult().getAllErrors().stream()
                    .map(FieldError.class::cast)
                    .collect(Collectors.toList());

    fieldErrors.forEach(
            fieldError -> {
              errors.add(mapToError(fieldError));
            });

    return ExceptionResponse.builder()
            .status(HttpStatus.BAD_REQUEST.toString())
            .errors(errors)
            .build();
  }

  private Error mapToError(FieldError fieldError) {

    return Error.builder()
            .source(fieldError.getField())
            .title(fieldError.getDefaultMessage())
            .detail(String.format(METhOD_ARGUMENT_DETAIL, fieldError.getRejectedValue()))
            .build();
  }

  @ExceptionHandler(PatientNotExist.class)
  @ResponseStatus(code = HttpStatus.NOT_FOUND)
  public DomainErrorResponse StudentNotExistErrorHandler(PatientNotExist e) {

    DomainErrorResponse domainErrorResponse =
            new DomainErrorResponse(e.errorCode(), e.errorMessage());
    return domainErrorResponse;
  }

}
