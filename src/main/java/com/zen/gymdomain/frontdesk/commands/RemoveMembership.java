package com.zen.gymdomain.frontdesk.commands;

import co.com.sofka.domain.generic.Command;
import com.zen.gymdomain.frontdesk.values.FrontDeskID;
import com.zen.gymdomain.frontdesk.values.MembershipID;

public class RemoveMembership extends Command {
    private final FrontDeskID frontDeskID;
    private final MembershipID membershipID;

    public RemoveMembership(FrontDeskID frontDeskID, MembershipID membershipID) {
        this.frontDeskID = frontDeskID;
        this.membershipID = membershipID;
    }

    public FrontDeskID getFrontDeskID() {
        return frontDeskID;
    }

    public MembershipID getMembershipID() {
        return membershipID;
    }
}
