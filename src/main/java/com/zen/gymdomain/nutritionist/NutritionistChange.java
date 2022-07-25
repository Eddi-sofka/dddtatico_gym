package com.zen.gymdomain.nutritionist;

import co.com.sofka.domain.generic.EventChange;
import com.zen.gymdomain.nutritionist.entities.Diet;
import com.zen.gymdomain.nutritionist.entities.Patient;
import com.zen.gymdomain.nutritionist.events.*;
import com.zen.gymdomain.nutritionist.values.IsWaiting;
import com.zen.gymdomain.nutritionist.values.PatientID;

import java.util.HashMap;
import java.util.HashSet;

public class NutritionistChange extends EventChange {
    public NutritionistChange(Nutritionist nutritionist) {
        apply((NutritionistCreated event) -> {
            nutritionist.name = event.getName();
            nutritionist.patientSet = new HashSet<>();
            nutritionist.dietMap = new HashMap<>();
        });

        apply((PatientAdded event) -> {
            Patient patient = new Patient(event.getPatientID(), event.getName(), event.getWeightStatus());
            Diet diet = new Diet(event.getDietID(), event.getDietType(), event.getDescription());
            nutritionist.patientSet.add(patient);
            nutritionist.dietMap.put(event.getPatientID(), diet);
        });

        apply((PatientRemoved event) -> {
            PatientID patientID = event.getPatientID();
            nutritionist.patientSet.removeIf(patient -> patient.identity().equals(patientID));
            nutritionist.dietMap.remove(patientID);
        });

        apply((PatientWeightStatusUpdated event) -> {
            Patient patient = nutritionist.patientSet.stream().filter(p -> p.identity().equals(event.getPatientID())).findFirst().orElseThrow();
            patient.updateWeightStatus(event.getWeightStatus());
            nutritionist.patientSet.removeIf(p -> p.identity().equals(event.getPatientID()));
            nutritionist.patientSet.add(patient);
        });

        apply((PatientIsWaitingToggled event) -> {
            Patient patient = nutritionist.patientSet.stream().filter(p -> p.identity().equals(event.getPatientID())).findFirst().orElseThrow();
            patient.toggleIsWaiting(new IsWaiting(!patient.isWaiting().value()));
            nutritionist.patientSet.removeIf(p -> p.identity().equals(event.getPatientID()));
            nutritionist.patientSet.add(patient);
        });

        apply((DietDescriptionUpdated event) -> {
            PatientID key = event.getPatientID();
            Diet dietUpdated = nutritionist.dietMap.get(key);
            dietUpdated.updateDescription(event.getDescription());
            nutritionist.dietMap.replace(key, dietUpdated);
        });

        apply((DietTypeUpdated event) -> {
            PatientID key = event.getPatientID();
            Diet dietUpdated = nutritionist.dietMap.get(key);
            dietUpdated.updateDietType(event.getDietType());
            nutritionist.dietMap.replace(key, dietUpdated);
        });
    }
}
