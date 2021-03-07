package com.validtest.core.patient.domain;

import com.validtest.shared.domain.PatientId;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface PatientRepository {

    void create(Patient patient);

    void update(Patient patient);

    Optional<Patient> findById(PatientId id);

    Page<Patient> findAll(String filter, Integer pageNo, Integer pageSize, String sortBy, String direction);

    void logicallyDelete(PatientId id);

    void reactivate(PatientId id);

    void deactivate(PatientId id);

}
