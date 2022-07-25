package com.zen.gymdomain.trainer.commands;

import co.com.sofka.domain.generic.Command;
import com.zen.gymdomain.trainer.values.ClientID;
import com.zen.gymdomain.trainer.values.Name;
import com.zen.gymdomain.trainer.values.TrainerID;

public class UpdateClientName extends Command {
    private final TrainerID trainerID;
    private final ClientID clientID;
    private final Name name;

    public UpdateClientName(TrainerID trainerID, ClientID clientID, Name name) {
        this.trainerID = trainerID;
        this.clientID = clientID;
        this.name = name;
    }

    public TrainerID getTrainerID() {
        return trainerID;
    }

    public ClientID getClientID() {
        return clientID;
    }

    public Name getName() {
        return name;
    }
}
