package com.zen.gymdomain.trainer.commands;

import co.com.sofka.domain.generic.Command;
import com.zen.gymdomain.trainer.values.IsCompleted;
import com.zen.gymdomain.trainer.values.TrainerID;

public class UpdateRoutineIsCompleted extends Command {
    private final TrainerID trainerID;
    private final IsCompleted isCompleted;

    public UpdateRoutineIsCompleted(TrainerID trainerID, IsCompleted isCompleted) {
        this.trainerID = trainerID;
        this.isCompleted = isCompleted;
    }

    public TrainerID getTrainerID() {
        return trainerID;
    }

    public IsCompleted getIsCompleted() {
        return isCompleted;
    }
}
