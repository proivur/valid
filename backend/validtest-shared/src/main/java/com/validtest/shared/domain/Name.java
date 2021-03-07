package com.validtest.shared.domain;

public class Name extends StringValueObject {

    public Name() {
    }

    protected Name(String value) {
        super(value);
    }

    public static Name create(String value) {
        Name.validate(value);

        return new Name(value);
    }

    protected static void validate(String value) {
        String message = "The parameter " + Name.class.getName() + " with value <%s> is invalid";
    }

}
