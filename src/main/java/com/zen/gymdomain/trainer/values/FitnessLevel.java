package com.zen.gymdomain.trainer.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class FitnessLevel implements ValueObject<FitnessLevelEnum> {
    private final FitnessLevelEnum value;

    public FitnessLevel(FitnessLevelEnum value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public FitnessLevelEnum value() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FitnessLevel that = (FitnessLevel) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

