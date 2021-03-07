package com.validtest.shared.domain.event;

import com.validtest.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public final class AccountUpdatedDomainEvent extends DomainEvent {

    private String id;
    private String clients;
    private String action;

    public AccountUpdatedDomainEvent(String id, String clients) {
        super(id);
        this.id = id;
        this.clients = clients;
    }

    public AccountUpdatedDomainEvent(String id, String clients, String action) {
        super(id);
        this.id = id;
        this.clients = clients;
        this.action = action;
    }

    public String id() {
        return id;
    }

    public String clients() {
        return clients;
    }

    public String action() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String eventName() {
        return "account.updated";
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
        AccountUpdatedDomainEvent that = (AccountUpdatedDomainEvent) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
