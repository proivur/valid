package com.validtest.shared.infrastructure.bus.query;

import com.validtest.shared.domain.Service;
import com.validtest.shared.domain.bus.query.*;
import org.springframework.context.ApplicationContext;

@Service
public final class InMemoryQueryBus implements QueryBus {

    private final QueryHandlersInformation information;
    private final ApplicationContext context;

    public InMemoryQueryBus(QueryHandlersInformation information, ApplicationContext context) {
        this.information = information;
        this.context     = context;
    }

    @Override
    public Response ask(Query query) throws QueryHandlerExecutionError {
        try {
            Class<? extends QueryHandler> queryHandlerClass = information.search(query.getClass());

            QueryHandler handler = context.getBean(queryHandlerClass);

            return handler.handle(query);
        } catch (Throwable error) {
            // ENABLE LOG TODO log.error("Error handling query = '"+query+"'",error);
            throw new QueryHandlerExecutionError(error);
        }
    }

}
