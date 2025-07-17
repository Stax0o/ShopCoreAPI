package com.github.stax0o.shopcoreapi.mapper;


import com.github.stax0o.shopcoreapi.dto.ProductDTO;
import com.github.stax0o.shopcoreapi.model.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO toDTO(Product product);

    Product toModel(ProductDTO productDTO);

    List<ProductDTO> toDTOList(List<Product> products);

    List<Product> toModelList(List<ProductDTO> productDTOList);
}
