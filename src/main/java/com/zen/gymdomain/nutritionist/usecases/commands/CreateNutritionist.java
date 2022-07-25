package com.zen.gymdomain.nutritionist.usecases.commands;

import co.com.sofka.domain.generic.Command;
import com.zen.gymdomain.nutritionist.entities.Patient;
import com.zen.gymdomain.nutritionist.values.NutritionistID;
import com.zen.gymdomain.trainer.values.Name;

import java.util.Set;

public class CreateNutritionist extends Command {
    private final NutritionistID entityId;
    private final Name name;

    public CreateNutritionist(NutritionistID entityId, Name name) {
        this.entityId = entityId;
        this.name = name;
    }

    public NutritionistID getEntityId() {
        return entityId;
    }

    public Name getName() {
        return name;
    }
}
