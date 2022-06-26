package com.bta.diplom.mapper;

import com.bta.diplom.dto.CustomerDto;
import com.bta.diplom.model.Customer;
import lombok.experimental.UtilityClass;

import java.math.BigInteger;

@UtilityClass
class CustomerWebMapperHelper {

    static Customer getCustomer() {
        return Customer.builder()
                .telephone("+37255663322")
                .email("test@test.com")
                .firstName("Test")
                .lastName("Testov")
                .registrationCode(BigInteger.valueOf(300L))
                .build();
    }

    static CustomerDto getCustomerDto() {
        return CustomerDto.builder()
                .registrationCode(BigInteger.valueOf(300L))
                .telephone("+37255663322")
                .firstName("Test")
                .lastName("Testov")
                .email("test@test.com")
                .build();
    }
}
