package com.zen.gymdomain.nutritionist;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.nutritionist.entities.Diet;
import com.zen.gymdomain.nutritionist.entities.Patient;
import com.zen.gymdomain.nutritionist.events.*;
import com.zen.gymdomain.nutritionist.values.*;
import com.zen.gymdomain.trainer.values.Description;
import com.zen.gymdomain.trainer.values.Name;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Nutritionist extends AggregateEvent<NutritionistID> {
    protected Set<Patient> patientSet;
    protected Map<PatientID, Diet> dietMap;
    protected Name name;

    public Nutritionist(NutritionistID entityId, Name name) {
        super(entityId);
        appendChange(new NutritionistCreated(name)).apply();
    }

    private Nutritionist(NutritionistID entityId) {
        super(entityId);
        subscribe(new NutritionistChange(this));
    }

    public static Nutritionist from(NutritionistID nutritionistID, List<DomainEvent> events) {
        Nutritionist nutritionist = new Nutritionist(nutritionistID);
        events.forEach(nutritionist::applyEvent);
        return nutritionist;
    }

    public void addPatient(Name name, WeightStatus weightStatus, DietType dietType, Description description) {
        PatientID patientID = new PatientID();
        DietID dietID = new DietID();
        appendChange(new PatientAdded(patientID, name, weightStatus, dietID, dietType, description)).apply();
    }

    public void removePatient(PatientID patientID) {
        appendChange(new PatientRemoved(patientID)).apply();
    }

    public void updatePatientWeightStatus(PatientID patientID, WeightStatus weightStatus) {
        appendChange(new PatientWeightStatusUpdated(patientID, weightStatus)).apply();
    }

    public void togglePatientIsWaiting(PatientID patientID) {
        appendChange(new PatientIsWaitingToggled(patientID)).apply();
    }

    public void updateDietDescription(PatientID patientID, Description description) {
        appendChange(new DietDescriptionUpdated(patientID, description)).apply();
    }

    public void updateDietType(PatientID patientID, DietType dietType) {
        appendChange(new DietTypeUpdated(patientID, dietType)).apply();
    }
}
