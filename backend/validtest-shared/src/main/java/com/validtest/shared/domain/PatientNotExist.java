package com.validtest.shared.domain;

public final class PatientNotExist extends DomainError {

    public PatientNotExist(PatientId id) {
        super("patient_not_exist", String.format("The " + PatientId.class.getName() + " <%s> doesn't exist", id.value()));
    }

}
