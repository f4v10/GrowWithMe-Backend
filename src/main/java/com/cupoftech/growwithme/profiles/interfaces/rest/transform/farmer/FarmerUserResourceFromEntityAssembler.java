package com.cupoftech.growwithme.profiles.interfaces.rest.transform.farmer;

import com.cupoftech.growwithme.profiles.domain.model.commands.farmer.CreateFarmerUserCommand;
import com.cupoftech.growwithme.profiles.interfaces.rest.resources.farmer.CreateFarmerUserResource;

public class FarmerUserResourceFromEntityAssembler {
    public static CreateFarmerUserCommand toCommandFromResource(CreateFarmerUserResource resource) {
        return new CreateFarmerUserCommand(
                resource.firstName(),
                resource.lastName(),
                resource.email(),
                resource.password(),
                resource.documentType(),
                resource.valueDocumentType(),
                resource.phone()
        );
    }
}
