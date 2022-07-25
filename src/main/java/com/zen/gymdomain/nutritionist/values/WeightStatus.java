package com.zen.gymdomain.nutritionist.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class WeightStatus implements ValueObject<WeightStatusEnum> {
    private final WeightStatusEnum value;

    public WeightStatus(WeightStatusEnum value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public WeightStatusEnum value() {
        return this.value;
    }
}

enum WeightStatusEnum {
    UNDERWEIGHT,
    NORMAL,
    OVERWEIGHT,
    OBESITY_ONE,
    OBESITY_TWO,
    OBESITY_THREE
}
