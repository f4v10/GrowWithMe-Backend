package com.cupoftech.growwithme.sales.domain.model.valueobjects;

public record StockProduct(Long stockProduct) {
    public StockProduct {
        if (stockProduct == null || stockProduct < 0) {
            throw new IllegalArgumentException("Stock Product cannot be null");
        }
    }
}
