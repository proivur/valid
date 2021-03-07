package com.validtest.shared.domain;

public final class DomainDate extends DateValueObject {

    public DomainDate() {
        super();
    }

    private DomainDate(java.util.Date value) {
        super(value);
    }

    public static DomainDate create(java.util.Date value) {
        DomainDate.validate(value);

        return new DomainDate(value);
    }

    private static void validate(java.util.Date value) {
        String message = "The parameter " + DomainDate.class.getName() + " with value <%s> is invalid";
    }

}
