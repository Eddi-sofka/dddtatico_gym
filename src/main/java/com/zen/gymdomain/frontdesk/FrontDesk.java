package com.zen.gymdomain.frontdesk;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.frontdesk.entities.Membership;
import com.zen.gymdomain.frontdesk.entities.Merchandise;
import com.zen.gymdomain.frontdesk.events.*;
import com.zen.gymdomain.frontdesk.values.*;
import com.zen.gymdomain.trainer.values.Name;

import java.util.List;
import java.util.Set;

public class FrontDesk extends AggregateEvent<FrontDeskID> {
    protected Set<Merchandise> merchandiseSet;
    protected Set<Membership> membershipSet;
    protected Name name;
    public FrontDesk(FrontDeskID entityId, Name name) {
        super(entityId);
        appendChange(new FrontDeskCreated(name)).apply();

    }
    private FrontDesk(FrontDeskID entityId) {
        super(entityId);
        subscribe(new FrontDeskChange(this));
    }

    public static FrontDesk from(FrontDeskID frontDeskID, List<DomainEvent> domainEvents) {
        FrontDesk frontDesk = new FrontDesk(frontDeskID);
        domainEvents.forEach(frontDesk::applyEvent);
        return frontDesk;
    }

//    events
    public void addMembership(Tier tier, Price price) {
        MembershipID membershipID = new MembershipID();
        appendChange(new MembershipAdded(membershipID, tier, price)).apply();
    }

    public void removeMembership(MembershipID membershipID) {
        appendChange(new MembershipRemoved(membershipID)).apply();
    }

    public void updateMembershipTier(MembershipID membershipID, Tier tier) {
        appendChange(new MembershipTierUpdated(membershipID, tier)).apply();
    }

    public void updateMembershipPrice(MembershipID membershipID, Price price) {
        appendChange(new MembershipPriceUpdated(membershipID, price)).apply();
    }

    public void addMerchandise(Product product, Price price) {
        MerchandiseID entityId = new MerchandiseID();
        appendChange(new MerchandiseAdded(entityId, product, price)).apply();
    }

    public void removeMerchandise(MerchandiseID merchandiseID) {
        appendChange(new MerchandiseRemoved(merchandiseID)).apply();
    }

    public void updateMerchandiseProduct(MerchandiseID merchandiseID, Product product) {
        appendChange(new MerchandiseProductUpdated(merchandiseID, product)).apply();
    }

    public void updateMerchandisePrice(MerchandiseID merchandiseID, Price price) {
        appendChange(new MerchandisePriceUpdated(merchandiseID, price)).apply();
    }
}
