package com.vw.commerce.product_service.infrastructure.adapter.in.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO {

    @NotNull(message = "Product name cannot be null")
    private String name;

    @NotNull(message = "Price cannot be null")
    private BigDecimal price;
}
