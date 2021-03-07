package com.validtest.shared.domain;

public class PatientId extends Identifier {

    private PatientId() {
        super();
    }

    private PatientId(String value) {
        super(value);
    }

    public static PatientId create(String value) {
        validate(value, "The parameter " + PatientId.class.getName() + " with value <%s> is invalid");

        return new PatientId(value);
    }

}

