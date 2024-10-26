package com.cupoftech.growwithme.iam.domain.model.valueobjects;

public record CropName(String Name) {
    public CropName {
        if (Name == null || Name.isBlank()) {
            throw new IllegalArgumentException("Name must not be null or blank");
        }
    }

    public String getFullName() {
        return String.format("%s %s", Name);
    }
}
