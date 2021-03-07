package com.validtest.core.patient.infrastructure.controller;

import com.validtest.shared.domain.bus.query.Response;
import org.springframework.data.domain.Page;

public final class PatientsResponse implements Response {

    private final Page<PatientResponse> patients;

    public PatientsResponse(Page<PatientResponse> patients) {
        this.patients = patients;
    }

    public Page<PatientResponse> patients() {
        return patients;
    }

}
