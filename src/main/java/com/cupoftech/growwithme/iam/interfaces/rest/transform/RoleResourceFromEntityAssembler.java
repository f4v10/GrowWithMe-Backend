package com.cupoftech.growwithme.iam.interfaces.rest.transform;

import com.cupoftech.growwithme.iam.domain.model.entities.Role;
import com.cupoftech.growwithme.iam.interfaces.rest.resources.RoleResource;

public class RoleResourceFromEntityAssembler {
    public static RoleResource toResourceFromEntity(Role entity) {
        return new RoleResource(entity.getId(), entity.getStringName());
    }
}
