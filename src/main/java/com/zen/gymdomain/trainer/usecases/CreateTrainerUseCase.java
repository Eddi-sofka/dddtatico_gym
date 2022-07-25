package com.zen.gymdomain.trainer.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.zen.gymdomain.trainer.Trainer;
import com.zen.gymdomain.trainer.commands.CreateTrainer;

public class CreateTrainerUseCase extends UseCase<RequestCommand<CreateTrainer>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateTrainer> createTrainerRequestCommand) {
        var command = createTrainerRequestCommand.getCommand();

        var trainer = new Trainer(command.getEntityId(), command.getName());

        emit().onResponse(new ResponseEvents(trainer.getUncommittedChanges()));
    }
}
