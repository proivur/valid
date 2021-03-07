package com.validtest.core.patient.infrastructure.controller.search;

import com.validtest.core.patient.application.search.SearchAllPatientsQuery;
import com.validtest.core.patient.infrastructure.controller.PatientsResponse;
import com.validtest.shared.domain.DomainError;
import com.validtest.shared.domain.PatientNotExist;
import com.validtest.shared.domain.bus.query.QueryBus;
import com.validtest.shared.domain.bus.query.QueryHandlerExecutionError;
import com.validtest.shared.infrastructure.controller.spring.QueryBusApiController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@CrossOrigin(origins = "*")
@RequestMapping("/api")
@RestController
public class PatientGetRestService extends QueryBusApiController {

    public PatientGetRestService(QueryBus queryBus) {
        super(queryBus);
    }

    @GetMapping(path = "/patients", produces = MediaType.APPLICATION_JSON_VALUE)
    public PatientsResponse getAll(@Valid @RequestParam(required = true) String filter,
                                   @Valid @RequestParam(required = true) Integer pageNo,
                                   @Valid @RequestParam(required = true) Integer pageSize,
                                   @Valid @RequestParam(required = true) String sortBy,
                                   @Valid @RequestParam(required = true) String direction) throws QueryHandlerExecutionError {

        return ask(SearchAllPatientsQuery.createBuilder()
                .withFilter(filter)
                .withPageNo(pageNo)
                .withPageSize(pageSize)
                .withSortBy(sortBy)
                .withDirection(direction)
                .build());
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return new HashMap<Class<? extends DomainError>, HttpStatus>() {{
            put(PatientNotExist.class, HttpStatus.NOT_FOUND);
        }};
    }

}
