package com.zen.gymdomain.nutritionist.usecases.commands;

import co.com.sofka.domain.generic.Command;
import com.zen.gymdomain.nutritionist.values.NutritionistID;
import com.zen.gymdomain.nutritionist.values.PatientID;
import com.zen.gymdomain.nutritionist.values.WeightStatus;

public class UpdatePatientWeightStatus extends Command {
    private final NutritionistID nutritionistID;
    private final PatientID patientID;
    private final WeightStatus weightStatus;

    public UpdatePatientWeightStatus(NutritionistID nutritionistID, PatientID patientID, WeightStatus weightStatus) {
        this.nutritionistID = nutritionistID;
        this.patientID = patientID;
        this.weightStatus = weightStatus;
    }

    public NutritionistID getNutritionistID() {
        return nutritionistID;
    }

    public PatientID getPatientID() {
        return patientID;
    }

    public WeightStatus getWeightStatus() {
        return weightStatus;
    }
}
