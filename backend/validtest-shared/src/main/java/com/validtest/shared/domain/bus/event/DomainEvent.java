package com.validtest.shared.domain.bus.event;

import com.validtest.shared.domain.Utils;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.UUID;

public abstract class DomainEvent {
    private String aggregateId;
    private String eventId;
    private String occurredOn;

    protected DomainEvent() {
    }

    public DomainEvent(String aggregateId) {
        this.aggregateId = aggregateId;
        this.eventId = UUID.randomUUID().toString();
        this.occurredOn = Utils.dateToString(LocalDateTime.now());
    }

    public DomainEvent(DomainEventBuilder<?, ?> b) {
        this.aggregateId = b.aggregateId;
        this.eventId = UUID.randomUUID().toString();
        this.occurredOn = Utils.dateToString(LocalDateTime.now());
    }

    public abstract String eventName();

    public abstract HashMap<String, Serializable> toPrimitives();

    public abstract DomainEvent fromPrimitives(
            String aggregateId,
            HashMap<String, Serializable> body,
            String eventId,
            String occurredOn
    );

    public String aggregateId() {
        return aggregateId;
    }

    public String eventId() {
        return eventId;
    }

    public String occurredOn() {
        return occurredOn;
    }


    public static abstract class DomainEventBuilder<C extends DomainEvent, B extends DomainEventBuilder<C, B>> {
        private String aggregateId;
        private String eventId;
        private String occurredOn;

        public B aggregateId(String aggregateId) {
            this.aggregateId = aggregateId;
            return self();
        }

        public B eventId(String eventId) {
            this.eventId = eventId;
            return self();
        }

        public B occurredOn(String occurredOn) {
            this.occurredOn = occurredOn;
            return self();
        }

        protected abstract B self();

        public abstract C build();

        public String toString() {
            return "DomainEvent.DomainEventBuilder(aggregateId=" + this.aggregateId + ", eventId=" + this.eventId + ", occurredOn=" + this.occurredOn + ")";
        }
    }
}
