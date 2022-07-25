package com.zen.gymdomain.frontdesk.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.frontdesk.values.MembershipID;

public class MembershipRemoved extends DomainEvent {
    private final MembershipID membershipID;

    public MembershipRemoved(MembershipID membershipID) {
        super("com.zen.gymdomain.frontdesk.membershipremoved");
        this.membershipID = membershipID;
    }

    public MembershipID getMembershipID() {
        return membershipID;
    }
}
