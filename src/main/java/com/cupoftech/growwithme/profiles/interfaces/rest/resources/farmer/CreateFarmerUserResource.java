package com.cupoftech.growwithme.profiles.interfaces.rest.resources.farmer;

public record CreateFarmerUserResource(
        String firstName,
        String lastName,
        String email,
        String phone,
        String documentType,
        String valueDocumentType
) {
}
