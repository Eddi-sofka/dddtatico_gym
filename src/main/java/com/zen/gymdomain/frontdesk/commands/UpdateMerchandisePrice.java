package com.zen.gymdomain.frontdesk.commands;

import co.com.sofka.domain.generic.Command;
import com.zen.gymdomain.frontdesk.values.FrontDeskID;
import com.zen.gymdomain.frontdesk.values.MerchandiseID;
import com.zen.gymdomain.frontdesk.values.Price;

public class UpdateMerchandisePrice extends Command {
    private  final FrontDeskID frontDeskID;
    private  final MerchandiseID merchandiseID;
    private  final Price price;

    public UpdateMerchandisePrice(FrontDeskID frontDeskID, MerchandiseID merchandiseID, Price price) {
        this.frontDeskID = frontDeskID;
        this.merchandiseID = merchandiseID;
        this.price = price;
    }

    public FrontDeskID getFrontDeskID() {
        return frontDeskID;
    }

    public MerchandiseID getMerchandiseID() {
        return merchandiseID;
    }

    public Price getPrice() {
        return price;
    }
}
