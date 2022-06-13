package com.bta.diplom.resolver;

import com.bta.diplom.exception.ResolvingException;
import com.bta.diplom.model.Product;
import com.bta.diplom.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProductResolver {

    @Autowired
    private ProductRepository productRepository;

    public Product resolveBySkuCode(Integer skuCode) {
        final Product product = productRepository.findBySkuCode(skuCode);
        if (product == null) {
            String message = "Product whit sku code: " + skuCode + " dose not exist in the system!";
            log.warn(message);
            throw new ResolvingException(message);
        }
        return product;
    }
}
