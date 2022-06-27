package com.bta.diplom.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@Builder
public class CustomerOrderDto {
    private CustomerDto customer;
    private String orderNumber;

    private List<OrderLineDto> orderLines;

}
