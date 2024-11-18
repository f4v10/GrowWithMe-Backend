package com.cupoftech.growwithme.iam.application.internal.queryservices;

import com.cupoftech.growwithme.iam.domain.model.entities.Role;
import com.cupoftech.growwithme.iam.domain.model.queries.GetAllRolesQuery;
import com.cupoftech.growwithme.iam.domain.model.queries.GetRoleByNameQuery;
import com.cupoftech.growwithme.iam.domain.services.RoleQueryService;
import com.cupoftech.growwithme.iam.infrastructure.persistence.jpa.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleQueryServiceImpl implements RoleQueryService {
    private final RoleRepository roleRepository;

    public RoleQueryServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> handle(GetAllRolesQuery query) {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> handle(GetRoleByNameQuery query) {
        return roleRepository.findByName(query.name());
    }
}
