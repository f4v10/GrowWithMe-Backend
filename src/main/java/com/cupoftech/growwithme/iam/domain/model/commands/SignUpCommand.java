package com.cupoftech.growwithme.iam.domain.model.commands;

import com.cupoftech.growwithme.iam.domain.model.entities.Role;

import java.util.List;

public record SignUpCommand(String email, String password, List<Role> roles) {
}
