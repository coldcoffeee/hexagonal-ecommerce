package com.vw.commerce.user_service.infrastructure.persistence;

import com.vw.commerce.user_service.domain.model.User;
import com.vw.commerce.user_service.domain.repository.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class JpaUserRepository implements UserRepository {

    private final SpringDataUserRepository repository;

    public JpaUserRepository(SpringDataUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<User> findById(UUID id) {
        return repository.findById(id).map(UserEntity::toDomain);
    }

    @Override
    public void save(User user) {
        repository.save(new UserEntity(user));
    }

    @Override
    public Boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }
}


interface SpringDataUserRepository extends JpaRepository<UserEntity, UUID> {
    Boolean existsByEmail(String email);
}
