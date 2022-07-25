package com.zen.gymdomain.frontdesk.values;

import co.com.sofka.domain.generic.Identity;

public class FrontDeskID extends Identity {
    public FrontDeskID() {
    }

    private FrontDeskID(String id) {
        super(id);
    }

    public static FrontDeskID of(String id) {
        return new FrontDeskID(id);
    }
}
