package com.validtest.core.patient.application.update;

import com.validtest.core.patient.domain.*;
import com.validtest.shared.domain.*;
import com.validtest.shared.domain.bus.command.CommandHandler;
import com.validtest.shared.domain.bus.event.EventBus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public final class UpdatePatientCommandHandler implements CommandHandler<UpdatePatientCommand> {

    private final PatientRepository repository;
    private final EventBus eventBus;

    public UpdatePatientCommandHandler(PatientRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus   = eventBus;
    }

    @Override
    public void handle(UpdatePatientCommand command) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        Patient patient = Patient.create(
                PatientId.create(command.id()), FirstName.create(command.firstName()), LastName.create(command.lastName()),
                        RecordStatus.create(command.status())
        );

        repository.update(patient);
        eventBus.publish(patient.pullDomainEvents());
    }

}
