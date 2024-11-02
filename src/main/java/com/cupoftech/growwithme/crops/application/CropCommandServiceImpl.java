package com.cupoftech.growwithme.crops.application;

import com.cupoftech.growwithme.crops.domain.model.aggregates.Crop;
import com.cupoftech.growwithme.crops.domain.model.commands.CreateCropCommand;
import com.cupoftech.growwithme.crops.domain.model.commands.DeleteCropCommand;
import com.cupoftech.growwithme.crops.domain.services.CropCommandService;
import com.cupoftech.growwithme.crops.infrastructure.persistence.jpa.repositories.CropRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CropCommandServiceImpl implements CropCommandService {
    private final CropRepository repository;

    public CropCommandServiceImpl(CropRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Crop> handle(CreateCropCommand command) {
        var crop = new Crop(command);
        var createdCrop = repository.save(crop);
        return Optional.of(createdCrop);
    }

    @Override
    public void handle(DeleteCropCommand command) {
        repository.deleteById(command.id());
    }
}
