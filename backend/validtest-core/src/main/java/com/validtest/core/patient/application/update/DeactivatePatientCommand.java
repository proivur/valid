package com.validtest.core.patient.application.update;

import com.validtest.shared.application.ChangeStatusCommand;

public class DeactivatePatientCommand extends ChangeStatusCommand {

    public DeactivatePatientCommand() {
        super();
    }

    private DeactivatePatientCommand(String id) {
        this.id = id;
    }

    public static DeactivatePatientCommand create(String id) {
        DeactivatePatientCommand command = new DeactivatePatientCommand(id);

        return  command;
    }

}
