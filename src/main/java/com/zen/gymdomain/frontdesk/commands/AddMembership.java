package com.zen.gymdomain.frontdesk.commands;

import co.com.sofka.domain.generic.Command;
import com.zen.gymdomain.frontdesk.entities.Membership;
import com.zen.gymdomain.frontdesk.values.FrontDeskID;
import com.zen.gymdomain.frontdesk.values.Price;
import com.zen.gymdomain.frontdesk.values.Tier;

public class AddMembership extends Command {
    private final FrontDeskID frontDeskID;
    private final Tier tier;
    private final Price price;

    public AddMembership(FrontDeskID frontDeskID, Tier tier, Price price) {

        this.frontDeskID = frontDeskID;
        this.tier = tier;
        this.price = price;
    }

    public FrontDeskID getFrontDeskID() {
        return frontDeskID;
    }

    public Tier getTier() {
        return tier;
    }

    public Price getPrice() {
        return price;
    }
}
