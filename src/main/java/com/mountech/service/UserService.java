package com.mountech.service;

import com.mountech.domain.User;
import com.mountech.domain.security.PasswordResetToken;

public interface UserService {
    PasswordResetToken getPasswordResetToken(final String token);
    void createPasswordResetTokenForUser(final User user, final String token);
}
