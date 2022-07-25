package com.zen.gymdomain.nutritionist.entities;

import co.com.sofka.domain.generic.Entity;
import com.zen.gymdomain.nutritionist.values.IsWaiting;
import com.zen.gymdomain.nutritionist.values.PatientID;
import com.zen.gymdomain.nutritionist.values.WeightStatus;
import com.zen.gymdomain.trainer.values.Name;

import java.util.Objects;

public class Patient extends Entity<PatientID> {
    protected WeightStatus weightStatus;
    protected Name name;
    protected IsWaiting isWaiting;

    public Patient(PatientID entityId, Name name, WeightStatus weightStatus) {
        super(entityId);
        this.name = name;
        this.weightStatus = weightStatus;
        this.isWaiting = new IsWaiting(false);
    }

    public WeightStatus weightStatus() {
        return weightStatus;
    }

    public void updateWeightStatus(WeightStatus weightStatus) {
        this.weightStatus = Objects.requireNonNull(weightStatus);
    }

    public Name name() {
        return name;
    }

    public void updateName(Name name) {
        this.name = Objects.requireNonNull(name);
    }

    public IsWaiting isWaiting() {
        return isWaiting;
    }

    public void toggleIsWaiting(IsWaiting isWaiting) {
        this.isWaiting = Objects.requireNonNull(isWaiting);
    }
}
