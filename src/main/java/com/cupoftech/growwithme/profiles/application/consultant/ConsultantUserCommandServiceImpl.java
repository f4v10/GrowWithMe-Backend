package com.cupoftech.growwithme.profiles.application.consultant;

import com.cupoftech.growwithme.profiles.domain.model.aggregates.ConsultantUser;
import com.cupoftech.growwithme.profiles.domain.model.commands.consultant.CreateConsultantUserCommand;
import com.cupoftech.growwithme.profiles.domain.model.commands.consultant.DeleteConsultantUserCommand;
import com.cupoftech.growwithme.profiles.domain.services.consultant.ConsultantUserCommandService;
import com.cupoftech.growwithme.profiles.infrastructure.persistence.jpa.repositories.ConsultantUserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConsultantUserCommandServiceImpl implements ConsultantUserCommandService {
    private final ConsultantUserRepository repository;

    public ConsultantUserCommandServiceImpl(ConsultantUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<ConsultantUser> handle(CreateConsultantUserCommand command) {
        var consultant = new ConsultantUser(command);
        var createdConsultant = repository.save(consultant);
        return Optional.of(createdConsultant);
    }

    @Override
    public void handle(DeleteConsultantUserCommand command) {
        repository.deleteById(command.id());
    }
}
