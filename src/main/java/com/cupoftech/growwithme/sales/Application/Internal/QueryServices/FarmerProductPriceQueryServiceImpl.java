package com.cupoftech.growwithme.sales.Application.Internal.QueryServices;

import com.cupoftech.growwithme.sales.Domain.Model.Aggregates.FarmerProductPrice;
import com.cupoftech.growwithme.sales.Domain.Model.Queries.GetAllFarmerProductPriceQuery;
import com.cupoftech.growwithme.sales.Domain.Model.Queries.GetFarmerProductByIdQuery;
import com.cupoftech.growwithme.sales.Domain.Services.FarmerProductQueryService;
import com.cupoftech.growwithme.sales.Infrastructure.Persistence.Jpa.Repositories.FarmerProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FarmerProductPriceQueryServiceImpl  implements FarmerProductQueryService {
    private final FarmerProductRepository farmerProductRepository;


    public FarmerProductPriceQueryServiceImpl(FarmerProductRepository farmerProductRepository) {
        this.farmerProductRepository = farmerProductRepository;
    }
    @Override
    public List<FarmerProductPrice> handle  (GetAllFarmerProductPriceQuery query){
        return farmerProductRepository.findAll();
    }



    @Override
    public Optional<FarmerProductPrice> handle (GetFarmerProductByIdQuery query){
        return farmerProductRepository.findById(query.farmerProductId());
    }


}
