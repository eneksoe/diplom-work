package com.bta.diplom.mapper;

import com.bta.diplom.dto.CustomerDto;
import com.bta.diplom.model.Customer;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

import static com.bta.diplom.mapper.CustomerWebMapperHelper.getCustomer;
import static com.bta.diplom.mapper.CustomerWebMapperHelper.getCustomerDto;
import static org.junit.jupiter.api.Assertions.*;

class CustomerWebMapperTest {

    private final CustomerWebMapper instanceUnderTest = new CustomerWebMapper();

    @Test
    public void testMapNullEntityToDto() {
        final Customer entity = null;

        final CustomerDto actualResult = instanceUnderTest.toDto(entity);

        assertEquals(null, actualResult);
    }

    @Test
    public void testMapEntityNotNull() {
        final Customer customer = getCustomer();

        final CustomerDto actualResult = instanceUnderTest.toDto(customer);

        assertEquals("+37255663322", actualResult.getTelephone());
        assertEquals("test@test.com", actualResult.getEmail());
        assertEquals("Test", actualResult.getFirstName());
        assertEquals("Testov", actualResult.getLastName());
        assertEquals(BigInteger.valueOf(300L), actualResult.getRegistrationCode());
    }

    @Test
    public void testMapNullDtoToEntity() {
        final CustomerDto customer = null;

        final Customer actualResult = instanceUnderTest.toEntity(customer);

        assertEquals(null, actualResult);
    }

    @Test
    public void testMapDtoNotNull() {
        final CustomerDto customer = getCustomerDto();

        final Customer actualResult = instanceUnderTest.toEntity(customer);

        assertEquals("+37255663322", actualResult.getTelephone());
        assertEquals("test@test.com", actualResult.getEmail());
        assertEquals("Test", actualResult.getFirstName());
        assertEquals("Testov", actualResult.getLastName());
        assertEquals(BigInteger.valueOf(300L), actualResult.getRegistrationCode());
    }

    @Test
    public void testMapNullCollectionEntityToDtos() {
        final List<Customer> customers = null;

        final List<CustomerDto> actualResult = instanceUnderTest.toDtos(customers);

        assertEquals(null, actualResult);
    }

    @Test
    public void testMapCollectionEntityToDtos() {
        final List<Customer> customers = Collections.singletonList(getCustomer());

        final List<CustomerDto> actualResult = instanceUnderTest.toDtos(customers);

        assertEquals(1, actualResult.size());
    }

    @Test
    public void testMapNullCollectionDtosToEntity() {
        final List<CustomerDto> customers = null;

        final List<Customer> actualResult = instanceUnderTest.toEntities(customers);

        assertEquals(null, actualResult);
    }

    @Test
    public void testMapCollectionDtosToEntity() {
        final List<CustomerDto> customers = Collections.singletonList(getCustomerDto());

        final List<Customer> actualResult = instanceUnderTest.toEntities(customers);

        assertEquals(1, actualResult.size());
    }
}