package com.zen.gymdomain.frontdesk.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.zen.gymdomain.frontdesk.FrontDesk;
import com.zen.gymdomain.frontdesk.commands.CreateFrontDesk;

public class CreateFrontDeskUseCase extends UseCase<RequestCommand<CreateFrontDesk>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateFrontDesk> createFrontDeskRequestCommand) {
        var command = createFrontDeskRequestCommand.getCommand();
        var frontDesk = new FrontDesk(command.getEntityId(), command.getName());
        emit().onResponse(new ResponseEvents(frontDesk.getUncommittedChanges()));
    }
}