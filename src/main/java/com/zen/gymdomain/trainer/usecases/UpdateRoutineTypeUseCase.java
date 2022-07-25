package com.zen.gymdomain.trainer.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.zen.gymdomain.trainer.Trainer;
import com.zen.gymdomain.trainer.commands.UpdateRoutineType;

public class UpdateRoutineTypeUseCase extends UseCase<RequestCommand<UpdateRoutineType>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateRoutineType> updateRoutineTypeRequestCommand) {
        var command = updateRoutineTypeRequestCommand.getCommand();
        Trainer trainer = Trainer.from(command.getTrainerID(), repository().getEventsBy(command.getTrainerID().value()));
        trainer.updateRoutineType(command.getType());
        emit().onResponse(new ResponseEvents(trainer.getUncommittedChanges()));
    }
}
