package com.zen.gymdomain.trainer.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Type implements ValueObject<TypeEnum> {
    private final TypeEnum value;

    public Type(TypeEnum value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public TypeEnum value() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type = (Type) o;
        return value == type.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
