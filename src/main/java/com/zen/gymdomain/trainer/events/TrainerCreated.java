package com.zen.gymdomain.trainer.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.trainer.values.Name;
import com.zen.gymdomain.trainer.values.TrainerID;

public class TrainerCreated extends DomainEvent {
    private final Name name;


    public TrainerCreated(Name name) {
        super("com.zen.gymdomain.trainer.trainercreated");
        this.name = name;
    }


    public Name getName() {
        return this.name;
    }
}
