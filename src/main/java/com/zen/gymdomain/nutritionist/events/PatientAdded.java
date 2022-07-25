package com.zen.gymdomain.nutritionist.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.nutritionist.values.DietID;
import com.zen.gymdomain.nutritionist.values.DietType;
import com.zen.gymdomain.nutritionist.values.PatientID;
import com.zen.gymdomain.nutritionist.values.WeightStatus;
import com.zen.gymdomain.trainer.values.Description;
import com.zen.gymdomain.trainer.values.Name;

public class PatientAdded extends DomainEvent {
    private final PatientID patientID;
    private final Name name;
    private final WeightStatus weightStatus;
    private final DietID dietID;
    private final DietType dietType;
    private final Description description;

    public PatientAdded(PatientID patientID, Name name, WeightStatus weightStatus, DietID dietID, DietType dietType, Description description) {
        super("com.zen.gymdomain.nutritionist.patientadded");
        this.patientID = patientID;
        this.name = name;
        this.weightStatus = weightStatus;
        this.dietID = dietID;
        this.dietType = dietType;
        this.description = description;
    }

    public PatientID getPatientID() {
        return patientID;
    }

    public Name getName() {
        return name;
    }

    public WeightStatus getWeightStatus() {
        return weightStatus;
    }

    public DietID getDietID() {
        return dietID;
    }

    public DietType getDietType() {
        return dietType;
    }

    public Description getDescription() {
        return description;
    }
}
