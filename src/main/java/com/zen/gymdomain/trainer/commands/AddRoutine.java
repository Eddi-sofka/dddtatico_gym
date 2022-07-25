package com.zen.gymdomain.trainer.commands;

import co.com.sofka.domain.generic.Command;
import com.zen.gymdomain.trainer.values.Description;
import com.zen.gymdomain.trainer.values.TrainerID;
import com.zen.gymdomain.trainer.values.Type;

public class AddRoutine extends Command {
    private final TrainerID trainerID;
    private final Description description;
    private final Type type;

    public AddRoutine(TrainerID trainerID, Description description, Type type) {
        this.trainerID = trainerID;
        this.description = description;
        this.type = type;
    }

    public TrainerID getTrainerID() {
        return trainerID;
    }

    public Description getDescription() {
        return description;
    }

    public Type getType() {
        return type;
    }
}
