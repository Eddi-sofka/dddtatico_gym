package com.zen.gymdomain.trainer.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.trainer.values.ClientID;
import com.zen.gymdomain.trainer.values.FitnessLevel;
import com.zen.gymdomain.trainer.values.Name;
import com.zen.gymdomain.trainer.values.PhoneNumber;

public class ClientAdded extends DomainEvent {

    private final ClientID clientID;
    private final Name name;
    private final FitnessLevel fitnessLevel;
    private final PhoneNumber phoneNumber;

    public ClientAdded(ClientID clientID, Name name, FitnessLevel fitnessLevel, PhoneNumber phoneNumber) {
        super("com.zen.gymdomain.trainer.clientadded");
        this.clientID = clientID;
        this.name = name;
        this.fitnessLevel = fitnessLevel;
        this.phoneNumber = phoneNumber;
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

    public ClientID getClientID() {
        return clientID;
    }
}
