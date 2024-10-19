package com.cupoftech.growwithme.iam.application.farmer;

import com.cupoftech.growwithme.iam.domain.model.aggregates.FarmerUser;
import com.cupoftech.growwithme.iam.domain.model.commands.farmer.CreateFarmerUserCommand;
import com.cupoftech.growwithme.iam.domain.model.commands.farmer.DeleteFarmerUserCommand;
import com.cupoftech.growwithme.iam.domain.services.farmer.FarmerUserCommandService;
import com.cupoftech.growwithme.iam.infrastructure.persistence.jpa.repositories.FarmerUserRepository;

import java.util.Optional;

public class FarmerUserCommandServiceImpl implements FarmerUserCommandService {
    private final FarmerUserRepository repository;

    public FarmerUserCommandServiceImpl(FarmerUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<FarmerUser> handle(CreateFarmerUserCommand command) {
        var farmer = new FarmerUser(command);
        var createdFarmer = repository.save(farmer);
        return Optional.of(createdFarmer);
    }

    @Override
    public void handle(DeleteFarmerUserCommand command) {
        repository.deleteById(command.id());
    }
}
