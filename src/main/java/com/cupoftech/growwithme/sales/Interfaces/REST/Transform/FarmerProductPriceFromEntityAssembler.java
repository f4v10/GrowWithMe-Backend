package com.cupoftech.growwithme.sales.Interfaces.REST.Transform;

import com.cupoftech.growwithme.sales.Domain.Model.Aggregates.FarmerProductPrice;
import com.cupoftech.growwithme.sales.Interfaces.REST.Resources.FarmerProductPriceResource;

public class FarmerProductPriceFromEntityAssembler {
    public static FarmerProductPriceResource toResourceFromEntity(FarmerProductPrice entity) {
        return new FarmerProductPriceResource(entity.getId(), entity.getProductId().productId(), entity.getPrice().money(), entity.getPrice().amount(), entity.getValidityTimeFarmerProduct().start(), entity.getValidityTimeFarmerProduct().end(),entity.getQuantityProduct());
    }
}
