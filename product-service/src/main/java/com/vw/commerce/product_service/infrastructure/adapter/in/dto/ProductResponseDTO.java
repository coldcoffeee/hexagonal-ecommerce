package com.vw.commerce.product_service.infrastructure.adapter.in.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class ProductResponseDTO {

    private UUID id;
    private String name;
    private BigDecimal price;
    private Integer quantity;

    private String description;
}
