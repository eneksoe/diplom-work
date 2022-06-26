package com.bta.diplom.service.impl;

import com.bta.diplom.dto.OrderLineDto;
import com.bta.diplom.mapper.OrderLineMapper;
import com.bta.diplom.mapper.WebMapper;
import com.bta.diplom.model.OrderLine;
import com.bta.diplom.repository.OrderLineRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class OrderLineServiceImplTest {

    private OrderLineRepository orderLineRepository;
    private WebMapper<OrderLineDto, OrderLine> mapper;
    private OrderLineServiceImpl instanceUnderTest;

    @BeforeEach
    public void beforeEach(){
        orderLineRepository = mock(OrderLineRepository.class);
        mapper = mock(OrderLineMapper.class);
        instanceUnderTest = new OrderLineServiceImpl();
    }

    @Test
    public void testIfOrderLineCreated(){
        when(orderLineRepository.findByCustomerOrder(any())).thenReturn(OrderLine.builder().build());
        instanceUnderTest.create(OrderLineDto.builder().build());
        verify(orderLineRepository, never()).save(OrderLine.builder().build());
    }

}