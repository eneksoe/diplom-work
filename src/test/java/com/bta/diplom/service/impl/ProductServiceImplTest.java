package com.bta.diplom.service.impl;

import com.bta.diplom.dto.ProductDto;
import com.bta.diplom.mapper.WebMapper;
import com.bta.diplom.model.Product;
import com.bta.diplom.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

@Mock
    private ProductRepository productRepository;

@Mock
    private WebMapper<ProductDto, Product> mapper;

@InjectMocks
    private ProductServiceImpl instanceUnderTest;

    @Test
    public void testIsProductCreated(){
        lenient().when(productRepository.findBySkuCode(any())).thenReturn(Product.builder().build());
        instanceUnderTest.create(ProductDto.builder().build());
        verify(productRepository, never()).save(Product.builder().build());
    }
}