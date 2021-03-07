package com.validtest.shared.domain;

public final class RecordStatus extends StringValueObject {

    public static final String ACTIVE = "A";
    public static final String DISABLED = "D";
    public static final String RETIRED = "R";
    public static final String DRAFT = "DRAFT";
    public static final String SUBMIT = "SUBMIT";
    public static final String ASSIGNED = "ASSIGNED";
    public static final String COMPLETED = "COMPLETED";
    public static final String SUBMITTED = "SUBMITTED";

    public RecordStatus() {
    }

    private RecordStatus(String value) {
        super(value);
    }

    public static RecordStatus create(String value) {
        RecordStatus.validate(value);

        return new RecordStatus(value);
    }

    private static void validate(String value) {
        String message = "The parameter " + RecordStatus.class.getName() + " with value <%s> is invalid";
    }

}

