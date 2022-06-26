package com.bta.diplom.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineDto {
    private ProductDto product;
    private Integer quantity;
    private Integer productSkuCode;
    private String customerOrder;

}
