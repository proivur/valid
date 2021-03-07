package com.validtest.shared.domain;

public class LastName extends Name {

    private LastName() {
        super();
    }

    private LastName(String value) {
        super(value);
    }

    public static LastName create(String value) {
        validate(value);

        return new LastName(value);
    }

}
