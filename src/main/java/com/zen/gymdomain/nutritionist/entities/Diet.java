package com.zen.gymdomain.nutritionist.entities;

import co.com.sofka.domain.generic.Entity;
import com.zen.gymdomain.nutritionist.values.DietID;
import com.zen.gymdomain.nutritionist.values.DietType;
import com.zen.gymdomain.trainer.values.Description;

import java.util.Objects;

public class Diet extends Entity<DietID> {
    protected DietType dietType;
    protected Description description;

    public Diet(DietID entityId, DietType dietType, Description description) {
        super(entityId);
        this.dietType = dietType;
        this.description = description;
    }

    public DietType dietType() {
        return dietType;
    }

    public void updateDietType(DietType dietType) {
        this.dietType = Objects.requireNonNull(dietType);
    }

    public Description description() {
        return description;
    }

    public void updateDescription(Description description) {
        this.description = Objects.requireNonNull(description);
    }
}
