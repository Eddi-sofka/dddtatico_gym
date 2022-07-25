package com.zen.gymdomain.trainer.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.trainer.entities.Routine;
import com.zen.gymdomain.trainer.values.Description;
import com.zen.gymdomain.trainer.values.RoutineID;
import com.zen.gymdomain.trainer.values.Type;

public class RoutineAdded extends DomainEvent {

    private final RoutineID routineID;
    private final Description description;
    private final Type type;

    public RoutineAdded(RoutineID routineID, Description description, Type type) {
        super("com.zen.gymdomain.trainer.routineadded");
        this.routineID = routineID;
        this.description = description;
        this.type = type;
    }

    public RoutineID getRoutineID() {
        return routineID;
    }

    public Description getDescription() {
        return description;
    }

    public Type getType() {
        return type;
    }
}
