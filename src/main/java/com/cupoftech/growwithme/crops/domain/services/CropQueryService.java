package com.cupoftech.growwithme.crops.domain.services;

import com.cupoftech.growwithme.crops.domain.model.aggregates.Crop;
import com.cupoftech.growwithme.crops.domain.model.queries.GetAllCropsQuery;
import com.cupoftech.growwithme.crops.domain.model.queries.GetCropByIdQuery;

import java.util.List;
import java.util.Optional;

public interface CropQueryService {
    List<Crop> handle(GetAllCropsQuery query);
    Optional<Crop> handle(GetCropByIdQuery query);
}
