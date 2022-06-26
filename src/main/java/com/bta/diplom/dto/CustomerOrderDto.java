package com.bta.diplom.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerOrderDto {
    private String customerEmail;
    private String orderNumber;
    private ZonedDateTime submissionDate;
    private List<OrderLineDto> orderLines;
}
