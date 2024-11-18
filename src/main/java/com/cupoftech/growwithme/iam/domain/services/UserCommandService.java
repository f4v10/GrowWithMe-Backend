package com.cupoftech.growwithme.iam.domain.services;

import com.cupoftech.growwithme.iam.domain.model.aggregates.User;
import com.cupoftech.growwithme.iam.domain.model.commands.SignInCommand;
import com.cupoftech.growwithme.iam.domain.model.commands.SignUpCommand;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.Optional;

public interface UserCommandService {
    Optional<User> handle(SignUpCommand command);
    Optional<ImmutablePair<User, String>> handle(SignInCommand command);
}
