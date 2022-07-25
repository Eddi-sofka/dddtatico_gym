package com.zen.gymdomain.trainer.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.zen.gymdomain.trainer.Trainer;
import com.zen.gymdomain.trainer.commands.AddRoutine;

public class AddRoutineUseCase extends UseCase<RequestCommand<AddRoutine>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddRoutine> addRoutineRequestCommand) {
        var command = addRoutineRequestCommand.getCommand();
        Trainer trainer = Trainer.from(command.getTrainerID(), repository().getEventsBy(command.getTrainerID().value()));
        
        trainer.addRoutine(command.getDescription(), command.getType());
        emit().onResponse(new ResponseEvents(trainer.getUncommittedChanges()));

    }
}
