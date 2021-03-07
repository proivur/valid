package com.validtest.shared.infrastructure.controller.spring;

import com.validtest.shared.domain.bus.query.Query;
import com.validtest.shared.domain.bus.query.QueryBus;
import com.validtest.shared.domain.bus.query.QueryHandlerExecutionError;

public abstract class QueryBusApiController implements ApiController {

    private final QueryBus queryBus;

    public QueryBusApiController(QueryBus queryBus) {
        this.queryBus   = queryBus;
    }

    protected <R> R ask(Query query) throws QueryHandlerExecutionError {
        return queryBus.ask(query);
    }

}
