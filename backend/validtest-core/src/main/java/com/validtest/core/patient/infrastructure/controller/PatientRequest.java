package com.validtest.core.patient.infrastructure.controller;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

public class PatientRequest implements Serializable {

  private static final long serialVersionUID = 1L;
  private String firstName;
  private String lastName;
  private String status;

  public String firstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String lastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String status() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

}
