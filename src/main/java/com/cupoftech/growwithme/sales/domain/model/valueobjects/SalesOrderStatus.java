package com.cupoftech.growwithme.sales.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public enum SalesOrderStatus {
    PENDING,
    CONFIRMED,
    REJECTED,
    CANCELLED
}
