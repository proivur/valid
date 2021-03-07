package com.validtest.shared.domain;

public final class DomainObjectAlreadyExist extends DomainError {

    public DomainObjectAlreadyExist(Class classRef, String id) {
        super(classRef.getName() + "_exist", String.format("The " + classRef.getSimpleName() + " <%s> already exist", id));
    }

}
