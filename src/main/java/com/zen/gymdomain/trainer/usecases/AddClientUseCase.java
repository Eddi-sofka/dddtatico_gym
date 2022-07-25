package com.zen.gymdomain.trainer.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.zen.gymdomain.trainer.Trainer;
import com.zen.gymdomain.trainer.commands.AddClient;

public class AddClientUseCase extends UseCase<RequestCommand<AddClient>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddClient> addClientRequestCommand) {
        var command = addClientRequestCommand.getCommand();
        Trainer trainer = Trainer.from(command.getTrainerID(), repository().getEventsBy(command.getTrainerID().value()));

        trainer.addClient(command.getName(), command.getFitnessLevel(), command.getPhoneNumber());

        emit().onResponse(new ResponseEvents(trainer.getUncommittedChanges()));

    }
}
