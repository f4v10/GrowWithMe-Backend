package com.cupoftech.growwithme.iam.application.farmer;

import com.cupoftech.growwithme.iam.domain.model.aggregates.FarmerUser;
import com.cupoftech.growwithme.iam.domain.model.queries.farmer.GetAllFarmerUsersQuery;
import com.cupoftech.growwithme.iam.domain.model.queries.farmer.GetFarmerUserByIdQuery;
import com.cupoftech.growwithme.iam.domain.services.farmer.FarmerUserQueryService;
import com.cupoftech.growwithme.iam.infrastructure.persistence.jpa.repositories.FarmerUserRepository;

import java.util.List;
import java.util.Optional;

public class FarmerUserQueryServiceImpl implements FarmerUserQueryService {
    private final FarmerUserRepository repository;

    public FarmerUserQueryServiceImpl(FarmerUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<FarmerUser> handle(GetAllFarmerUsersQuery query) {
        return repository.findAll();
    }

    @Override
    public Optional<FarmerUser> handle(GetFarmerUserByIdQuery query) {
        return repository.findById(query.id());
    }
}
