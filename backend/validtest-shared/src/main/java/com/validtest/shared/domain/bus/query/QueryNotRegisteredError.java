package com.validtest.shared.domain.bus.query;

public final class QueryNotRegisteredError extends Exception {

    public QueryNotRegisteredError(Class<? extends Query> query) {
        super(String.format("The search <%s> hasn't a search handler associated", query.toString()));
    }

}
