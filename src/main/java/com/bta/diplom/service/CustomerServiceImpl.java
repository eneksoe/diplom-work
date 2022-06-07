package com.bta.diplom.service;

import com.bta.diplom.dto.CustomerDto;
import com.bta.diplom.mapper.WebMapper;
import com.bta.diplom.model.Customer;
import com.bta.diplom.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private WebMapper<CustomerDto, Customer> mapper;

    @Override
    public void create(CustomerDto customer) {
        final Customer entity = mapper.toEntity(customer);
        repository.save(entity);

    }

    @Override
    public void update(CustomerDto customer) {
        create(customer);
    }

    @Override
    public List<CustomerDto> getAll() {
        return mapper.toDtos(repository.findAll());
    }
}