package com.cupoftech.growwithme.profiles.domain.model.commands.farmer;

public record CreateFarmerUserCommand(String firstName, String lastName, String email, String phone, String documentType, String valueDocumentType) {
}
