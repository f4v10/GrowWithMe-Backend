package com.cupoftech.growwithme.profiles.interfaces.rest;

import com.cupoftech.growwithme.profiles.domain.model.queries.farmer.GetAllFarmerUsersQuery;
import com.cupoftech.growwithme.profiles.domain.model.queries.farmer.GetFarmerUserByIdQuery;
import com.cupoftech.growwithme.profiles.domain.services.farmer.FarmerUserCommandService;
import com.cupoftech.growwithme.profiles.domain.services.farmer.FarmerUserQueryService;
import com.cupoftech.growwithme.profiles.interfaces.rest.resources.farmer.CreateFarmerUserResource;
import com.cupoftech.growwithme.profiles.interfaces.rest.resources.farmer.FarmerUserResource;
import com.cupoftech.growwithme.profiles.interfaces.rest.transform.farmer.CreateFarmerUserCommandFromResourceAssembler;
import com.cupoftech.growwithme.profiles.interfaces.rest.transform.farmer.FarmerUserResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/farmers", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Farmers", description = "Farmer Users Management Endpoint")
public class FarmerUsersController {
    private final FarmerUserCommandService farmerUserCommandService;
    private final FarmerUserQueryService farmerUserQueryService;

    @PostMapping
    public ResponseEntity<FarmerUserResource> createFarmerUser(@RequestBody CreateFarmerUserResource resource) {
        var createFarmerUserCommand = CreateFarmerUserCommandFromResourceAssembler.toCommandFromResource(resource);
        var farmerUser = farmerUserCommandService.handle(createFarmerUserCommand);
        if (farmerUser.isEmpty()) { return ResponseEntity.badRequest().build(); }
        var farmerUserResource = FarmerUserResourceFromEntityAssembler.toResourceFromEntity(farmerUser.get());
        return new ResponseEntity<>(farmerUserResource, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FarmerUserResource> getFarmerUserById(@PathVariable Long id) {
        var getFarmerUserByIdQuery = new GetFarmerUserByIdQuery(id);
        var farmerUser = farmerUserQueryService.handle(getFarmerUserByIdQuery);
        if (farmerUser.isEmpty()) { return ResponseEntity.notFound().build(); }
        var farmerUserResource = FarmerUserResourceFromEntityAssembler.toResourceFromEntity(farmerUser.get());
        return ResponseEntity.ok(farmerUserResource);
    }

    @GetMapping()
    public ResponseEntity<List<FarmerUserResource>> getAllFarmerUsers() {
        var getAllFarmerUsersQuery = new GetAllFarmerUsersQuery();
        var farmerUsers = farmerUserQueryService.handle(getAllFarmerUsersQuery);
        if (farmerUsers.isEmpty()) { return ResponseEntity.notFound().build(); }
        var farmerUserResources = farmerUsers.stream()
                .map(FarmerUserResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(farmerUserResources);
    }
}
