package com.validtest.shared.domain.event;

import com.validtest.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public final class AccountDeletedDomainEvent extends DomainEvent {

    private String id;

    public AccountDeletedDomainEvent(String id) {
        super(id);
        this.id = id;
    }

    public String id() {
        return id;
    }

    @Override
    public String eventName() {
        return "account.deleted";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        HashMap<String, Serializable> eventData = new HashMap<>();
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
        AccountDeletedDomainEvent that = (AccountDeletedDomainEvent) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
