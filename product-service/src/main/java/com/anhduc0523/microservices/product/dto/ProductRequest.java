package com.anhduc0523.microservices.product.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductRequest(
        @NotBlank String id,
        @NotBlank String name,
        @NotBlank String description,
        @NotNull @Positive BigDecimal price
) {
}
