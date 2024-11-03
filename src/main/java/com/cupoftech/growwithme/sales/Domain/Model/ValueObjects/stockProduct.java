package com.cupoftech.growwithme.sales.Domain.Model.ValueObjects;

public record stockProduct(Long stockProduct) {
    public stockProduct {
        if (stockProduct == null || stockProduct < 0) {
            throw new IllegalArgumentException("stockProduct cannot be null");
        }
    }
}
