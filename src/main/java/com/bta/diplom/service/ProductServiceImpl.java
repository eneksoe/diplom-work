package com.bta.diplom.service;

import com.bta.diplom.dto.ProductDto;
import com.bta.diplom.mapper.WebMapper;
import com.bta.diplom.model.Product;
import com.bta.diplom.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository repository;

    @Autowired
    private WebMapper<ProductDto, Product> mapper;
    @Override
    public List<ProductDto> getAll() {
        return mapper.toDtos(repository.findAll());
    }

    @Override
    public void create(ProductDto product) {
        final Product entity = mapper.toEntity(product);
        repository.save(entity);

    }

    @Override
    public void update(ProductDto product) {
        create(product);

    }
}
