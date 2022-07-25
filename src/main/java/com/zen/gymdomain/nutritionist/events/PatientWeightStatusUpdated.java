package com.zen.gymdomain.nutritionist.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.nutritionist.values.PatientID;
import com.zen.gymdomain.nutritionist.values.WeightStatus;

public class PatientWeightStatusUpdated extends DomainEvent {
    private final PatientID patientID;
    private final WeightStatus weightStatus;

    public PatientWeightStatusUpdated(PatientID patientID, WeightStatus weightStatus) {
        super("com.zen.gymdomain.nutritionist.patientweightstatusupdated");
        this.patientID = patientID;
        this.weightStatus = weightStatus;
    }

    public PatientID getPatientID() {
        return patientID;
    }

    public WeightStatus getWeightStatus() {
        return weightStatus;
    }
}
