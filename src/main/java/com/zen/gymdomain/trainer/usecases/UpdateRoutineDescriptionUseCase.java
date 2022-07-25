package com.zen.gymdomain.trainer.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.zen.gymdomain.trainer.Trainer;
import com.zen.gymdomain.trainer.commands.UpdateRoutineDescription;

public class UpdateRoutineDescriptionUseCase extends UseCase<RequestCommand<UpdateRoutineDescription>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateRoutineDescription> updateRoutineDescriptionRequestCommand) {
        var command = updateRoutineDescriptionRequestCommand.getCommand();
        Trainer trainer = Trainer.from(command.getTrainerID(), repository().getEventsBy(command.getTrainerID().value()));
        trainer.updateRoutineDescription(command.getDescription());
        emit().onResponse(new ResponseEvents(trainer.getUncommittedChanges()));
    }
}
