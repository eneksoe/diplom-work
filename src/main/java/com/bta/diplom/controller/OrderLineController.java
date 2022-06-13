package com.bta.diplom.controller;

import com.bta.diplom.dto.OrderLineDto;
import com.bta.diplom.service.OrderLinerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-line")
public class OrderLineController {

    @Autowired
    private OrderLinerService orderLinerService;

    @PostMapping("/create")
    public ResponseEntity<OrderLineDto> createOrderLine(@RequestBody OrderLineDto orderLine) {
        orderLinerService.create(orderLine);
        return new ResponseEntity<>(orderLine, HttpStatus.OK);
    }


    @GetMapping("/all")
    public List<OrderLineDto> getAll() {
        return orderLinerService.getAll();
    }

    @PutMapping("/update")
    public ResponseEntity<OrderLineDto> update(@RequestBody OrderLineDto orderLine) {
        final OrderLineDto updatedOrderLine = orderLinerService.update(orderLine);
        return new ResponseEntity<>(updatedOrderLine, HttpStatus.OK);
    }
}
