package com.github.stax0o.shopcoreapi.repository;

import com.github.stax0o.shopcoreapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
