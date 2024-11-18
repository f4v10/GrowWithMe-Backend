package com.cupoftech.growwithme.iam.domain.services;

import com.cupoftech.growwithme.iam.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}
