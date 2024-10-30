package com.cupoftech.growwithme.profiles.domain.services.farmer;

import com.cupoftech.growwithme.profiles.domain.model.aggregates.FarmerUser;
import com.cupoftech.growwithme.profiles.domain.model.commands.farmer.CreateFarmerUserCommand;
import com.cupoftech.growwithme.profiles.domain.model.commands.farmer.DeleteFarmerUserCommand;

import java.util.Optional;

public interface FarmerUserCommandService {
    Optional<FarmerUser> handle(CreateFarmerUserCommand command);
    void handle(DeleteFarmerUserCommand command);
}
