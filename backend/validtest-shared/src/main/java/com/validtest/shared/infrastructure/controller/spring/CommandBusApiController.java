package com.validtest.shared.infrastructure.controller.spring;

import com.validtest.shared.domain.bus.command.Command;
import com.validtest.shared.domain.bus.command.CommandBus;
import com.validtest.shared.domain.bus.command.CommandHandlerExecutionError;

public abstract class CommandBusApiController implements ApiController {

    private final CommandBus commandBus;

    public CommandBusApiController(CommandBus commandBus) {
        this.commandBus   = commandBus;
    }

    protected void dispatch(Command command) throws CommandHandlerExecutionError {
        commandBus.dispatch(command);
    }

}
