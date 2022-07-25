package com.zen.gymdomain.frontdesk.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Product implements ValueObject<String> {
    private final String value;

    public Product(String value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return this.value;
    }
}
