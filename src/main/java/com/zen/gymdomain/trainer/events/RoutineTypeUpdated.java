package com.zen.gymdomain.trainer.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.trainer.values.Type;

public class RoutineTypeUpdated extends DomainEvent {
    private final Type type;

    public RoutineTypeUpdated(Type type) {
        super("com.zen.gymdomain.trainer.routinetypeupdated");
        this.type = type;
    }

    public Type getType() {
        return type;
    }
}
