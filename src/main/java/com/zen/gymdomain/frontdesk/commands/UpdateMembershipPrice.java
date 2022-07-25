package com.zen.gymdomain.frontdesk.commands;

import co.com.sofka.domain.generic.Command;
import com.zen.gymdomain.frontdesk.values.FrontDeskID;
import com.zen.gymdomain.frontdesk.values.MembershipID;
import com.zen.gymdomain.frontdesk.values.Price;

public class UpdateMembershipPrice extends Command {
    private final FrontDeskID frontDeskID;
    private  final MembershipID membershipID;
    private final Price price;

    public UpdateMembershipPrice(FrontDeskID frontDeskID, MembershipID membershipID, Price price) {
        this.frontDeskID = frontDeskID;
        this.membershipID = membershipID;
        this.price = price;
    }

    public FrontDeskID getFrontDeskID() {
        return frontDeskID;
    }

    public MembershipID getMembershipID() {
        return membershipID;
    }

    public Price getPrice() {
        return price;
    }
}
