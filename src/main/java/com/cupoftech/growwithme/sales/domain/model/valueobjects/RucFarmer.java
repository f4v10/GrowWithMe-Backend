package com.cupoftech.growwithme.sales.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record RucFarmer(String ruc) {
    public RucFarmer {
        if (ruc == null) {
            throw new IllegalArgumentException("Ruc cannot be null");
        }
    }
    public RucFarmer(){
        this("");
    }
}
