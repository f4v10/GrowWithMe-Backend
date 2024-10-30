package com.cupoftech.growwithme.profiles.interfaces.rest.transform.consultant;

import com.cupoftech.growwithme.profiles.domain.model.aggregates.ConsultantUser;
import com.cupoftech.growwithme.profiles.interfaces.rest.resources.consultant.ConsultantUserResource;

public class ConsultantUserResourceFromEntityAssembler {
    public static ConsultantUserResource toResourceFromEntity(ConsultantUser entity) {
        return new ConsultantUserResource(
                entity.getId(),
                entity.getFullName(),
                entity.getEmailAddress(),
                entity.getPhone(),
                entity.getDni()
        );
    }
}
