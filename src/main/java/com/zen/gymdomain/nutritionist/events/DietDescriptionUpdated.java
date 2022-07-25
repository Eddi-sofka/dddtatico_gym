package com.zen.gymdomain.nutritionist.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.nutritionist.values.PatientID;
import com.zen.gymdomain.trainer.values.Description;

public class DietDescriptionUpdated extends DomainEvent {
    private final PatientID patientID;
    private final Description description;

    public DietDescriptionUpdated(PatientID patientID, Description description) {
        super("com.zen.gymdomain.nutritionist.dietdescriptionupdated");
        this.patientID = patientID;
        this.description = description;
    }

    public PatientID getPatientID() {
        return patientID;
    }

    public Description getDescription() {
        return description;
    }
}
