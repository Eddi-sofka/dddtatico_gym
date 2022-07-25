package com.zen.gymdomain.frontdesk.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.trainer.values.Name;

public class FrontDeskCreated extends DomainEvent {

    private final Name name;

    public FrontDeskCreated(Name name) {
        super("com.zen.gymdomain.frontdesk.frontdeskcreated");
        this.name = name;
    }


    public Name getName() {
        return name;
    }
}
