package com.cupoftech.growwithme.crops.domain.model.valueobjects;

public record CropName(String name) {
    public CropName {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name must not be null or blank");
        }
    }
}
