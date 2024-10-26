package com.cupoftech.growwithme.iam.application.crop;

import com.cupoftech.growwithme.iam.domain.model.aggregates.Crops;
import com.cupoftech.growwithme.iam.domain.model.queries.crop.GetAllCropsQuery;
import com.cupoftech.growwithme.iam.domain.model.queries.crop.GetCropsByIdQuery;
import com.cupoftech.growwithme.iam.domain.services.crop.CropsQueryService;
import com.cupoftech.growwithme.iam.infrastructure.persistence.jpa.repositories.CropsRepository;

import java.util.List;
import java.util.Optional;

public class CropsQueryServiceImpl implements CropsQueryService {
    private final CropsRepository repository;

    public CropsQueryServiceImpl(CropsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Crops> handle(GetAllCropsQuery query) {
        return repository.findAll();
    }

    @Override
    public Optional<Crops> handle(GetCropsByIdQuery query) {
        return repository.findById(query.id());
    }
}