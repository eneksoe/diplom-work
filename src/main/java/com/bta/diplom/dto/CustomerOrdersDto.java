package com.bta.diplom.dto;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerOrdersDto {
    private List<CustomerOrderDto> customerOrders;
}
