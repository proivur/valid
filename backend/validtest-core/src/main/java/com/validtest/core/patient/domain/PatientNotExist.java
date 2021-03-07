package com.validtest.core.patient.domain;

import com.validtest.shared.domain.DomainError;
import com.validtest.shared.domain.PatientId;

public final class PatientNotExist extends DomainError {

    public PatientNotExist(PatientId id) {
        super("patient_not_exist", String.format("The patient <%s> doesn't exist", id.value()));
    }

}
