package com.cupoftech.growwithme.profiles.interfaces.rest.resources.farmer;

public record FarmerUserResource(
        Long id,
        String fullName,
        String email,
        String password,
        String documentType,
        String valueDocumentType,
        String phone
) {
}
