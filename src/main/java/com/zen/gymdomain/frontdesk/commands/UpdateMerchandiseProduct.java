package com.zen.gymdomain.frontdesk.commands;

import co.com.sofka.domain.generic.Command;
import com.zen.gymdomain.frontdesk.values.FrontDeskID;
import com.zen.gymdomain.frontdesk.values.MerchandiseID;
import com.zen.gymdomain.frontdesk.values.Product;

public class UpdateMerchandiseProduct extends Command {
    private final FrontDeskID frontDeskID;
    private final MerchandiseID merchandiseID;
    private final Product product;

    public UpdateMerchandiseProduct(FrontDeskID frontDeskID, MerchandiseID merchandiseID, Product product) {
        this.frontDeskID = frontDeskID;
        this.merchandiseID = merchandiseID;
        this.product = product;
    }

    public FrontDeskID getFrontDeskID() {
        return frontDeskID;
    }

    public MerchandiseID getMerchandiseID() {
        return merchandiseID;
    }

    public Product getProduct() {
        return product;
    }
}
