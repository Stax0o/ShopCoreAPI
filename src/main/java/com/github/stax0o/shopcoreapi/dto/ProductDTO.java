package com.github.stax0o.shopcoreapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ProductDTO(
        Long id,
        @NotBlank(message = "Название продукта не должно быть пустым")
        @Size(max = 255, message = "Название не должно превышать 255 символов")
        String name,
        @Positive(message = "Стоимость должна быть больше 0")
        BigDecimal price,
        @Size(max = 1000, message = "Описание не должно содержать более 1000 символов")
        String description
) {
}
