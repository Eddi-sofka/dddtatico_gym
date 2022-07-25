package com.zen.gymdomain.trainer.values;

import co.com.sofka.domain.generic.Identity;

public class RoutineID extends Identity {
    public RoutineID() {
    }

    private RoutineID(String id) {
        super(id);
    }

    public static RoutineID of(String id) {
        return new RoutineID(id);
    }
}
