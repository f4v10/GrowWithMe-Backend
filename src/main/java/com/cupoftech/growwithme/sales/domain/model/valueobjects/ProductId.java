package com.cupoftech.growwithme.sales.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ProductId(String productId) {
    public ProductId(){
        this("");
    }
    public ProductId {
        if (productId == null) {
            throw new IllegalArgumentException("Product Id cannot be empty");
        }

    }
}
