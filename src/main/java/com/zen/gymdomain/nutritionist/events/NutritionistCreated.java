package com.zen.gymdomain.nutritionist.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.nutritionist.entities.Patient;
import com.zen.gymdomain.nutritionist.values.NutritionistID;
import com.zen.gymdomain.trainer.values.Name;

import java.util.Set;

public class NutritionistCreated extends DomainEvent {

    private final Name name;

    public NutritionistCreated(Name name) {
        super("com.zen.gymdomain.nutritionist.nutritionistcreated");
        this.name = name;
    }

    public Name getName() {
        return name;
    }
}
