package com.bta.diplom.service;

import com.bta.diplom.dto.ProductDto;
import com.bta.diplom.mapper.WebMapper;
import com.bta.diplom.model.Product;
import com.bta.diplom.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private WebMapper<ProductDto, Product> mapper;

    @Override
    public List<ProductDto> getAll() {
        log.debug("Someone request All Products. DEBUG!!!");
        log.info("Someone request All Products. INFO!!!");
        log.warn("Someone request All Products. WARN!!!");
        log.error("Someone request All Products. ERROR!!!");
        return mapper.toDtos(repository.findAll());
    }

    @Override
    public void create(ProductDto product) {
        final Product entity = mapper.toEntity(product);
        repository.save(entity);

    }

    @Transactional
    @Override
    public ProductDto update(ProductDto product) {
        final Integer skuCode = product.getSkuCode();
        Product productFromDb = repository.findBySkuCode(skuCode);
        if (productFromDb == null) {
            String message = "Product with Sku Code = " + skuCode + "does not exist!";
            log.warn(message);
            throw new RuntimeException(message);
        }
        productFromDb.setUnitPrice(product.getUnitPrice());
        return mapper.toDto(productFromDb);
    }
}
