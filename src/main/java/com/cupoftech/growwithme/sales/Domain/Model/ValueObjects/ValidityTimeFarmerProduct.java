package com.cupoftech.growwithme.sales.Domain.Model.ValueObjects;

import jakarta.persistence.Embeddable;

import java.time.LocalDateTime;
@Embeddable
public record ValidityTimeFarmerProduct(LocalDateTime start, LocalDateTime end) {
    public ValidityTimeFarmerProduct {
        if (start == null || end == null || start.isAfter(end)) {
            throw new IllegalArgumentException("ValidityTimeFarmerProduct cannot be null");
        }
    }
    public ValidityTimeFarmerProduct(){
        this(LocalDateTime.now(), LocalDateTime.now());
    }
}
