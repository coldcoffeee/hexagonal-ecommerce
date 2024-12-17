package com.vw.commerce.user_service.infrastructure.dto;

import com.vw.commerce.user_service.domain.model.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserResponseDTO {

    private UUID id;
    private String name;
    private String email;
    private Role role;
}
