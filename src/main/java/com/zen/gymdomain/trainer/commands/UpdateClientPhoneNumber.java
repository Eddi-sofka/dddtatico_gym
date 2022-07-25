package com.zen.gymdomain.trainer.commands;

import co.com.sofka.domain.generic.Command;
import com.zen.gymdomain.trainer.values.ClientID;
import com.zen.gymdomain.trainer.values.PhoneNumber;
import com.zen.gymdomain.trainer.values.TrainerID;

public class UpdateClientPhoneNumber extends Command {
    private final TrainerID trainerID;
    private final ClientID clientID;
    private final PhoneNumber phoneNumber;

    public UpdateClientPhoneNumber(TrainerID trainerID, ClientID clientID, PhoneNumber phoneNumber) {
        this.trainerID = trainerID;
        this.clientID = clientID;
        this.phoneNumber = phoneNumber;
    }

    public TrainerID getTrainerID() {
        return trainerID;
    }

    public ClientID getClientID() {
        return clientID;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
