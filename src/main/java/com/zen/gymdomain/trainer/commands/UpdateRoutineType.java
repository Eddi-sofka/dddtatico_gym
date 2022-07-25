package com.zen.gymdomain.trainer.commands;

import co.com.sofka.domain.generic.Command;
import com.zen.gymdomain.trainer.values.TrainerID;
import com.zen.gymdomain.trainer.values.Type;

public class UpdateRoutineType extends Command {
    private final TrainerID trainerID;
    private final Type type;

    public UpdateRoutineType(TrainerID trainerID, Type type) {
        this.trainerID = trainerID;
        this.type = type;
    }

    public TrainerID getTrainerID() {
        return trainerID;
    }

    public Type getType() {
        return type;
    }
}
