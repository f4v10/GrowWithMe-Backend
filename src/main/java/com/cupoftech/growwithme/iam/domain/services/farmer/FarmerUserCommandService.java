package com.cupoftech.growwithme.iam.domain.services.farmer;

import com.cupoftech.growwithme.iam.domain.model.aggregates.FarmerUser;
import com.cupoftech.growwithme.iam.domain.model.commands.farmer.CreateFarmerUserCommand;
import com.cupoftech.growwithme.iam.domain.model.commands.farmer.DeleteFarmerUserCommand;

import java.util.Optional;

public interface FarmerUserCommandService {
    Optional<FarmerUser> handle(CreateFarmerUserCommand command);
    void handle(DeleteFarmerUserCommand command);
}
