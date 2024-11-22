package com.cupoftech.growwithme.sales.domain.model.valueobjects;
import jakarta.persistence.Embeddable;

@Embeddable
public record QuantityProduct(Integer quantityProduct) {
    public QuantityProduct(){
        this(0);
    }
    public QuantityProduct {
        if (quantityProduct == null || quantityProduct < 0) {
            throw new IllegalArgumentException("Quantity Product cannot be null");
        }
    }
}