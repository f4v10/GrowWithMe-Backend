package com.cupoftech.growwithme.sales.domain.services;

import com.cupoftech.growwithme.sales.domain.model.aggregates.FarmerProductPrice;
import com.cupoftech.growwithme.sales.domain.model.commands.CreateFarmerProductCommand;
import com.cupoftech.growwithme.sales.domain.model.commands.DeleteFarmerProductCommand;
import com.cupoftech.growwithme.sales.domain.model.commands.UpdateFarmerProductCommand;

import java.util.Optional;

public interface FarmerProductCommandService {
    Optional<FarmerProductPrice> handle(CreateFarmerProductCommand command);
    Optional<FarmerProductPrice> handle(UpdateFarmerProductCommand command);
    void handle(DeleteFarmerProductCommand command);
}
