package com.bta.diplom;

import com.bta.diplom.model.Customer;
import com.bta.diplom.repository.CustomerOrderRepository;
import com.bta.diplom.repository.CustomerRepository;
import com.bta.diplom.repository.OrderLineRepository;
import com.bta.diplom.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DiplomApplication implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderLineRepository orderLineRepository;

    @Autowired
    private CustomerOrderRepository customerOrderRepository;


    public static void main(String[] args) {
        SpringApplication.run(DiplomApplication.class, args);
    }

    public void run(String... args) throws Exception {
        final List<Customer> customers = customerRepository.findAll();
        System.out.println(customers);

        System.out.println(customerOrderRepository.findAll());
        System.out.println(productRepository.findAll());
        System.out.println(orderLineRepository.findAll());

    }
}
