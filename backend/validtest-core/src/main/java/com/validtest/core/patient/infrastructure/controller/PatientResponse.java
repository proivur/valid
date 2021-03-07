package com.validtest.core.patient.infrastructure.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.validtest.core.patient.domain.Patient;
import com.validtest.shared.domain.bus.query.Response;

import java.util.*;

public class PatientResponse implements Response {

    private String id;
    private String firstName;
    private String lastName;
    private String status;

    public PatientResponse() {
    }

    public PatientResponse(String id, String firstName, String lastName, String status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
    }

    public static PatientResponse fromAggregate(Patient patient) {

        PatientResponse response = new PatientResponse(
            patient.id().value(),
            patient.firstName().value(),
            patient.lastName().value(),
            patient.status().value()
        );

        return response;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PatientResponse that = (PatientResponse) o;

        return
                id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, status);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
