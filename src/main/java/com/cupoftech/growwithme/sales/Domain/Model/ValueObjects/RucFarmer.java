package com.cupoftech.growwithme.sales.Domain.Model.ValueObjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record RucFarmer(Long ruc) {
    public RucFarmer {
        if (ruc == null) {
            throw new IllegalArgumentException("Ruc cannot be null");
        }
    }

}
