package com.zen.gymdomain.frontdesk.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.frontdesk.values.MerchandiseID;
import com.zen.gymdomain.frontdesk.values.Price;
import com.zen.gymdomain.frontdesk.values.Product;

public class MerchandiseAdded extends DomainEvent {

    private final MerchandiseID merchandiseID;
    private final Product product;
    private final Price price;

    public MerchandiseAdded(MerchandiseID merchandiseID, Product product, Price price) {
        super("com.zen.gymdomain.frontdesk.merchandiseadded");
        this.merchandiseID = merchandiseID;
        this.product = product;
        this.price = price;
    }

    public MerchandiseID getMerchandiseID() {
        return merchandiseID;
    }

    public Product getProduct() {
        return product;
    }

    public Price getPrice() {
        return price;
    }
}
