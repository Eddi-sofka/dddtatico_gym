package com.zen.gymdomain.frontdesk.commands;

import co.com.sofka.domain.generic.Command;
import com.zen.gymdomain.frontdesk.entities.Merchandise;
import com.zen.gymdomain.frontdesk.values.FrontDeskID;
import com.zen.gymdomain.frontdesk.values.Price;
import com.zen.gymdomain.frontdesk.values.Product;

public class AddMerchandise extends Command {
    private final FrontDeskID frontDeskID;
    private final Product product;
    private final Price price;

    public AddMerchandise(FrontDeskID frontDeskID, Product product, Price price) {
        this.frontDeskID = frontDeskID;
        this.product = product;
        this.price = price;
    }

    public FrontDeskID getFrontDeskID() {
        return frontDeskID;
    }

    public Product getProduct() {
        return product;
    }

    public Price getPrice() {
        return price;
    }
}
