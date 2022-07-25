package com.zen.gymdomain.frontdesk.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.frontdesk.values.MembershipID;
import com.zen.gymdomain.frontdesk.values.Tier;

public class MembershipTierUpdated extends DomainEvent {
    private final MembershipID membershipID;
    private final Tier tier;

    public MembershipTierUpdated(MembershipID membershipID, Tier tier) {
        super("com.zen.gymdomain.frontdesk.membershiptierupdated");
        this.membershipID = membershipID;
        this.tier = tier;
    }

    public MembershipID getMembershipID() {
        return membershipID;
    }

    public Tier getTier() {
        return tier;
    }
}
