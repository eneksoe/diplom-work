package com.bta.diplom.service.impl;

import com.bta.diplom.dto.CustomerDto;
import com.bta.diplom.mapper.CustomerWebMapper;
import com.bta.diplom.model.Customer;
import com.bta.diplom.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CustomerWebMapper mapper;

    @InjectMocks
    private CustomerServiceImpl instanceUnderTest = new CustomerServiceImpl();

    Customer customer = Customer.builder()
            .registrationCode(BigInteger.valueOf(123456))
            .lastName("Test")
            .firstName("Test")
            .email("test@test.com")
            .telephone("+37255555555")
            .build();

    CustomerDto customerDto = CustomerDto.builder()
            .registrationCode(BigInteger.valueOf(123456))
            .lastName("Test")
            .firstName("Test")
            .email("test@test.com")
            .telephone("+37255555555")
            .build();

    @Test
    public void testIfCustomerCreated() {
        lenient().when(customerRepository.findByEmail(any())).thenReturn(customer);

        instanceUnderTest.create(customerDto);

        verify(customerRepository, never()).save(customer);
    }

    @Test
    public void testNullEmail(){
        final CustomerDto customer1 = CustomerDto.builder().email(null).build();

        final RuntimeException actualResult = assertThrows(RuntimeException.class, () -> instanceUnderTest.update(customer1));

        assertEquals("Email must be not Null or Empty!", actualResult.getMessage());
    }

    @Test
    public void testEmptyEmail(){
        final CustomerDto customer1 = CustomerDto.builder().email("").build();

        final RuntimeException actualResult = assertThrows(RuntimeException.class, () -> instanceUnderTest.update(customer1));

        assertEquals("Email must be not Null or Empty!", actualResult.getMessage());
    }

    @Test
    public void testNotEmptyEmail(){
        lenient().when(customerRepository.findByEmail(any())).thenReturn(customer);

        instanceUnderTest.update(customerDto);

        assertEquals("test@test.com", customer.getEmail());
    }
}