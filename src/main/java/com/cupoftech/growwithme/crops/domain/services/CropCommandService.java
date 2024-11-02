package com.cupoftech.growwithme.crops.domain.services;

import com.cupoftech.growwithme.crops.domain.model.aggregates.Crop;
import com.cupoftech.growwithme.crops.domain.model.commands.CreateCropCommand;
import com.cupoftech.growwithme.crops.domain.model.commands.DeleteCropCommand;

import java.util.Optional;

public interface CropCommandService {
    Optional<Crop> handle(CreateCropCommand command);
    void handle(DeleteCropCommand command);
}
