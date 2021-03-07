package com.validtest.shared.domain;

public final class DomainObjectNotExist extends DomainError {

    public DomainObjectNotExist(Class classRef, String id) {
        super(classRef.getName() + "_not_exist", String.format("The " + classRef .getName() + " <%s> doesn't exist", id));
    }

}
