package com.validtest.shared.domain;

public final class EmailAlreadyTaken extends DomainError {

    public EmailAlreadyTaken(Class classRef, String email) {
        super(classRef.getName().toLowerCase() + "_email_exist", String.format("The email <%s> already taken!", email));
    }

}
