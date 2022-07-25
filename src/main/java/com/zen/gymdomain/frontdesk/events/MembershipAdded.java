package com.zen.gymdomain.frontdesk.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.frontdesk.values.MembershipID;
import com.zen.gymdomain.frontdesk.values.Price;
import com.zen.gymdomain.frontdesk.values.Tier;

public class MembershipAdded extends DomainEvent {

    private final MembershipID membershipID;
    private final Tier tier;
    private final Price price;

    public MembershipAdded(MembershipID membershipID, Tier tier, Price price) {
        super("com.zen.gymdomain.frontdesk.memebershipadded");
        this.membershipID = membershipID;
        this.tier = tier;
        this.price = price;
    }

    public MembershipID getMembershipID() {
        return membershipID;
    }

    public Tier getTier() {
        return tier;
    }

    public Price getPrice() {
        return price;
    }
}
