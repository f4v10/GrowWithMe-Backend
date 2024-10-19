package com.cupoftech.growwithme.iam.infrastructure.persistence.jpa.repositories;

import com.cupoftech.growwithme.iam.domain.model.aggregates.FarmerUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmerUserRepository extends JpaRepository<FarmerUser, Long> {
}
