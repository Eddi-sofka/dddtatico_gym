package com.zen.gymdomain.trainer.commands;

import co.com.sofka.domain.generic.Command;
import com.zen.gymdomain.trainer.values.ClientID;
import com.zen.gymdomain.trainer.values.TrainerID;

public class RemoveClient extends Command {
    private final TrainerID trainerID;
    private final ClientID clientID;

    public RemoveClient(TrainerID trainerID, ClientID clientID) {
        this.trainerID = trainerID;
        this.clientID = clientID;
    }

    public TrainerID getTrainerID() {
        return trainerID;
    }

    public ClientID getClientID() {
        return clientID;
    }
}
