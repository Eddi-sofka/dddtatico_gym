package com.zen.gymdomain.frontdesk.values;

import co.com.sofka.domain.generic.Identity;

public class MerchandiseID extends Identity {
    public MerchandiseID() {
    }

    private MerchandiseID(String id) {
        super(id);
    }

    public static MerchandiseID of(String id) {
        return new MerchandiseID(id);
    }
}
