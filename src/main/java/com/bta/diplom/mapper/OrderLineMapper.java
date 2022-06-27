package com.bta.diplom.mapper;

import com.bta.diplom.dto.OrderLineDto;
import com.bta.diplom.model.OrderLine;
import com.bta.diplom.resolver.CustomerOrderResolver;
import com.bta.diplom.resolver.ProductResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderLineMapper implements WebMapper<OrderLineDto, OrderLine> {

    @Autowired
    private CustomerOrderResolver customerOrderResolver;

    @Autowired
    private ProductResolver productResolver;

    @Override
    public OrderLineDto toDto(OrderLine entity) {
        return OrderLineDto.builder()
               // .customerOrder(entity.getCustomerOrder().getOrderNumber())
                .quantity(entity.getQuantity())
               // .productSkuCode(entity.getProduct().getSkuCode())
                .build();
    }

    @Override
    public OrderLine toEntity(OrderLineDto dto) {
       // var customerOrder = customerOrderResolver.resolveByOrderNumber(dto.getCustomerOrder());
       // var product = productResolver.resolveBySkuCode(dto.getProductSkuCode());
        return OrderLine.builder()
               // .customerOrder(customerOrder)
                .quantity(dto.getQuantity())
               // .product(product)
                .build();
    }
}
