package com.bta.diplom.controller;

import com.bta.diplom.dto.CustomerDto;
import com.bta.diplom.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customer) {
        customerService.create(customer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @GetMapping("/all")
   public List<CustomerDto> getAll(){
        return  customerService.getAll();
    }
}