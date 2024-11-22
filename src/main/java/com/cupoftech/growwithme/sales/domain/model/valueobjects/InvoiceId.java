package com.cupoftech.growwithme.sales.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record InvoiceId(String InvoiceId) {
    public InvoiceId(){
        this("0");
    }

    public InvoiceId {
        if (InvoiceId == null) {
            throw new IllegalArgumentException("InvoiceId cannot be null");
        }
    }

}
