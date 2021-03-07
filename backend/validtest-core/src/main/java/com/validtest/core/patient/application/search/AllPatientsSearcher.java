package com.validtest.core.patient.application.search;

import com.validtest.core.patient.domain.Patient;
import com.validtest.core.patient.domain.PatientRepository;
import com.validtest.core.patient.infrastructure.controller.PatientResponse;
import com.validtest.shared.domain.Service;
import org.springframework.data.domain.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
public final class AllPatientsSearcher {

    private final PatientRepository repository;

    public AllPatientsSearcher(PatientRepository repository) {
        this.repository = repository;
    }

    public Page<PatientResponse> findAll(String filter, Integer pageNo, Integer pageSize, String sortBy, String direction) {
        Page<Patient> response = repository.findAll(filter, pageNo, pageSize, sortBy, direction);

        return getPatientResponses(pageNo, pageSize, sortBy, direction, response);
    }

    private Page<PatientResponse> getPatientResponses(Integer pageNo, Integer pageSize, String sortBy, String direction, Page<Patient> response) {
        List<PatientResponse> records = response.get().map(PatientResponse::fromAggregate).collect(Collectors.toList());
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(direction.equals("asc") ? Sort.Order.asc(sortBy) : Sort.Order.desc(sortBy)));

        return new PageImpl<>(records, pageable, records.size());
    }

}
