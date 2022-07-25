package com.zen.gymdomain.frontdesk.values;

import co.com.sofka.domain.generic.ValueObject;

import java.math.BigDecimal;
import java.util.Objects;

public class Price implements ValueObject<BigDecimal> {
    private final BigDecimal value;

    public Price(BigDecimal value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public BigDecimal value() {
        return this.value;
    }
}
