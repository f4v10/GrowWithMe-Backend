package com.cupoftech.growwithme.iam.interfaces.rest.transform;

import com.cupoftech.growwithme.iam.domain.model.commands.SignInCommand;
import com.cupoftech.growwithme.iam.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {
    public static SignInCommand toCommandFromResource(SignInResource resource) {
        return new SignInCommand(resource.email(), resource.password());
    }
}
