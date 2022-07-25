package com.zen.gymdomain.frontdesk.commands;

import co.com.sofka.domain.generic.Command;
import com.zen.gymdomain.frontdesk.values.FrontDeskID;
import com.zen.gymdomain.frontdesk.values.MerchandiseID;

public class RemoveMerchandise extends Command {
    private final FrontDeskID frontDeskID;
    private final MerchandiseID merchandiseID;

    public RemoveMerchandise(FrontDeskID frontDeskID, MerchandiseID merchandiseID) {
        this.frontDeskID = frontDeskID;
        this.merchandiseID = merchandiseID;
    }

    public FrontDeskID getFrontDeskID() {
        return frontDeskID;
    }

    public MerchandiseID getMerchandiseID() {
        return merchandiseID;
    }
}
