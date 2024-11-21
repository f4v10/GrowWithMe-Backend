package com.cupoftech.growwithme.iam.interfaces.rest.transform;

import com.cupoftech.growwithme.iam.domain.model.aggregates.User;
import com.cupoftech.growwithme.iam.interfaces.rest.resources.AuthenticatedUserResource;

public class AuthenticatedUserResourceFromEntityAssembler {
    public static AuthenticatedUserResource toResourceFromEntity(User entity, String token) {
        return new AuthenticatedUserResource(entity.getId(), entity.getEmail(), token);
    }
}
