package com.cupoftech.growwithme.crops.interfaces.rest.transform;

import com.cupoftech.growwithme.crops.domain.model.aggregates.Crop;
import com.cupoftech.growwithme.crops.interfaces.rest.resources.CropResource;

public class CropResourceFromEntityAssembler {
    public static CropResource toResourceFromEntity(Crop entity) {
        return new CropResource(
                entity.getId(),
                entity.getName(),
                entity.getCode(),
                entity.getStatus(),
                entity.getCost()
        );
    }
}
