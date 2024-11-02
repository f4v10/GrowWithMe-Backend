package com.cupoftech.growwithme.crops.infrastructure.persistence.jpa.repositories;

import com.cupoftech.growwithme.crops.domain.model.aggregates.Crop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CropRepository extends JpaRepository<Crop, Long> {
}