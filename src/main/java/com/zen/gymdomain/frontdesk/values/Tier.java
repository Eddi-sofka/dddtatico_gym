package com.zen.gymdomain.frontdesk.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Tier implements ValueObject<TierEnum> {
    private final TierEnum value;

    public Tier(TierEnum value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public TierEnum value() {
        return this.value;
    }
}

enum TierEnum {
    SILVER,
    GOLD,
    PLATINUM
}
