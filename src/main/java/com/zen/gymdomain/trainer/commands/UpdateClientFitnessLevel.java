package com.zen.gymdomain.trainer.commands;

import co.com.sofka.domain.generic.Command;
import com.zen.gymdomain.trainer.values.ClientID;
import com.zen.gymdomain.trainer.values.FitnessLevel;
import com.zen.gymdomain.trainer.values.TrainerID;

public class UpdateClientFitnessLevel extends Command {
    private final TrainerID trainerID;
    private  final ClientID clientID;
    private final FitnessLevel fitnessLevel;

    public UpdateClientFitnessLevel(TrainerID trainerID, ClientID clientID, FitnessLevel fitnessLevel) {
        this.trainerID = trainerID;
        this.clientID = clientID;
        this.fitnessLevel = fitnessLevel;
    }

    public TrainerID getTrainerID() {
        return trainerID;
    }

    public ClientID getClientID() {
        return clientID;
    }

    public FitnessLevel getFitnessLevel() {
        return fitnessLevel;
    }
}
