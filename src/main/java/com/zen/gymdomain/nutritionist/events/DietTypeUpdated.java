package com.zen.gymdomain.nutritionist.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.nutritionist.values.DietType;
import com.zen.gymdomain.nutritionist.values.PatientID;

public class DietTypeUpdated extends DomainEvent {
    private final PatientID patientID;
    private final DietType dietType;

    public DietTypeUpdated(PatientID patientID, DietType dietType) {
        super("com.zen.gymdomain.nutritionist.diettypeupdated");
        this.patientID = patientID;
        this.dietType = dietType;
    }

    public PatientID getPatientID() {
        return patientID;
    }

    public DietType getDietType() {
        return dietType;
    }
}
