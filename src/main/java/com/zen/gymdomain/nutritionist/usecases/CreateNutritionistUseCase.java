package com.zen.gymdomain.nutritionist.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.zen.gymdomain.nutritionist.Nutritionist;
import com.zen.gymdomain.nutritionist.usecases.commands.CreateNutritionist;

public class CreateNutritionistUseCase extends UseCase<RequestCommand<CreateNutritionist>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateNutritionist> createNutritionistRequestCommand) {
        var command = createNutritionistRequestCommand.getCommand();

        var nutritionist = new Nutritionist(command.getEntityId(), command.getName());

        emit().onResponse(new ResponseEvents(nutritionist.getUncommittedChanges()));
    }
}
