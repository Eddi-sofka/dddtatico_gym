package com.zen.gymdomain.frontdesk.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.frontdesk.values.MerchandiseID;
import com.zen.gymdomain.frontdesk.values.Product;

public class MerchandiseProductUpdated extends DomainEvent {
    private final MerchandiseID merchandiseID;
    private final Product product;

    public MerchandiseProductUpdated(MerchandiseID
                                             merchandiseID, Product product) {
        super("com.zen.gymdomain.frontdesk.merchandiseproductupdated");
        this.merchandiseID = merchandiseID;
        this.product = product;
    }

    public MerchandiseID getMerchandiseID() {
        return merchandiseID;
    }

    public Product getProduct() {
        return product;
    }
}
