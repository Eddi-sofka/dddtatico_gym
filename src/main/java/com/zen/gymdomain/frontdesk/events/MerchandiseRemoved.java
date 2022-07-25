package com.zen.gymdomain.frontdesk.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.frontdesk.values.MerchandiseID;

public class MerchandiseRemoved extends DomainEvent {
    private final MerchandiseID merchandiseID;

    public MerchandiseRemoved(MerchandiseID merchandiseID) {
        super("com.zen.gymdomain.frontdesk.merchandiseremoved");
        this.merchandiseID = merchandiseID;
    }

    public MerchandiseID getMerchandiseID() {
        return merchandiseID;
    }
}
