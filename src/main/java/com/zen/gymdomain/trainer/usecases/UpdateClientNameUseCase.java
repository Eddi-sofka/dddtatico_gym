package com.zen.gymdomain.trainer.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.zen.gymdomain.trainer.Trainer;
import com.zen.gymdomain.trainer.commands.UpdateClientName;

public class UpdateClientNameUseCase extends UseCase<RequestCommand<UpdateClientName>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateClientName> updateClientNameRequestCommand) {
        var command = updateClientNameRequestCommand.getCommand();
        Trainer trainer = Trainer.from(command.getTrainerID(), repository().getEventsBy(command.getTrainerID().value()));
        trainer.updateClientName(command.getClientID(), command.getName());
        emit().onResponse(new ResponseEvents(trainer.getUncommittedChanges()));
    }
}
