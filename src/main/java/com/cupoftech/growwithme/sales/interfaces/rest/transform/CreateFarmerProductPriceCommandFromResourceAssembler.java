package com.cupoftech.growwithme.sales.interfaces.rest.transform;

import com.cupoftech.growwithme.sales.domain.model.commands.CreateFarmerProductCommand;
import com.cupoftech.growwithme.sales.interfaces.rest.resources.CreateFarmerProductPriceResource;

public class CreateFarmerProductPriceCommandFromResourceAssembler {
    public static CreateFarmerProductCommand toCommandFromResource(CreateFarmerProductPriceResource resource) {
        return new CreateFarmerProductCommand( resource.productId(), resource.money(), resource.amount(), resource.start(), resource.end(), resource.quantityProduct())  ;
    }
}
