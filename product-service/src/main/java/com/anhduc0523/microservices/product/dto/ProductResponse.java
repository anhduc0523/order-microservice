package com.anhduc0523.microservices.product.dto;

import com.anhduc0523.microservices.product.model.Product;

import java.math.BigDecimal;

public record ProductResponse(String id, String name, String description, BigDecimal price) {
    public static ProductResponse fromProduct(Product product) {
        return new ProductResponse(
            product.getId(),
            product.getName(),
            product.getDescription(),
            product.getPrice()
        );
    }
}
