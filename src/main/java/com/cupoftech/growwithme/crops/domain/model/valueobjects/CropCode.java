package com.cupoftech.growwithme.crops.domain.model.valueobjects;

import jakarta.validation.constraints.Pattern;

public record CropCode(@Pattern(regexp = "^\\d{4}$", message = "The code must contain exactly 4 digits.") String code) {
    public CropCode() { this(null); }
}
