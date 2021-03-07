package com.validtest.core.patient.infrastructure.controller.update;

import com.validtest.core.patient.application.create.CreatePatientCommand;
import com.validtest.core.patient.application.update.DeactivatePatientCommand;
import com.validtest.core.patient.application.update.ReactivatePatientCommand;
import com.validtest.core.patient.infrastructure.controller.PatientRequest;
import com.validtest.shared.domain.DomainError;
import com.validtest.shared.domain.DomainObjectAlreadyExist;
import com.validtest.shared.domain.bus.command.CommandBus;
import com.validtest.shared.domain.bus.command.CommandHandlerExecutionError;
import com.validtest.shared.infrastructure.controller.spring.CommandBusApiController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@CrossOrigin(origins = "*")
@RequestMapping("/api")
@RestController
public final class
PatientPutRestService extends CommandBusApiController {

    public PatientPutRestService(CommandBus commandBus) {
        super(commandBus);
    }

    @PutMapping(path = "/patients/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> update(@PathVariable String id, @RequestBody PatientRequest req) throws CommandHandlerExecutionError {

        CreatePatientCommand command = CreatePatientCommand.create(
                id,
                req.firstName(),
                req.lastName(),
                req.status());

        dispatch(command);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(path = "/patients/{id}/deactivate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> deactivate(@PathVariable("id") String id) throws CommandHandlerExecutionError {

        DeactivatePatientCommand command = DeactivatePatientCommand.create(id);
        dispatch(command);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path = "/patients/{id}/reactivate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> reactivate(@PathVariable("id") String id) {

        ReactivatePatientCommand command = ReactivatePatientCommand.create(id);
        dispatch(command);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return new HashMap<Class<? extends DomainError>, HttpStatus>() {{
            put(DomainObjectAlreadyExist.class, HttpStatus.CONFLICT);
        }};
    }

}
