package com.vw.commerce.user_service.infrastructure.persistence;

import com.vw.commerce.user_service.domain.model.User;
import com.vw.commerce.user_service.domain.model.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"email"}))
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotNull(message = "User name can not be null")
    private String name;
    @Email(message = "Must be a valid email")
    @NotNull(message = "Email can not be null")
    private String email;
    private String password;
    private Role role = Role.CUSTOMER;

    public UserEntity(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.role = user.getRole();
    }

    public User toDomain() {
        return new User(this.id, this.name, this.email, this.password, this.role);
    }
}
