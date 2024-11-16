package com.cupoftech.growwithme.sales.interfaces.rest;

import com.cupoftech.growwithme.sales.domain.model.commands.DeleteFarmerProductCommand;
import com.cupoftech.growwithme.sales.domain.model.queries.GetAllFarmerProductPricesQuery;
import com.cupoftech.growwithme.sales.domain.model.queries.GetFarmerProductByIdQuery;
import com.cupoftech.growwithme.sales.domain.services.FarmerProductCommandService;
import com.cupoftech.growwithme.sales.domain.services.FarmerProductQueryService;
import com.cupoftech.growwithme.sales.interfaces.rest.resources.CreateFarmerProductPriceResource;
import com.cupoftech.growwithme.sales.interfaces.rest.resources.FarmerProductPriceResource;
import com.cupoftech.growwithme.sales.interfaces.rest.resources.UpdateFarmerProductPriceResource;
import com.cupoftech.growwithme.sales.interfaces.rest.transform.CreateFarmerProductPriceCommandFromResourceAssembler;
import com.cupoftech.growwithme.sales.interfaces.rest.transform.FarmerProductPriceFromEntityAssembler;
import com.cupoftech.growwithme.sales.interfaces.rest.transform.UpdateFarmerProductPriceCommandFromAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/farmer-product-prices", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "FarmerProductPrices", description = "Farmer Product Price Management Endpoints")
public class FarmerProductPricesController {
    private final FarmerProductCommandService farmerProductCommandService;
    private final FarmerProductQueryService farmerProductQueryService;

    public FarmerProductPricesController(FarmerProductCommandService farmerProductCommandService, FarmerProductQueryService farmerProductQueryService) {
        this.farmerProductCommandService = farmerProductCommandService;
        this.farmerProductQueryService = farmerProductQueryService;
    }

    @PostMapping
    public ResponseEntity<FarmerProductPriceResource> createFarmerProductPrice(@RequestBody CreateFarmerProductPriceResource resource) {
        var createFarmerProductCommand = CreateFarmerProductPriceCommandFromResourceAssembler.toCommandFromResource(resource);
        var farmerProductPrice = farmerProductCommandService.handle(createFarmerProductCommand);
        if(farmerProductPrice.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var farmerProductPriceResource = FarmerProductPriceFromEntityAssembler.toResourceFromEntity(farmerProductPrice.get());
        return new ResponseEntity<>(farmerProductPriceResource, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FarmerProductPriceResource>> getAllFarmerProductPrices() {
        var getAllFarmerProductPriceQuery = new GetAllFarmerProductPricesQuery();
        var farmerProductPrices = farmerProductQueryService.handle(getAllFarmerProductPriceQuery);
        var farmerProductPriceResources = farmerProductPrices.stream()
                .map(FarmerProductPriceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(farmerProductPriceResources);
    }

    @GetMapping("/{farmerProductPriceId}")
    public ResponseEntity<FarmerProductPriceResource> getFarmerProductPriceById(@PathVariable Long farmerProductPriceId) {
        var getFarmerProductPriceQuery = new GetFarmerProductByIdQuery(farmerProductPriceId);
        var farmerProductPrice = farmerProductQueryService.handle(getFarmerProductPriceQuery);
        if(farmerProductPrice.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var farmerProductPriceResource = FarmerProductPriceFromEntityAssembler.toResourceFromEntity(farmerProductPrice.get());
        return ResponseEntity.ok(farmerProductPriceResource);
    }

    @PutMapping("/{farmerProductPriceId}")
    public ResponseEntity<FarmerProductPriceResource> updateFarmerProductPrice(@PathVariable Long farmerProductPriceId, @RequestBody UpdateFarmerProductPriceResource resource) {
        var updateFarmerProductCommand = UpdateFarmerProductPriceCommandFromAssembler.toCommandFromResource(farmerProductPriceId, resource);
        var farmerProductPrice = farmerProductCommandService.handle(updateFarmerProductCommand);
        if(farmerProductPrice.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var farmerProductPriceResource = FarmerProductPriceFromEntityAssembler.toResourceFromEntity(farmerProductPrice.get());
        return ResponseEntity.ok(farmerProductPriceResource);
    }

    @DeleteMapping("/{farmerProductPriceId}")
    public ResponseEntity<?> deleteFarmerProductPrice(@PathVariable Long farmerProductPriceId) {
        var deleteFarmerProductPriceCommand = new DeleteFarmerProductCommand(farmerProductPriceId);
        farmerProductCommandService.handle(deleteFarmerProductPriceCommand);
        return ResponseEntity.ok("Farmer Product Price with given id successfully deleted");
    }
}
