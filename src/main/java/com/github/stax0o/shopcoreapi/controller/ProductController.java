package com.github.stax0o.shopcoreapi.controller;

import com.github.stax0o.shopcoreapi.dto.ProductDTO;
import com.github.stax0o.shopcoreapi.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ProductDTO create(@Valid @RequestBody ProductDTO productDTO) {
        return productService.create(productDTO);
    }

    @GetMapping("/findAll")
    public List<ProductDTO> findAll() {
        return productService.findAll();
    }

    @GetMapping
    public ProductDTO findByName(@Valid @RequestParam String name) {
        return productService.findByName(name);
    }

    @PutMapping
    public ProductDTO update(@Valid @RequestBody ProductDTO productDTO) {
        return productService.update(productDTO);
    }

    @DeleteMapping
    public ProductDTO delete(@RequestParam Long id) {
        return productService.delete(id);
    }
}
