package com.cupoftech.growwithme.iam.infrastructure.persistence.jpa.repositories;

import com.cupoftech.growwithme.iam.domain.model.aggregates.CropsRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CropsRepository extends JpaRepository<Crops, Long> {
}