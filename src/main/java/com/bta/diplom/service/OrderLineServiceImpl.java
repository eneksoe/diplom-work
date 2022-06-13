package com.bta.diplom.service;

import com.bta.diplom.dto.OrderLineDto;
import com.bta.diplom.exception.ResolvingException;
import com.bta.diplom.mapper.WebMapper;
import com.bta.diplom.model.OrderLine;
import com.bta.diplom.model.Product;
import com.bta.diplom.repository.OrderLineRepository;
import com.bta.diplom.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class OrderLineServiceImpl implements OrderLinerService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    OrderLineRepository orderLineRepository;

    @Autowired
    private WebMapper<OrderLineDto, OrderLine> mapper;

    @Override
    public void create(OrderLineDto orderLine) {
        final OrderLine entity = mapper.toEntity(orderLine);
        orderLineRepository.save(entity);
    }

    @Override
    public List<OrderLineDto> getAll() {
        return mapper.toDtos(orderLineRepository.findAll());
    }

    @Override
    public OrderLineDto update(OrderLineDto orderLine) {
        return null;
    }

   /* @Override
    public OrderLineDto update(OrderLineDto orderLine) {
        final Integer skuCode = orderLine.getProductSkuCode();
        Product orderLineFromDb = productRepository.findBySkuCode(skuCode);
        if (orderLineFromDb == null){
            String message =  "Product whit sku code: " + skuCode + " dose not exist in the system!";
            log.warn(message);
            throw new ResolvingException(message);
        }
        orderLineFromDb.setQuantity(orderLine.getQuantity());
        return mapper.toDto(orderLineFromDb);
    }*/
}
