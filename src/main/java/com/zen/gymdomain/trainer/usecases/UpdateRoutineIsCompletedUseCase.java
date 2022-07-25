package com.zen.gymdomain.trainer.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.zen.gymdomain.trainer.Trainer;
import com.zen.gymdomain.trainer.commands.UpdateRoutineIsCompleted;

public class UpdateRoutineIsCompletedUseCase extends UseCase<RequestCommand<UpdateRoutineIsCompleted>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateRoutineIsCompleted> updateRoutineIsCompletedRequestCommand) {
        var command = updateRoutineIsCompletedRequestCommand.getCommand();
        Trainer trainer = Trainer.from(command.getTrainerID(), repository().getEventsBy(command.getTrainerID().value()));
        trainer.updateRoutineIsCompleted(command.getIsCompleted());
        emit().onResponse(new ResponseEvents(trainer.getUncommittedChanges()));
    }
}
