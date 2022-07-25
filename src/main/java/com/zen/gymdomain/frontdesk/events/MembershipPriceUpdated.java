package com.zen.gymdomain.frontdesk.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.frontdesk.values.MembershipID;
import com.zen.gymdomain.frontdesk.values.Price;

public class MembershipPriceUpdated extends DomainEvent {
    private final MembershipID membershipID;
    private final Price price;

    public MembershipPriceUpdated(MembershipID membershipID, Price price) {
        super("com.zen.gymdomain.frontdesk.memebershippriceupdated");
        this.membershipID = membershipID;
        this.price = price;
    }

    public MembershipID getMembershipID() {
        return membershipID;
    }

    public Price getPrice() {
        return price;
    }
}
