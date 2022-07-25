package com.zen.gymdomain.nutritionist.usecases.commands;

import co.com.sofka.domain.generic.Command;
import com.zen.gymdomain.nutritionist.values.DietType;
import com.zen.gymdomain.nutritionist.values.NutritionistID;
import com.zen.gymdomain.nutritionist.values.WeightStatus;
import com.zen.gymdomain.trainer.values.Description;
import com.zen.gymdomain.trainer.values.Name;

public class AddPatient extends Command {

    private final NutritionistID nutritionistID;
    private final Name name;
    private final WeightStatus weightStatus;
    private final DietType dietType;
    private final Description description;

    public AddPatient(NutritionistID nutritionistID, Name name, WeightStatus weightStatus, DietType dietType, Description description) {
        this.nutritionistID = nutritionistID;
        this.name = name;
        this.weightStatus = weightStatus;
        this.dietType = dietType;
        this.description = description;
    }

    public NutritionistID getNutritionistID() {
        return nutritionistID;
    }

    public Name getName() {
        return name;
    }

    public WeightStatus getWeightStatus() {
        return weightStatus;
    }

    public DietType getDietType() {
        return dietType;
    }

    public Description getDescription() {
        return description;
    }
}
