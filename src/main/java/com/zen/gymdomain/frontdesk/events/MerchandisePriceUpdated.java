package com.zen.gymdomain.frontdesk.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.frontdesk.values.MerchandiseID;
import com.zen.gymdomain.frontdesk.values.Price;

public class MerchandisePriceUpdated extends DomainEvent {
    private final MerchandiseID merchandiseID;
    private final Price price;

    public MerchandisePriceUpdated(MerchandiseID merchandiseID, Price price) {
        super("com.zen.gymdomain.frontdesk.merchandisepriceupdated");
        this.merchandiseID = merchandiseID;
        this.price = price;
    }

    public MerchandiseID getMerchandiseID() {
        return merchandiseID;
    }

    public Price getPrice() {
        return price;
    }
}
