package com.validtest.core.patient.infrastructure.controller.create;

import com.validtest.core.patient.application.create.CreatePatientCommand;
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
public class PatientPostRestService extends CommandBusApiController {

  public PatientPostRestService(CommandBus commandBus) {
    super(commandBus);
  }

  @PostMapping(path = "/patients/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PatientRequest> create(@PathVariable String id, @RequestBody PatientRequest req) throws CommandHandlerExecutionError {

    dispatch(CreatePatientCommand.create(
            id,
            req.firstName(),
            req.lastName(),
            req.status()
    ));

    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @Override
  public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
    return new HashMap<Class<? extends DomainError>, HttpStatus>() {{
      put(DomainObjectAlreadyExist.class, HttpStatus.CONFLICT);
    }};
  }

}
