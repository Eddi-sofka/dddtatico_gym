package com.zen.gymdomain.trainer.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.zen.gymdomain.trainer.Trainer;
import com.zen.gymdomain.trainer.commands.UpdateClientPhoneNumber;

public class UpdateClientPhoneNumberUseCase extends UseCase<RequestCommand<UpdateClientPhoneNumber>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateClientPhoneNumber> updateClientPhoneNumberRequestCommand) {
        var command = updateClientPhoneNumberRequestCommand.getCommand();
        Trainer trainer = Trainer.from(command.getTrainerID(), repository().getEventsBy(command.getTrainerID().value()));

        trainer.updateClientPhoneNumber(command.getClientID(), command.getPhoneNumber());
        emit().onResponse(new ResponseEvents(trainer.getUncommittedChanges()));
    }
}
