package com.bta.diplom.service;

import com.bta.diplom.dto.CustomerDto;
import com.bta.diplom.dto.CustomerOrderDto;
import com.bta.diplom.dto.CustomerOrdersDto;

import java.util.List;

public interface CustomerOrderService {
    void create(CustomerOrderDto customerOrder);

    void createAll(CustomerOrdersDto customerOrders);

    List<CustomerOrderDto> getAll();
}
