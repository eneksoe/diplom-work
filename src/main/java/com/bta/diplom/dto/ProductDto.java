package com.bta.diplom.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {
    private String name;
    private Integer skuCode;
    private Integer unitPrice;
    private Integer orderLineCount;
}
