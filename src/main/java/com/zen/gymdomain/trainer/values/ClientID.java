package com.zen.gymdomain.trainer.values;

import co.com.sofka.domain.generic.Identity;

public class ClientID extends Identity {
    public ClientID() {
    }

    private ClientID(String id) {
        super(id);
    }

    public static ClientID of(String id) {
        return new ClientID(id);
    }
}
