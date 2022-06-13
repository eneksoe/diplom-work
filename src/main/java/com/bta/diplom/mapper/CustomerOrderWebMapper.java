package com.bta.diplom.mapper;

import com.bta.diplom.dto.CustomerOrderDto;
import com.bta.diplom.model.CustomerOrder;
import com.bta.diplom.resolver.CustomerResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomerOrderWebMapper implements WebMapper<CustomerOrderDto, CustomerOrder> {

    @Autowired
    private CustomerResolver customerResolver;

    @Override
    public CustomerOrderDto toDto(CustomerOrder entity) {
        return CustomerOrderDto.builder()
                .customerEmail(entity.getCustomer().getEmail())
                .orderNumber(entity.getOrderNumber())
                .submissionDate(entity.getSubmissionDate())
                .build();
    }

    @Override
    public CustomerOrder toEntity(CustomerOrderDto dto) {
        var customer = customerResolver.resolveByEmail(dto.getCustomerEmail());
        return CustomerOrder.builder()
                .orderNumber(dto.getOrderNumber())
                .submissionDate(dto.getSubmissionDate())
                .customer(customer)
                .build();
    }
}
