package com.zen.gymdomain.nutritionist.values;

import co.com.sofka.domain.generic.Identity;

public class PatientID extends Identity {
    public PatientID() {
    }

    private PatientID(String id) {
        super(id);
    }

    public static PatientID of(String id) {
        return new PatientID(id);
    }
}
