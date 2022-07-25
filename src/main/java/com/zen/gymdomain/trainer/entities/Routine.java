package com.zen.gymdomain.trainer.entities;

import co.com.sofka.domain.generic.Entity;
import com.zen.gymdomain.trainer.values.Description;
import com.zen.gymdomain.trainer.values.IsCompleted;
import com.zen.gymdomain.trainer.values.RoutineID;
import com.zen.gymdomain.trainer.values.Type;

import java.util.Objects;

public class Routine extends Entity<RoutineID> {

    private Description description;
    private Type type;
    private IsCompleted isCompleted;
    public Routine(RoutineID entityId, Description description, Type type) {
        super(entityId);
        this.description = description;
        this.type = type;
        this.isCompleted = new IsCompleted(false);
    }


    public Description description() {
        return description;
    }

    public void updateDescription(Description description) {
        this.description = Objects.requireNonNull(description);
    }

    public IsCompleted isCompleted() {
        return isCompleted;
    }

    public void updateIsCompleted(IsCompleted isCompleted) {
        this.isCompleted = Objects.requireNonNull(isCompleted);
    }

    public Type type() {
        return type;
    }

    public void updateType(Type type) {
        this.type = Objects.requireNonNull(type);
    }
}
