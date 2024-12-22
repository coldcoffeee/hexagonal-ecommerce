package com.vw.commerce.product_service.infrastructure.adapter.in.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.Min;
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

    @NotNull(message = "Quantity cannot be null")
    @Min(message = "Quantity cannot be zero", value = 1)
    private Integer quantity;

    private String description;
}
