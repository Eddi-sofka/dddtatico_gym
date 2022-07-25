package com.zen.gymdomain.nutritionist.values;

import co.com.sofka.domain.generic.Identity;

public class DietID extends Identity {
    public DietID() {
    }

    private DietID(String id) {
        super(id);
    }

    public static DietID of(String id) {
        return new DietID(id);
    }
}
