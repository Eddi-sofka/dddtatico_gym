package com.zen.gymdomain.frontdesk.entities;

import co.com.sofka.domain.generic.Entity;
import com.zen.gymdomain.frontdesk.values.MembershipID;
import com.zen.gymdomain.frontdesk.values.Price;
import com.zen.gymdomain.frontdesk.values.Tier;

import java.util.Objects;

public class Membership extends Entity<MembershipID> {
    protected Tier tier;
    protected Price price;
    public Membership(MembershipID entityId, Tier tier, Price price) {
        super(entityId);
        this.tier = tier;
        this.price = price;
    }

    public Tier tier() {
        return tier;
    }

    public void updateTier(Tier tier) {
        this.tier = Objects.requireNonNull(tier);
    }

    public Price price() {
        return price;
    }

    public void updatePrice(Price price) {
        this.price = Objects.requireNonNull(price);
    }
}
