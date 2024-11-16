package com.cupoftech.growwithme.sales.domain.services;

import com.cupoftech.growwithme.sales.domain.model.aggregates.FarmerProductPrice;
import com.cupoftech.growwithme.sales.domain.model.queries.GetAllFarmerProductPricesQuery;
import com.cupoftech.growwithme.sales.domain.model.queries.GetFarmerProductByIdQuery;

import java.util.List;
import java.util.Optional;

public interface FarmerProductQueryService {
    Optional<FarmerProductPrice> handle (GetFarmerProductByIdQuery query);
    List<FarmerProductPrice> handle(GetAllFarmerProductPricesQuery query);

}
