package com.github.stax0o.shopcoreapi.service;

import com.github.stax0o.shopcoreapi.dto.ProductDTO;
import com.github.stax0o.shopcoreapi.mapper.ProductMapper;
import com.github.stax0o.shopcoreapi.model.Product;
import com.github.stax0o.shopcoreapi.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.annotation.Primary;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private ProductService productService;

    @Test
    void create() {
        ProductDTO productDTO = new ProductDTO(null, "Apple", BigDecimal.valueOf(100), "jowiefjoiwfjoiwefjow");
        ProductDTO savedProductDTO = new ProductDTO(null, "Apple", BigDecimal.valueOf(100), "jowiefjoiwfjoiwefjow");
        Product product = new Product();
        Product savedProduct = new Product();

        when(productMapper.toModel(productDTO)).thenReturn(product);
        when(productRepository.save(product)).thenReturn(savedProduct);
        when(productMapper.toDTO(savedProduct)).thenReturn(savedProductDTO);

        ProductDTO result = productService.create(productDTO);

        assertEquals(savedProductDTO, result);
        verify(productRepository).save(product);
    }

    @Test
    void findAll() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void findByName() {
    }
}