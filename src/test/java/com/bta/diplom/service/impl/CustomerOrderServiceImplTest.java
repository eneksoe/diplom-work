package com.bta.diplom.service.impl;

import com.bta.diplom.dto.CustomerOrderDto;
import com.bta.diplom.mapper.CustomerOrderWebMapper;
import com.bta.diplom.mapper.WebMapper;
import com.bta.diplom.model.CustomerOrder;
import com.bta.diplom.repository.CustomerOrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerOrderServiceImplTest {

    @Mock
    private CustomerOrderRepository customerOrderRepository;



    @Mock
    private WebMapper<CustomerOrderDto, CustomerOrder> mapper;

    @InjectMocks
    private CustomerOrderServiceImpl instanceUnderTest = new CustomerOrderServiceImpl();

    @Test
    void testIfCustomerOrderCreated() {
        lenient().when(customerOrderRepository.findByOrderNumber(any())).thenReturn(CustomerOrder.builder().build());
        instanceUnderTest.create(CustomerOrderDto.builder().build());
        verify(customerOrderRepository, never()).save(CustomerOrder.builder().build());
    }
}