package com.cupoftech.growwithme.iam.domain.services.crop;

import com.cupoftech.growwithme.iam.domain.model.aggregates.Crops;
import com.cupoftech.growwithme.iam.domain.model.commands.crop.CreateCropsCommand;
import com.cupoftech.growwithme.iam.domain.model.commands.crop.DeleteCropsCommand;

import java.util.Optional;

public interface CropsCommandService {
    Optional<Crops> handle(CreateCropsCommand command);
    void handle(DeleteCropsCommand command);
}
