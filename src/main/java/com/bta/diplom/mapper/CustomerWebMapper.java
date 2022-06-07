package com.bta.diplom.mapper;

import com.bta.diplom.dto.CustomerDto;
import com.bta.diplom.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerWebMapper implements WebMapper<CustomerDto, Customer> {

    @Override
    public CustomerDto toDto(Customer entity) {
        return CustomerDto.builder()
                .firstName(entity.getFirstName())
                .email(entity.getEmail())
                .lastName(entity.getLastName())
                .registrationCode(entity.getRegistrationCode())
                .telephone(entity.getTelephone())
                .build();
    }

    @Override
    public Customer toEntity(CustomerDto dto) {
        return Customer.builder()
                .firstName(dto.getFirstName())
                .email(dto.getEmail())
                .lastName(dto.getLastName())
                .registrationCode(dto.getRegistrationCode())
                .telephone(dto.getTelephone())
                .build();
    }
}
