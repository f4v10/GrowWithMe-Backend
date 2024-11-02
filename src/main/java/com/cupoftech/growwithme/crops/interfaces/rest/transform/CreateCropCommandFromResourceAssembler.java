package com.cupoftech.growwithme.crops.interfaces.rest.transform;

import com.cupoftech.growwithme.crops.domain.model.commands.CreateCropCommand;
import com.cupoftech.growwithme.crops.interfaces.rest.resources.CreateCropResource;

public class CreateCropCommandFromResourceAssembler {
    public static CreateCropCommand toCommandFromResource(CreateCropResource resource) {
        return new CreateCropCommand(
                resource.name(),
                resource.code(),
                resource.status(),
                resource.cost()
        );
    }
}
