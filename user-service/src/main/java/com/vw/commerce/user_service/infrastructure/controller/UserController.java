package com.vw.commerce.user_service.infrastructure.controller;

import com.vw.commerce.user_service.application.UserService;
import com.vw.commerce.user_service.domain.model.User;
import com.vw.commerce.user_service.infrastructure.dto.UserRequestDTO;
import com.vw.commerce.user_service.infrastructure.dto.UserResponseDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserRequestDTO userDTO) {
        var user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        userService.createUser(user);
        return new ResponseEntity<>("User created successfully!", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable UUID id) {
        var user = userService.getUserById(id).orElse(null);
        if(user == null) {
            return ResponseEntity.notFound().build();
        }
        var userResponseObject = new UserResponseDTO();
        userResponseObject.setId(user.getId());
        userResponseObject.setEmail(user.getEmail());
        userResponseObject.setName(user.getName());
        userResponseObject.setRole(user.getRole());
        return ResponseEntity.ok(userResponseObject);
    }
}
