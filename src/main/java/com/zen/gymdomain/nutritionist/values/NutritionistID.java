package com.zen.gymdomain.nutritionist.values;

import co.com.sofka.domain.generic.Identity;

public class NutritionistID extends Identity {
    public NutritionistID() {
    }

    private NutritionistID(String id) {
        super(id);
    }

    public static NutritionistID of(String id) {
        return new NutritionistID(id);
    }
}
