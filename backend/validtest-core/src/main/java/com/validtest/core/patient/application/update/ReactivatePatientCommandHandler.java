package com.validtest.core.patient.application.update;

import com.validtest.core.patient.domain.Patient;
import com.validtest.shared.domain.Service;
import com.validtest.shared.domain.bus.command.CommandHandler;
import com.validtest.shared.domain.bus.event.EventBus;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public final class ReactivatePatientCommandHandler implements CommandHandler<ReactivatePatientCommand> {

    @Autowired
    private PatientUpdater patientUpdater;

    @Autowired
    private EventBus eventBus;

    @Override
    public void handle(ReactivatePatientCommand command) {

        Patient patient = Patient.create(command.id());
        patientUpdater.reactivate(patient);
        eventBus.publish(patient.pullDomainEvents());
    }

}
