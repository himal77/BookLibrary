package com.mountech.service;

import com.mountech.domain.User;
import com.mountech.domain.security.PasswordResetToken;
import com.mountech.domain.security.UserRole;
import org.springframework.context.annotation.Bean;

import java.util.Set;

public interface UserService {
    PasswordResetToken getPasswordResetToken(final String token);
    void createPasswordResetTokenForUser(final User user, final String token);
    User findByUsername(String username);
    User findByEmail(String email);
    User createUser(User user, Set<UserRole> userRoles) throws Exception;
}
