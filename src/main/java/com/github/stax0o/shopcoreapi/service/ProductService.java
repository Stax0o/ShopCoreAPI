package com.github.stax0o.shopcoreapi.service;

import com.github.stax0o.shopcoreapi.dto.ProductDTO;
import com.github.stax0o.shopcoreapi.mapper.ProductMapper;
import com.github.stax0o.shopcoreapi.model.Product;
import com.github.stax0o.shopcoreapi.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
