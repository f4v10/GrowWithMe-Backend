package com.cupoftech.growwithme.sales.Domain.Services;

import com.cupoftech.growwithme.sales.Domain.Model.Aggregates.FarmerProductPrice;
import com.cupoftech.growwithme.sales.Domain.Model.Commands.CreateFarmerProductCommand;
import com.cupoftech.growwithme.sales.Domain.Model.Commands.DeleteFarmerProductCommand;
import com.cupoftech.growwithme.sales.Domain.Model.Commands.UpdateFarmerProductCommand;

import java.util.Optional;

public interface FarmerProductCommandService {
    Optional<FarmerProductPrice> handle(CreateFarmerProductCommand command);
    Optional<FarmerProductPrice> handle(UpdateFarmerProductCommand command);
    void handle(DeleteFarmerProductCommand command);
}
