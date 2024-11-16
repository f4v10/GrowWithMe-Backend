package com.cupoftech.growwithme.sales.application.internal.queryservices;

import com.cupoftech.growwithme.sales.domain.model.aggregates.FarmerProductPrice;
import com.cupoftech.growwithme.sales.domain.model.queries.GetAllFarmerProductPricesQuery;
import com.cupoftech.growwithme.sales.domain.model.queries.GetFarmerProductByIdQuery;
import com.cupoftech.growwithme.sales.domain.services.FarmerProductQueryService;
import com.cupoftech.growwithme.sales.infrastructure.persistence.jpa.repositories.FarmerProductRepository;
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
    public List<FarmerProductPrice> handle  (GetAllFarmerProductPricesQuery query){
        return farmerProductRepository.findAll();
    }



    @Override
    public Optional<FarmerProductPrice> handle (GetFarmerProductByIdQuery query){
        return farmerProductRepository.findById(query.farmerProductId());
    }


}
