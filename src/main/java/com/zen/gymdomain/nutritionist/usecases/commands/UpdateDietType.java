package com.zen.gymdomain.nutritionist.usecases.commands;

import co.com.sofka.domain.generic.Command;
import com.zen.gymdomain.nutritionist.values.DietType;
import com.zen.gymdomain.nutritionist.values.NutritionistID;
import com.zen.gymdomain.nutritionist.values.PatientID;

public class UpdateDietType extends Command {
    private final NutritionistID nutritionistID;
    private final PatientID patientID;
    private final DietType dietType;

    public UpdateDietType(NutritionistID nutritionistID, PatientID patientID, DietType dietType) {
        this.nutritionistID = nutritionistID;
        this.patientID = patientID;
        this.dietType = dietType;
    }

    public NutritionistID getNutritionistID() {
        return nutritionistID;
    }

    public PatientID getPatientID() {
        return patientID;
    }

    public DietType getDietType() {
        return dietType;
    }
}
