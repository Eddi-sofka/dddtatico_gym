package com.zen.gymdomain.nutritionist.usecases.commands;

import co.com.sofka.domain.generic.Command;
import com.zen.gymdomain.nutritionist.values.NutritionistID;
import com.zen.gymdomain.nutritionist.values.PatientID;

public class RemovePatient extends Command {
    private final NutritionistID nutritionistID;
    private final PatientID patientID;

    public RemovePatient(NutritionistID nutritionistID, PatientID patientID) {
        this.nutritionistID = nutritionistID;
        this.patientID = patientID;
    }

    public NutritionistID getNutritionistID() {
        return nutritionistID;
    }

    public PatientID getPatientID() {
        return patientID;
    }
}
