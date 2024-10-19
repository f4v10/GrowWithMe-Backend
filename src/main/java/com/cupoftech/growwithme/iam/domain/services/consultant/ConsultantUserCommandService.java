package com.cupoftech.growwithme.iam.domain.services.consultant;

import com.cupoftech.growwithme.iam.domain.model.aggregates.ConsultantUser;
import com.cupoftech.growwithme.iam.domain.model.commands.consultant.CreateConsultantUserCommand;
import com.cupoftech.growwithme.iam.domain.model.commands.consultant.DeleteConsultantUserCommand;

import java.util.Optional;

public interface ConsultantUserCommandService {
    Optional<ConsultantUser> handle(CreateConsultantUserCommand command);
    void handle(DeleteConsultantUserCommand command);
}
