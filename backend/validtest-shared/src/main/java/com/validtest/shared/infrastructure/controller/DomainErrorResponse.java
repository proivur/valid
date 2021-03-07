package com.validtest.shared.infrastructure.controller;

import com.validtest.shared.domain.bus.query.Response;

public class DomainErrorResponse implements Response {

    private final String errorCode;
    private final String errorMessage;

    public DomainErrorResponse(String errorCode, String errorMessage) {
        this.errorCode    = errorCode;
        this.errorMessage = errorMessage;
    }

    public String errorCode() {
        return errorCode;
    }

    public String errorMessage() {
        return errorMessage;
    }

}
