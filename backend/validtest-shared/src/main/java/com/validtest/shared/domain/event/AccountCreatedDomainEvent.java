package com.validtest.shared.domain.event;

import com.validtest.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public final class AccountCreatedDomainEvent extends DomainEvent {

    private String id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    private String creationDate;

    public AccountCreatedDomainEvent(String id) {
        super(id);
        this.id = id;
    }

    public AccountCreatedDomainEvent(String id, String firstName, String lastName, String emailAddress, String phoneNumber, String creationDate) {
        super(id);
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.creationDate = creationDate;
    }

    @Override
    public String eventName() {
        return "account.created";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        HashMap<String, Serializable> eventData = new HashMap<>();
        eventData.put("id", this.id);
        eventData.put("firstName", this.firstName);
        eventData.put("lastName", this.lastName);
        eventData.put("emailAddress", this.emailAddress);
        eventData.put("phoneNumber", this.phoneNumber);
        eventData.put("creationDate", this.creationDate);

        return eventData;
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountCreatedDomainEvent that = (AccountCreatedDomainEvent) o;
        return id.equals(that.id) &&
                firstName.equals(that.firstName) &&
                lastName.equals(that.lastName) &&
                emailAddress.equals(that.emailAddress) &&
                phoneNumber.equals(that.phoneNumber) &&
                creationDate.equals(that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, emailAddress, phoneNumber, creationDate);
    }

}
