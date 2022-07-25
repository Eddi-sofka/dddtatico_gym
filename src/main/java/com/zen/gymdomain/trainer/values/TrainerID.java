package com.zen.gymdomain.trainer.values;

import co.com.sofka.domain.generic.Identity;

public class TrainerID extends Identity {
    public TrainerID() {
    }

    private TrainerID(String id) {
        super(id);
    }

    public static TrainerID of(String id) {
        return new TrainerID(id);
    }
}
