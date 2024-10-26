package com.cupoftech.growwithme.iam.domain.services.crop;

import com.cupoftech.growwithme.iam.domain.model.aggregates.Crops;
import com.cupoftech.growwithme.iam.domain.model.queries.crop.GetAllCropsQuery;
import com.cupoftech.growwithme.iam.domain.model.queries.crop.GetCropsByIdQuery;

import java.util.List;
import java.util.Optional;

public interface CropsQueryService {
    List<Crops> handle(GetAllCropsQuery query);
    Optional<Crops> handle(GetCropsByIdQuery query);
}
