package com.zen.gymdomain.trainer.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.trainer.values.ClientID;
import com.zen.gymdomain.trainer.values.FitnessLevel;

public class ClientFitnessLevelUpdated extends DomainEvent {
    private final ClientID clientID;
    private final FitnessLevel fitnessLevel;

    public ClientFitnessLevelUpdated(ClientID clientID, FitnessLevel fitnessLevel) {
        super("com.zen.gymdomain.trainer.clientfitnesslevelupdated");

        this.clientID = clientID;
        this.fitnessLevel = fitnessLevel;
    }

    public ClientID getClientID() {
        return clientID;
    }

    public FitnessLevel getFitnessLevel() {
        return fitnessLevel;
    }
}
