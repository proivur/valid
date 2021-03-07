package com.validtest.core.patient.application.update;

import com.validtest.core.patient.domain.Patient;
import com.validtest.shared.domain.Service;
import com.validtest.shared.domain.bus.command.CommandHandler;
import com.validtest.shared.domain.bus.event.EventBus;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public final class DeactivatePatientCommandHandler implements CommandHandler<DeactivatePatientCommand> {

    @Autowired
    private com.validtest.core.patient.application.update.PatientUpdater patientUpdater;

    @Autowired
    private EventBus eventBus;

    @Override
    public void handle(DeactivatePatientCommand command) {

        Patient patient = Patient.create(command.id());
        patientUpdater.deactivate(patient);
        eventBus.publish(patient.pullDomainEvents());
    }

}
