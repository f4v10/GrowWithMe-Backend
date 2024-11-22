package com.cupoftech.growwithme.sales.application.internal.commandservices;

import com.cupoftech.growwithme.sales.domain.model.aggregates.FarmerProductPrice;
import com.cupoftech.growwithme.sales.domain.model.commands.CreateFarmerProductCommand;
import com.cupoftech.growwithme.sales.domain.model.commands.DeleteFarmerProductCommand;
import com.cupoftech.growwithme.sales.domain.model.commands.UpdateFarmerProductCommand;
import com.cupoftech.growwithme.sales.domain.model.valueobjects.ProductId;
import com.cupoftech.growwithme.sales.domain.services.FarmerProductCommandService;
import com.cupoftech.growwithme.sales.infrastructure.persistence.jpa.repositories.FarmerProductRepository;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FarmerProductPriceCommandServiceImpl implements FarmerProductCommandService {
    private final FarmerProductRepository farmerProductRepository;

    public FarmerProductPriceCommandServiceImpl(FarmerProductRepository farmerProductRepository) {
        this.farmerProductRepository = farmerProductRepository;
    }

    @Override
    public Optional<FarmerProductPrice> handle(CreateFarmerProductCommand command) {
        if(farmerProductRepository.existsByProductId(new ProductId(command.productId()))){
            throw new IllegalArgumentException("Farmer Product already exists");
        }
        var farmerProduct = new FarmerProductPrice(command);
        try {
            farmerProductRepository.save(farmerProduct);

        } catch (Exception e) {
            throw new IllegalArgumentException("Error saving farmer product: "+ e.getMessage());
        }
        return Optional.of(farmerProduct);
    }

    @Override
    public Optional<FarmerProductPrice> handle(UpdateFarmerProductCommand command) {
        if(farmerProductRepository.existsById(command.farmerProductPriceId()))
            throw new IllegalArgumentException("Farmer Product already exists");
        var result = farmerProductRepository.findById(command.farmerProductPriceId());
        if(result.isEmpty())
            throw new IllegalArgumentException("Farmer Product not found");
        var farmerProductPriceToUpdate = result.get();
        try{
            var updateFarmerProduct = farmerProductRepository.save(farmerProductPriceToUpdate.updateFarmerProductPriced(command.money(),command.quantityProduct(),command.amount()));
            return Optional.of(updateFarmerProduct);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error updating farmer product: "+ e.getMessage());
        }
    }

    @Override
    public void handle(DeleteFarmerProductCommand command) {
        if(farmerProductRepository.existsById(command.farmerProductPriceId()))
            throw new IllegalArgumentException("Farmer Product already exists");


        try{
            farmerProductRepository.deleteById(command.farmerProductPriceId());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error deleting farmer product: "+ e.getMessage());
        }
    }

}
