package com.vw.commerce.user_service.domain.repository;

import com.vw.commerce.user_service.domain.model.User;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    Optional<User> findById(UUID id);
    void save(User user);
    Boolean existsByEmail(String email);
}
