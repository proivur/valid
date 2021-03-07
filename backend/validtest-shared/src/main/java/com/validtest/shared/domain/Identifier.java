package com.validtest.shared.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public abstract class Identifier implements Serializable {
    final protected String value;

    protected static void validate(String value, String message)
    {
        try {
            ensureValidUuid(value);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException(String.format(message, value), e);
        }
    }

    public Identifier(String value) {
        ensureValidUuid(value);

        this.value = value;
    }

    protected Identifier() {
        this.value = null;
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Identifier that = (Identifier) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    private static  void ensureValidUuid(String value) throws IllegalArgumentException {
        Optional.ofNullable(value).orElseThrow(()-> new IllegalArgumentException("null is not a valid UUID"));
        UUID.fromString(value);
    }
}
