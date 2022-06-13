package com.bta.diplom.service;

import com.bta.diplom.dto.CustomerDto;
import com.bta.diplom.mapper.WebMapper;
import com.bta.diplom.model.Customer;
import com.bta.diplom.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
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
    public CustomerDto update(CustomerDto customer) {
        final String email = customer.getEmail();
        Customer customerFromDb = repository.findByEmail(email);
        if (customerFromDb == null) {
            String message = "Customer with email = " + email + "does not exist!";
            log.warn(message);
            throw new RuntimeException(message);
        }
        customerFromDb.setFirstName(customer.getFirstName());
        customerFromDb.setLastName(customer.getLastName());
        customerFromDb.setTelephone(customerFromDb.getTelephone());
        return mapper.toDto(customerFromDb);
    }

    @Override
    public void delete(String email) {
        repository.deleteByEmail(email);
    }

    @Override
    public List<CustomerDto> getAll() {
        return mapper.toDtos(repository.findAll());
    }
}