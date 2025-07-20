package com.github.stax0o.shopcoreapi.service;

import com.github.stax0o.shopcoreapi.dto.ProductDTO;
import com.github.stax0o.shopcoreapi.mapper.ProductMapper;
import com.github.stax0o.shopcoreapi.model.Product;
import com.github.stax0o.shopcoreapi.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Transactional
    public ProductDTO create(ProductDTO productDTO) {
        log.info("Creating product: name={}", productDTO.name());
        Product product = productMapper.toModel(productDTO);
        Product savedProduct = productRepository.save(product);
        ProductDTO result = productMapper.toDTO(savedProduct);
        log.info("Product created successfully: id={}, name={}", result.id(), result.name());
        return result;
    }

    public List<ProductDTO> findAll() {
        log.info("Fetching all products");
        List<ProductDTO> products = productMapper.toDTOList(productRepository.findAll());
        log.info("Found {} products", products.size());
        return products;
    }

    @Transactional
    public ProductDTO update(ProductDTO productDTO) {
        log.info("Updating product: id={}", productDTO.id());
        Product product = productRepository.findById(productDTO.id())
                .orElseThrow(() -> {
                    log.warn("Product not found for update: id={}", productDTO.id());
                    return new IllegalArgumentException("Такого товара не существует");
                });

        product.setName(productDTO.name());
        product.setPrice(productDTO.price());
        product.setDescription(productDTO.description());
        product.setUpdatedAt(LocalDate.now());
        Product updatedProduct = productRepository.save(product);
        ProductDTO result = productMapper.toDTO(updatedProduct);
        log.info("Product updated successfully: id={}, name={}", result.id(), result.name());
        return result;
    }

    @Transactional
    public ProductDTO delete(Long id) {
        log.info("Deleting product: id={}", id);
        Product product = productRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Product not found for deletion: id={}", id);
                    return new IllegalArgumentException("Товара с таким id не существует");
                });
        productRepository.delete(product);
        log.info("Product deleted successfully: id={}, name={}", product.getId(), product.getName());
        return productMapper.toDTO(product);
    }

    public ProductDTO findByName(String name) {
        log.info("Searching for product by name: {}", name);
        Product product = productRepository.findByName(name);
        if (product == null) {
            log.warn("Product not found by name: {}", name);
            throw new IllegalArgumentException("Товар с таким именем не найден");
        }
        log.info("Product found by name: id={}, name={}", product.getId(), product.getName());
        return productMapper.toDTO(product);
    }
}
