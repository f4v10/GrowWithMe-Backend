package com.cupoftech.growwithme.iam.domain.services.consultant;

import com.cupoftech.growwithme.iam.domain.model.aggregates.ConsultantUser;
import com.cupoftech.growwithme.iam.domain.model.queries.consultant.GetAllConsultantUsersQuery;
import com.cupoftech.growwithme.iam.domain.model.queries.consultant.GetConsultantUserByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ConsultantUserQueryService {
    List<ConsultantUser> handle(GetAllConsultantUsersQuery query);
    Optional<ConsultantUser> handle(GetConsultantUserByIdQuery query);
}
