package com.zen.gymdomain.frontdesk.entities;

import co.com.sofka.domain.generic.Entity;
import com.zen.gymdomain.frontdesk.values.MerchandiseID;
import com.zen.gymdomain.frontdesk.values.Price;
import com.zen.gymdomain.frontdesk.values.Product;

public class Merchandise extends Entity<MerchandiseID> {
    protected Product product;
    protected Price price;
    public Merchandise(MerchandiseID entityId, Product product, Price price) {
        super(entityId);
        this.product = product;
        this.price = price;
    }

    public Product product() {
        return product;
    }

    public void updateProduct(Product product) {
        this.product = product;
    }

    public Price price() {
        return price;
    }

    public void updatePrice(Price price) {
        this.price = price;
    }
}
