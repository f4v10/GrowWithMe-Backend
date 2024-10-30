package com.cupoftech.growwithme.profiles.infrastructure.persistence.jpa.repositories;

import com.cupoftech.growwithme.profiles.domain.model.aggregates.FarmerUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmerUserRepository extends JpaRepository<FarmerUser, Long> {
}
