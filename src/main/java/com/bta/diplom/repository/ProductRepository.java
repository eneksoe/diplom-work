package com.bta.diplom.repository;

import com.bta.diplom.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findBySkuCode(Integer skiCode);
}
