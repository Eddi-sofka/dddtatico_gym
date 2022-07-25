package com.zen.gymdomain.nutritionist.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.nutritionist.values.PatientID;

public class PatientRemoved extends DomainEvent {
    private final PatientID patientID;

    public PatientRemoved(PatientID patientID) {
        super("com.zen.gymdomain.nutritionist.patientremoved");
        this.patientID = patientID;
    }

    public PatientID getPatientID() {
        return patientID;
    }
}
