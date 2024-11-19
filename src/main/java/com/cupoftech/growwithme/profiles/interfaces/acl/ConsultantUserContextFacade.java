package com.cupoftech.growwithme.profiles.interfaces.acl;

import com.cupoftech.growwithme.profiles.domain.model.commands.consultant.CreateConsultantUserCommand;
import com.cupoftech.growwithme.profiles.domain.services.consultant.ConsultantUserCommandService;
import com.cupoftech.growwithme.profiles.domain.services.consultant.ConsultantUserQueryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConsultantUserContextFacade {
    private final ConsultantUserCommandService commandService;
    private final ConsultantUserQueryService queryService;

    Long createConsultantUser(String firstName, String lastName, String email, String phone, String dni) {
        var createConsultantUserCommand = new CreateConsultantUserCommand(firstName, lastName, email, phone, dni);
        var consultantUser = commandService.handle(createConsultantUserCommand);
        if (consultantUser.isEmpty()) return 0L;
        return consultantUser.get().getId();
    }
}
