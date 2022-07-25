package com.zen.gymdomain.trainer.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.trainer.values.ClientID;
import com.zen.gymdomain.trainer.values.Name;

public class ClientNameUpdated extends DomainEvent {
    private final ClientID clientID;
    private final Name name;

    public ClientNameUpdated(ClientID clientID, Name name) {
        super("com.zen.gymdomain.trainer.clientnameupdated");
        this.clientID = clientID;
        this.name = name;
    }

    public ClientID getClientID() {
        return clientID;
    }

    public Name getName() {
        return name;
    }
}
