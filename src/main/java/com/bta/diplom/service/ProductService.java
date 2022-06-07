package com.bta.diplom.service;

import com.bta.diplom.dto.ProductDto;

import java.util.List;


public interface ProductService {

    List<ProductDto> getAll();

    void create(ProductDto product);

    void update(ProductDto product);
}
