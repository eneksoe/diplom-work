package com.bta.diplom.service;

import com.bta.diplom.dto.OrderLineDto;
import com.bta.diplom.model.OrderLine;

import java.util.List;

public interface OrderLinerService {

    void create(OrderLineDto orderLine);

    List<OrderLineDto> getAll();

    OrderLineDto update(OrderLineDto orderLine);
}
