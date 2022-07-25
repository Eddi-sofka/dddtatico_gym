package com.zen.gymdomain.trainer.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.trainer.values.Description;

public class RoutineDescriptionUpdated extends DomainEvent {
    private final Description description;

    public RoutineDescriptionUpdated(Description description) {
        super("com.zen.gymdomain.trainer.routinedescriptionupdated");
        this.description = description;
    }

    public Description getDescription() {
        return description;
    }
}
