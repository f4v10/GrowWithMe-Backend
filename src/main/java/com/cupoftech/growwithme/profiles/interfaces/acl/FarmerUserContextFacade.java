package com.cupoftech.growwithme.profiles.interfaces.acl;

import com.cupoftech.growwithme.profiles.domain.model.commands.farmer.CreateFarmerUserCommand;
import com.cupoftech.growwithme.profiles.domain.services.farmer.FarmerUserCommandService;
import com.cupoftech.growwithme.profiles.domain.services.farmer.FarmerUserQueryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FarmerUserContextFacade {
    private final FarmerUserCommandService commandService;
    private final FarmerUserQueryService queryService;

    public Long createFarmerUser(String firstName, String lastName, String email, String phone, String documentType, String valueDocumentType) {
        var createFarmerUserCommand = new CreateFarmerUserCommand(firstName, lastName, email, phone, documentType, valueDocumentType);
        var farmerUser = commandService.handle(createFarmerUserCommand);
        if (farmerUser.isEmpty()) return 0L;
        return farmerUser.get().getId();
    }
}
