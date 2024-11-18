package com.cupoftech.growwithme.iam.infrastructure.hashing.bcrypt;

import com.cupoftech.growwithme.iam.application.internal.outboundservices.hashing.HashingService;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface BCryptHashingService extends HashingService, PasswordEncoder {
}
