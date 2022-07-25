package com.zen.gymdomain.trainer.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.zen.gymdomain.trainer.Trainer;
import com.zen.gymdomain.trainer.commands.UpdateClientFitnessLevel;

public class UpdateClientFitnessLevelUseCase extends UseCase<RequestCommand<UpdateClientFitnessLevel>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateClientFitnessLevel> updateClientFitnessLevelRequestCommand) {
        var command = updateClientFitnessLevelRequestCommand.getCommand();
        Trainer trainer = Trainer.from(command.getTrainerID(), repository().getEventsBy(command.getTrainerID().value()));

        trainer.updateClientFitnessLevel(command.getClientID(), command.getFitnessLevel());
        emit().onResponse(new ResponseEvents(trainer.getUncommittedChanges()));

    }
}
