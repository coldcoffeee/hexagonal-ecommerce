package com.vw.commerce.user_service.infrastructure.dto;

import com.vw.commerce.user_service.domain.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {

    @NotNull(message = "Name cannot be null")
    private String name;

    @Email(message = "Email must be valid")
    private String email;

    @NotNull(message = "Password cannot be null")
    private String password;

    private Role role;
}
