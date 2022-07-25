package com.zen.gymdomain.trainer.commands;

import co.com.sofka.domain.generic.Command;
import com.zen.gymdomain.trainer.entities.Routine;
import com.zen.gymdomain.trainer.values.Name;
import com.zen.gymdomain.trainer.values.TrainerID;

public class CreateTrainer extends Command {
    private final TrainerID entityId;
    private final Name name;

    public CreateTrainer(TrainerID entityId, Name name) {
        this.entityId = entityId;
        this.name = name;
    }

    public TrainerID getEntityId() {
        return entityId;
    }

    public Name getName() {
        return name;
    }
}
