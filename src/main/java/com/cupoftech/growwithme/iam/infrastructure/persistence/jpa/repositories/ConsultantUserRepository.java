package com.cupoftech.growwithme.iam.infrastructure.persistence.jpa.repositories;

import com.cupoftech.growwithme.iam.domain.model.aggregates.ConsultantUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultantUserRepository extends JpaRepository<ConsultantUser, Long> {
}
