package com.bta.diplom.service;

import com.bta.diplom.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    void create(CustomerDto customer);

    CustomerDto update(CustomerDto customer);

    void delete(String email);

    List<CustomerDto> getAll();
}
