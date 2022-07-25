package com.zen.gymdomain.nutritionist.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.nutritionist.values.PatientID;

public class PatientIsWaitingToggled extends DomainEvent {
    private final PatientID patientID;

    public PatientIsWaitingToggled(PatientID patientID) {
        super("com.zen.gymdomain.nutritionist.patientiswaitingtoggled");
        this.patientID = patientID;
    }

    public PatientID getPatientID() {
        return patientID;
    }
}
