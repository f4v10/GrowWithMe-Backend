package com.cupoftech.growwithme.crops.application;

import com.cupoftech.growwithme.crops.domain.model.aggregates.Crop;
import com.cupoftech.growwithme.crops.domain.model.queries.GetAllCropsQuery;
import com.cupoftech.growwithme.crops.domain.model.queries.GetCropByIdQuery;
import com.cupoftech.growwithme.crops.domain.services.CropQueryService;
import com.cupoftech.growwithme.crops.infrastructure.persistence.jpa.repositories.CropRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CropQueryServiceImpl implements CropQueryService {
    private final CropRepository repository;

    public CropQueryServiceImpl(CropRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Crop> handle(GetAllCropsQuery query) {
        return repository.findAll();
    }

    @Override
    public Optional<Crop> handle(GetCropByIdQuery query) {
        return repository.findById(query.id());
    }
}