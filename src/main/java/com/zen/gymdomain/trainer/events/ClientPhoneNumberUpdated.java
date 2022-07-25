package com.zen.gymdomain.trainer.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.trainer.values.ClientID;
import com.zen.gymdomain.trainer.values.PhoneNumber;

public class ClientPhoneNumberUpdated extends DomainEvent {
    private final ClientID clientID;
    private final PhoneNumber phoneNumber;

    public ClientPhoneNumberUpdated(ClientID clientID, PhoneNumber phoneNumber) {
        super("com.zen.gymdomain.trainer.clientphonenumberupdated");
        this.clientID = clientID;
        this.phoneNumber = phoneNumber;
    }

    public ClientID getClientID() {
        return clientID;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
