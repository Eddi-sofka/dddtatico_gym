package com.zen.gymdomain.trainer.commands;

import co.com.sofka.domain.generic.Command;
import com.zen.gymdomain.trainer.values.Description;
import com.zen.gymdomain.trainer.values.TrainerID;

public class UpdateRoutineDescription extends Command {
    private final TrainerID trainerID;
    private final Description description;

    public UpdateRoutineDescription(TrainerID trainerID, Description description) {
        this.trainerID = trainerID;
        this.description = description;
    }

    public TrainerID getTrainerID() {
        return trainerID;
    }

    public Description getDescription() {
        return description;
    }
}

