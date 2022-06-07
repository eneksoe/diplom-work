package com.bta.diplom.mapper;

import com.bta.diplom.dto.ProductDto;
import com.bta.diplom.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductWebMapper implements WebMapper<ProductDto, Product>{

    @Override
    public ProductDto toDto(Product entity) {
        return ProductDto.builder()
                .name(entity.getName())
                .skuCode(entity.getSkuCode())
                .unitPrice(entity.getUnitPrice())
                .orderLineCount(entity.getOrderLines().size())
                .build();
    }

    @Override
    public Product toEntity(ProductDto dto) {
        return Product.builder()
                .name(dto.getName())
                .skuCode(dto.getSkuCode())
                .unitPrice(dto.getUnitPrice())
                .build();
    }
}
