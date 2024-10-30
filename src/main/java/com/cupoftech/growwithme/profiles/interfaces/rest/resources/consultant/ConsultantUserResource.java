package com.cupoftech.growwithme.profiles.interfaces.rest.resources.consultant;

public record ConsultantUserResource(
        Long id,
        String fullName,
        String email,
        String password,
        String dni,
        String phone
) {
}
