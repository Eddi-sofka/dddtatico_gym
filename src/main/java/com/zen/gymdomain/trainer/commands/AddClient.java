package com.zen.gymdomain.trainer.commands;

import co.com.sofka.domain.generic.Command;
import com.zen.gymdomain.trainer.values.FitnessLevel;
import com.zen.gymdomain.trainer.values.Name;
import com.zen.gymdomain.trainer.values.PhoneNumber;
import com.zen.gymdomain.trainer.values.TrainerID;

public class AddClient extends Command {
    private final TrainerID trainerID;
    private final Name name;
    private final FitnessLevel fitnessLevel;
    private final PhoneNumber phoneNumber;

    public AddClient(TrainerID trainerID, Name name, FitnessLevel fitnessLevel, PhoneNumber phoneNumber) {
        this.trainerID = trainerID;
        this.name = name;
        this.fitnessLevel = fitnessLevel;
        this.phoneNumber = phoneNumber;
    }

    public TrainerID getTrainerID() {
        return trainerID;
    }

    public Name getName() {
        return name;
    }

    public FitnessLevel getFitnessLevel() {
        return fitnessLevel;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
