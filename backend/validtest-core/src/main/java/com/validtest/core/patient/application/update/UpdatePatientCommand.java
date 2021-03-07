package com.validtest.core.patient.application.update;

import com.validtest.core.patient.application.create.CreatePatientCommand;
import com.validtest.shared.domain.bus.command.Command;

public class UpdatePatientCommand extends CreatePatientCommand implements Command {

  public UpdatePatientCommand() {
  }

  private UpdatePatientCommand(String id, String firstName, String lastName, String status) {
    super(id, firstName, lastName, status);
  }

  public static UpdatePatientCommand create(String id, String firstName, String lastName, String status) {
    UpdatePatientCommand command = new UpdatePatientCommand(id, firstName, lastName, status);

    return command;
  }

}
