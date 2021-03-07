package com.validtest.core.patient.application.create;

import com.validtest.shared.domain.bus.command.Command;

public class CreatePatientCommand implements Command {

  private String id;
  private String firstName;
  private String lastName;
  private String status;

  protected CreatePatientCommand(String id, String firstName, String lastName, String status) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.status = status;
  }

  public static CreatePatientCommand create(String id, String firstName, String lastName, String status) {
    CreatePatientCommand command = new CreatePatientCommand(id, firstName, lastName, status);

    return command;
  }

  public CreatePatientCommand() {
  }

  public String id() {
    return id;
  }

  public String firstName() {
    return firstName;
  }

  public String lastName() {
    return lastName;
  }

  public String status() {
    return status;
  }

}
