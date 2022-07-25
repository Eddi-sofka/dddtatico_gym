package com.zen.gymdomain.frontdesk.values;

import co.com.sofka.domain.generic.Identity;

public class MembershipID extends Identity {
    public MembershipID() {
    }

    private MembershipID(String id) {
        super(id);
    }

    public static MembershipID of(String id) {
        return new MembershipID(id);
    }
}
