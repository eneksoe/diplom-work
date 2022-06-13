package com.bta.diplom.service;

import com.bta.diplom.dto.CustomerDto;
import com.bta.diplom.dto.CustomerOrderDto;

import java.util.List;

public interface CustomerOrderService {
    void create(CustomerOrderDto customerOrder);

    List<CustomerOrderDto> getAll();
}
