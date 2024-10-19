package com.cupoftech.growwithme.iam.domain.model.commands.consultant;

public record CreateConsultantUserCommand(String firstName, String lastName, String email, String password, String dni, String phone) {
}
