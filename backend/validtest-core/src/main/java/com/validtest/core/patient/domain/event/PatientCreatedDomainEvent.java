package com.validtest.core.patient.domain.event;

import com.validtest.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public final class PatientCreatedDomainEvent extends DomainEvent {

    private String id;
    private String firstName;
    private String lastName;
    private String status;

    public PatientCreatedDomainEvent() {
        super();
    }

    public static Builder createBuilder() {
        return new Builder();
    }

    public static final class Builder {

        private PatientCreatedDomainEvent domainEvent;

        public Builder () {
            this.domainEvent = new PatientCreatedDomainEvent();
        }

        public Builder withId(String id) {
            this.domainEvent.id = id;

            return this;
        }

        public Builder withFirstName(String firstName) {
            this.domainEvent.firstName = firstName;

            return this;
        }

        public Builder withLastName(String lastName) {
            this.domainEvent.lastName = lastName;

            return this;
        }

        public Builder withStatus(String status) {
            this.domainEvent.status = status;

            return this;
        }

        public PatientCreatedDomainEvent build () {
            return this.domainEvent;
        }

    } // inner class

    public String id() {
        return id;
    }

    public String firstName() {
        return firstName;
    }

    public String status() {
        return status;
    }

    @Override
    public String eventName() {
        return "patient.created";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return null;
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        PatientCreatedDomainEvent that = (PatientCreatedDomainEvent) obj;

        return
            id.equals(that.id) &&
            firstName.equals(that.firstName) &&
            lastName.equals(that.lastName) &&
            status.equals(that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id, 
            firstName,
            lastName,
            status);
    }

}
