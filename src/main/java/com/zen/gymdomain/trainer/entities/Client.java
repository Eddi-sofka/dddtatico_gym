package com.zen.gymdomain.trainer.entities;

import co.com.sofka.domain.generic.Entity;
import com.zen.gymdomain.trainer.values.ClientID;
import com.zen.gymdomain.trainer.values.FitnessLevel;
import com.zen.gymdomain.trainer.values.Name;
import com.zen.gymdomain.trainer.values.PhoneNumber;

import java.util.Objects;

public class Client extends Entity<ClientID> {

    private FitnessLevel fitnessLevel;
    private Name name;
    private PhoneNumber phoneNumber;
    public Client(ClientID entityId, Name name, FitnessLevel fitnessLevel, PhoneNumber phoneNumber) {
        super(entityId);
        this.name = name;
        this.fitnessLevel = fitnessLevel;
        this.phoneNumber = phoneNumber;
    }


    public FitnessLevel getFitnessLevel() {
        return fitnessLevel;
    }

    public void updateFitnessLevel(FitnessLevel fitnessLevel) {
        this.fitnessLevel = Objects.requireNonNull(fitnessLevel);
    }

    public Name getName() {
        return name;
    }

    public void updateName(Name name) {
        this.name = Objects.requireNonNull(name);
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void updatePhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = Objects.requireNonNull(phoneNumber);
    }
}
