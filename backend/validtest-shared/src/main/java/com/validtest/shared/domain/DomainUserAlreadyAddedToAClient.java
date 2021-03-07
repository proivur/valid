package com.validtest.shared.domain;

public final class DomainUserAlreadyAddedToAClient extends DomainError {

    public DomainUserAlreadyAddedToAClient(Class classRef, String id) {
        super(classRef.getSimpleName() + "_exist", String.format("The user to be registered in " + classRef.getSimpleName() + ", is currently assigned to the client: <%s>", id));
    }

}
