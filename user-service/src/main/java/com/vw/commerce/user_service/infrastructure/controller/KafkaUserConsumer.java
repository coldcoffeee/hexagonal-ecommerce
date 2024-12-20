package com.vw.commerce.user_service.infrastructure.controller;

import com.vw.commerce.user_service.application.UserService;
import com.vw.commerce.user_service.domain.model.User;
import com.vw.commerce.user_service.domain.model.Role;
import com.vw.commerce.user_service.infrastructure.dto.UserRequestDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaUserConsumer {

    private final UserService userService;
    private final ObjectMapper objectMapper;

    public KafkaUserConsumer(UserService userService, ObjectMapper objectMapper) {
        this.userService = userService;
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "user-topic", groupId = "user-service-group")
    public void consume(String message) {
        try {
            UserRequestDTO userRequestDTO = objectMapper.readValue(message, UserRequestDTO.class);

            User user = new User();
            user.setName(userRequestDTO.getName());
            user.setEmail(userRequestDTO.getEmail());
            user.setPassword(userRequestDTO.getPassword());
            user.setRole(userRequestDTO.getRole() != null ? userRequestDTO.getRole() : Role.CUSTOMER);

            userService.createUser(user);

            System.out.println("User created successfully via Kafka Consumer!");

        } catch (Exception e) {
            System.err.println("Error processing Kafka message: " + e.getMessage());
        }
    }
}
