package com.cupoftech.growwithme.sales.interfaces.rest.transform;

import com.cupoftech.growwithme.sales.domain.model.commands.UpdateFarmerProductCommand;
import com.cupoftech.growwithme.sales.interfaces.rest.resources.UpdateFarmerProductPriceResource;

public class UpdateFarmerProductPriceCommandFromAssembler {
    public static UpdateFarmerProductCommand toCommandFromResource(Long productId, UpdateFarmerProductPriceResource resource) {
        return new UpdateFarmerProductCommand(productId,resource.productId(), resource.money(), resource.quantityProduct(), resource.amount(), resource.start(), resource.end());
    }
}
