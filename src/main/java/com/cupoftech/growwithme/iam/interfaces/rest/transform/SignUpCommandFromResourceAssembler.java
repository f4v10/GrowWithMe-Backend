package com.cupoftech.growwithme.iam.interfaces.rest.transform;

import com.cupoftech.growwithme.iam.domain.model.commands.SignUpCommand;
import com.cupoftech.growwithme.iam.domain.model.entities.Role;
import com.cupoftech.growwithme.iam.interfaces.rest.resources.SignUpResource;

import java.util.ArrayList;

public class SignUpCommandFromResourceAssembler {
    public static SignUpCommand toCommandFromResource(SignUpResource resource) {
        var roles = resource.roles() !=null
                ? resource.roles().stream().map(Role::toRoleFromName).toList()
                : new ArrayList<Role>();
        return new SignUpCommand(resource.username(), resource.password(), roles);
    }
}
