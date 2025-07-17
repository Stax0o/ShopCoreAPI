package com.github.stax0o.shopcoreapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductDTO(
        @NotBlank(message = "Название продукта не должно быть пустым")
        String name,
        @Positive(message = "Стоимость должна быть больше 0")
        BigDecimal price,
        String description
) {
}
