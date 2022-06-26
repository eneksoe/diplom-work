package com.bta.diplom.controller;

import com.bta.diplom.dto.CustomerDto;
import com.bta.diplom.dto.CustomerOrderDto;
import com.bta.diplom.dto.CustomerOrdersDto;
import com.bta.diplom.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/customer-order")
@RestController
public class CustomerOrderController {

    @Autowired
    private CustomerOrderService customerOrderService;

    @PostMapping("/create")
    public ResponseEntity<CustomerDto> create(@RequestBody CustomerOrderDto customerOrder) {
        customerOrderService.create(customerOrder);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<CustomerOrderDto> getAll() {
        return customerOrderService.getAll();
    }

    @PostMapping("/create-all")
    public ResponseEntity<CustomerDto> createAll(@RequestBody CustomerOrdersDto customerOrders) {
        customerOrderService.createAll(customerOrders);
        return new ResponseEntity(HttpStatus.OK);
    }
}
