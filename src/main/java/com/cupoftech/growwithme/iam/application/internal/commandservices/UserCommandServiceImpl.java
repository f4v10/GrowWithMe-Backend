package com.cupoftech.growwithme.iam.application.internal.commandservices;

import com.cupoftech.growwithme.iam.application.internal.outboundservices.hashing.HashingService;
import com.cupoftech.growwithme.iam.application.internal.outboundservices.tokens.TokenService;
import com.cupoftech.growwithme.iam.domain.model.aggregates.User;
import com.cupoftech.growwithme.iam.domain.model.commands.SignInCommand;
import com.cupoftech.growwithme.iam.domain.model.commands.SignUpCommand;
import com.cupoftech.growwithme.iam.domain.model.valueobjects.Roles;
import com.cupoftech.growwithme.iam.domain.services.UserCommandService;
import com.cupoftech.growwithme.iam.infrastructure.persistence.jpa.repositories.RoleRepository;
import com.cupoftech.growwithme.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository;
    private final HashingService hashingService;
    private final TokenService tokenService;
    private final RoleRepository roleRepository;

    public UserCommandServiceImpl(UserRepository userRepository, HashingService hashingService, TokenService tokenService, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.hashingService = hashingService;
        this.tokenService = tokenService;
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<User> handle(SignUpCommand command) {
        if (userRepository.existsByEmail(command.email()))
            throw new RuntimeException("Username already exists");
        var roles = command.roles();
        if (roles.isEmpty()) {
            var role = roleRepository.findByName(Roles.ROLE_USER);
            roles.add(role.get());
        }
        roles = command.roles().stream()
                .map(role -> roleRepository.findByName(role.getName())
                        .orElseThrow(() -> new RuntimeException("Role not found"))).toList();
        var user = new User(command.email(), hashingService.encode(command.password()), roles);
        userRepository.save(user);
        return userRepository.findByEmail(command.email());
    }

    @Override
    public Optional<ImmutablePair<User, String>> handle(SignInCommand command) {
        var user = userRepository.findByEmail(command.email());
        if (user.isEmpty()) throw new RuntimeException("User not found");
        if (!hashingService.matches(command.password(), user.get().getPassword()))
            throw new RuntimeException("Invalid password");
        var currentUser = user.get();
        var token = tokenService.generateToken(currentUser.getEmail());
        return Optional.of(ImmutablePair.of(currentUser, token));
    }
}
