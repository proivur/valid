package com.validtest.core.patient.application.update;

import com.validtest.shared.application.ChangeStatusCommand;

public class ReactivatePatientCommand extends ChangeStatusCommand {

    public ReactivatePatientCommand() {
        super();
    }

    private ReactivatePatientCommand(String id) {
        this.id = id;
    }

    public static ReactivatePatientCommand create(String id) {
        ReactivatePatientCommand command = new ReactivatePatientCommand(id);

        return  command;
    }

}
