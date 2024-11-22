package com.cupoftech.growwithme.sales.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.time.LocalDateTime;

@Embeddable
public record OrderTimestamp(LocalDateTime dateTime) {
    public OrderTimestamp {
        if (dateTime == null ) {
            throw new IllegalArgumentException("OrderTimestamp cannot be null");
        }
    }
    public OrderTimestamp(){
        this(LocalDateTime.now());
    }
}
