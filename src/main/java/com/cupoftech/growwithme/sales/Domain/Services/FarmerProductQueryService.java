package com.cupoftech.growwithme.sales.Domain.Services;

import com.cupoftech.growwithme.sales.Domain.Model.Aggregates.FarmerProductPrice;
import com.cupoftech.growwithme.sales.Domain.Model.Queries.GetAllFarmerProductPriceQuery;
import com.cupoftech.growwithme.sales.Domain.Model.Queries.GetFarmerProductByIdQuery;

import java.util.List;
import java.util.Optional;

public interface FarmerProductQueryService {
    Optional<FarmerProductPrice> handle (GetFarmerProductByIdQuery query);
    List<FarmerProductPrice> handle(GetAllFarmerProductPriceQuery query);

}
