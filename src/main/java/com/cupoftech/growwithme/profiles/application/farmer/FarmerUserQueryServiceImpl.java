package com.cupoftech.growwithme.profiles.application.farmer;

import com.cupoftech.growwithme.profiles.domain.model.aggregates.FarmerUser;
import com.cupoftech.growwithme.profiles.domain.model.queries.farmer.GetAllFarmerUsersQuery;
import com.cupoftech.growwithme.profiles.domain.model.queries.farmer.GetFarmerUserByIdQuery;
import com.cupoftech.growwithme.profiles.domain.services.farmer.FarmerUserQueryService;
import com.cupoftech.growwithme.profiles.infrastructure.persistence.jpa.repositories.FarmerUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
