package com.cupoftech.growwithme.sales.interfaces.rest.transform;

import com.cupoftech.growwithme.sales.domain.model.aggregates.FarmerProductPrice;
import com.cupoftech.growwithme.sales.interfaces.rest.resources.FarmerProductPriceResource;

public class FarmerProductPriceFromEntityAssembler {
    public static FarmerProductPriceResource toResourceFromEntity(FarmerProductPrice entity) {
        return new FarmerProductPriceResource(entity.getId(), entity.getProductId().productId(), entity.getPrice().money(), entity.getPrice().amount(), entity.getValidityTimeFarmerProduct().start(), entity.getValidityTimeFarmerProduct().end(),entity.getQuantityProduct().quantityProduct());
    }
}
