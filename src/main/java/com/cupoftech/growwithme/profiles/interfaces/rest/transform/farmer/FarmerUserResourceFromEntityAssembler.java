package com.cupoftech.growwithme.profiles.interfaces.rest.transform.farmer;

import com.cupoftech.growwithme.profiles.domain.model.aggregates.FarmerUser;
import com.cupoftech.growwithme.profiles.domain.model.commands.farmer.CreateFarmerUserCommand;
import com.cupoftech.growwithme.profiles.interfaces.rest.resources.farmer.CreateFarmerUserResource;
import com.cupoftech.growwithme.profiles.interfaces.rest.resources.farmer.FarmerUserResource;

public class FarmerUserResourceFromEntityAssembler {
    public static FarmerUserResource toResourceFromEntity(FarmerUser entity) {
        return new FarmerUserResource(
                entity.getId(),
                entity.getFullName(),
                entity.getEmailAddress(),
                entity.getPhone(),
                entity.getDocumentType(),
                entity.getValueDocumentType()
        );
    }
}
