package com.zen.gymdomain.trainer.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.zen.gymdomain.trainer.Trainer;
import com.zen.gymdomain.trainer.commands.RemoveClient;

public class RemoveClientUseCase extends UseCase<RequestCommand<RemoveClient>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<RemoveClient> removeClientRequestCommand) {
        var command = removeClientRequestCommand.getCommand();
        Trainer trainer = Trainer.from(command.getTrainerID(), repository().getEventsBy(command.getTrainerID().value()));

        trainer.removeClient(command.getClientID());
        emit().onResponse(new ResponseEvents(trainer.getUncommittedChanges()));
    }
}
