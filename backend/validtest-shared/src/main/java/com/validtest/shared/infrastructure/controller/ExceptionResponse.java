package com.validtest.shared.infrastructure.controller;

import java.util.List;

public class ExceptionResponse {

  private String timestamp;
  private String status;
  private List<Error> errors;


  public ExceptionResponse(String timestamp, String status, List<Error> errors) {
    this.timestamp = timestamp;
    this.status = status;
    this.errors = errors;
  }

  public String getTimestamp() {
    return timestamp;
  }

  public String getStatus() {
    return status;
  }

  public List<Error> getErrors() {
    return errors;
  }

  public static ExceptionResponseBuilder builder() {
    return new ExceptionResponseBuilder();
  }

  public static final class ExceptionResponseBuilder {
    private String timestamp;
    private String status;
    private List<Error> errors;

    private ExceptionResponseBuilder() {
    }


    public ExceptionResponseBuilder timestamp(String timestamp) {
      this.timestamp = timestamp;
      return this;
    }

    public ExceptionResponseBuilder status(String status) {
      this.status = status;
      return this;
    }

    public ExceptionResponseBuilder errors(List<Error> errors) {
      this.errors = errors;
      return this;
    }

    public ExceptionResponse build() {
      return new ExceptionResponse(timestamp, status, errors);
    }

  }

}
