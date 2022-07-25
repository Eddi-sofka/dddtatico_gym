package com.zen.gymdomain.nutritionist.usecases.commands;

import co.com.sofka.domain.generic.Command;
import com.zen.gymdomain.nutritionist.values.NutritionistID;
import com.zen.gymdomain.nutritionist.values.PatientID;
import com.zen.gymdomain.trainer.values.Description;

public class UpdateDietDescription extends Command {
    private final NutritionistID nutritionistID;
    private final PatientID patientID;
    private final Description description;

    public UpdateDietDescription(NutritionistID nutritionistID, PatientID patientID, Description description) {
        this.nutritionistID = nutritionistID;
        this.patientID = patientID;
        this.description = description;
    }

    public NutritionistID getNutritionistID() {
        return nutritionistID;
    }

    public PatientID getPatientID() {
        return patientID;
    }

    public Description getDescription() {
        return description;
    }
}
