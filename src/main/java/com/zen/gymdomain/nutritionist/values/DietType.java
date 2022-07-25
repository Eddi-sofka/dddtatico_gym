package com.zen.gymdomain.nutritionist.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DietType implements ValueObject<DietTypeEnum> {
    private final DietTypeEnum dietTypeEnum;

    public DietType(DietTypeEnum dietTypeEnum) {
        this.dietTypeEnum = Objects.requireNonNull(dietTypeEnum);
    }


    @Override
    public DietTypeEnum value() {
        return this.dietTypeEnum;
    }
}

enum DietTypeEnum {
    FASTING,
    MEDITERRANEAN,
    KETOGENIC,
    VEGANISM,
    CARNIVORE,
    PALEO,
    STIRFOOD
}
