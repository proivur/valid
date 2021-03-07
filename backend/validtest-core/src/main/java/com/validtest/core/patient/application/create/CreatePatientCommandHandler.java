package com.validtest.core.patient.application.create;

import com.validtest.core.patient.domain.*;
import com.validtest.shared.domain.*;
import com.validtest.shared.domain.bus.command.CommandHandler;
import com.validtest.shared.domain.bus.event.EventBus;

@Service
public final class CreatePatientCommandHandler implements CommandHandler<CreatePatientCommand> {

    private final PatientRepository repository;
    private final EventBus eventBus;

    public CreatePatientCommandHandler(PatientRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus   = eventBus;
    }

    @Override
    public void handle(CreatePatientCommand command) {
        Patient patient = Patient.create(
                PatientId.create(command.id()), FirstName.create(command.firstName()), LastName.create(command.lastName()), RecordStatus.create(command.status())
        );

        repository.create(patient);
        eventBus.publish(patient.pullDomainEvents());
    }

}
