package com.cupoftech.growwithme.iam.application.crop;

import com.cupoftech.growwithme.iam.domain.model.aggregates.Crops;
import com.cupoftech.growwithme.iam.domain.model.commands.crop.CreateCropsCommand;
import com.cupoftech.growwithme.iam.domain.model.commands.crop.DeleteCropsCommand;
import com.cupoftech.growwithme.iam.domain.services.crop.CropsCommandService;
import com.cupoftech.growwithme.iam.infrastructure.persistence.jpa.repositories.CropsRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CropsCommandServiceImpl implements CropsCommandService {
    private final CropsRepository repository;

    public CropsCommandServiceImpl(CropsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Crops> handle(CreateCropsCommand command) {
        var crop = new Crops(command);
        var createdCrop = repository.save(crop);
        return Optional.of(createdCrop);
    }

    @Override
    public void handle(DeleteCropsCommand command) {
        repository.deleteById(command.id());
    }
}
