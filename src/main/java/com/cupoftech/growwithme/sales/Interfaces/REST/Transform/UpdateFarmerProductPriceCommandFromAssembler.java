package com.cupoftech.growwithme.sales.Interfaces.REST.Transform;

import com.cupoftech.growwithme.sales.Domain.Model.Commands.UpdateFarmerProductCommand;
import com.cupoftech.growwithme.sales.Interfaces.REST.Resources.UpdateFarmerProductPriceResource;

public class UpdateFarmerProductPriceCommandFromAssembler {
    public static UpdateFarmerProductCommand toCommandFromResource(Long productId, UpdateFarmerProductPriceResource resource) {
        return new UpdateFarmerProductCommand(productId,resource.productId(), resource.money(), resource.quantityProduct(), resource.amount(), resource.start(), resource.end());
    }
}
