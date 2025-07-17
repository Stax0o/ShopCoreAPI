package com.github.stax0o.shopcoreapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(nullable = false)
    private BigDecimal price;
    private String description;
    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt = LocalDate.now();
    @Column(name = "updated_at")
    private LocalDate updatedAt;
}
