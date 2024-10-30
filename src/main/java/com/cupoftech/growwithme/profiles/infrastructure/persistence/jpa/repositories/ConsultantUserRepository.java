package com.cupoftech.growwithme.profiles.infrastructure.persistence.jpa.repositories;

import com.cupoftech.growwithme.profiles.domain.model.aggregates.ConsultantUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultantUserRepository extends JpaRepository<ConsultantUser, Long> {
}
