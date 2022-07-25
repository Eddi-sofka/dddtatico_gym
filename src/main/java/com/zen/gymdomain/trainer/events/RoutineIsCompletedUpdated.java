package com.zen.gymdomain.trainer.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.trainer.values.IsCompleted;

public class RoutineIsCompletedUpdated extends DomainEvent {
    private final IsCompleted isCompleted;

    public RoutineIsCompletedUpdated(IsCompleted isCompleted) {
        super("com.zen.gymdomain.trainer.routineiscompletedupdated");
        this.isCompleted = isCompleted;
    }

    public IsCompleted getIsCompleted() {
        return isCompleted;
    }
}
