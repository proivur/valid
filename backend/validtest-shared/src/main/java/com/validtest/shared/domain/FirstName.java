package com.validtest.shared.domain;

public class FirstName extends Name {

    private FirstName() {
        super();
    }

    private FirstName(String value) {
        super(value);
    }

    public static FirstName create(String value) {
        validate(value);

        return new FirstName(value);
    }

}
