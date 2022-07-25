package com.zen.gymdomain.nutritionist.usecases.commands;

import co.com.sofka.domain.generic.Command;
import com.zen.gymdomain.nutritionist.values.NutritionistID;
import com.zen.gymdomain.nutritionist.values.PatientID;

public class TogglePatientIsWaiting extends Command {
    private final NutritionistID nutritionistID;
    private final PatientID patientID;

    public TogglePatientIsWaiting(NutritionistID nutritionistID, PatientID patientID) {
        this.nutritionistID = nutritionistID;
        this.patientID = patientID;
    }

    public PatientID getPatientID() {
        return patientID;
    }

    public NutritionistID getNutritionistID() {
        return nutritionistID;
    }
}
