package com.vw.commerce.user_service.application;

import com.vw.commerce.user_service.domain.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserService {

    Optional<User> getUserById(UUID id);

    void createUser(User user);

    boolean userExistsByEmail(String email);
}
