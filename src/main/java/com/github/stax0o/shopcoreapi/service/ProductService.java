package com.github.stax0o.shopcoreapi.service;

import com.github.stax0o.shopcoreapi.dto.ProductDTO;
import com.github.stax0o.shopcoreapi.mapper.ProductMapper;
import com.github.stax0o.shopcoreapi.model.Product;
import com.github.stax0o.shopcoreapi.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Transactional
    public ProductDTO create(ProductDTO productDTO) {
        Product product = productMapper.toModel(productDTO);
        return productMapper.toDTO(productRepository.save(product));
    }

    public List<ProductDTO> findAll() {
        return productMapper.toDTOList(productRepository.findAll());
    }

    @Transactional
    public ProductDTO update(ProductDTO productDTO) {
        Product product = productRepository.findById(productDTO.id())
                .orElseThrow(() -> new IllegalArgumentException("Такого товара не существует"));
        product.setName(productDTO.name());
        product.setPrice(productDTO.price());
        product.setDescription(productDTO.description());
        product.setUpdatedAt(LocalDate.now());
        return productMapper.toDTO(productRepository.save(product));
    }

    public ProductDTO delete(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Товара с таким id не существует"));
        productRepository.delete(product);
        return productMapper.toDTO(product);
    }

    public ProductDTO findByName(String name) {
        Product product = productRepository.findByName(name);
        return productMapper.toDTO(product);
    }
}
