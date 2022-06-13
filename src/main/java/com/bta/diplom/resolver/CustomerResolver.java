package com.bta.diplom.resolver;

import com.bta.diplom.exception.ResolvingException;
import com.bta.diplom.model.Customer;
import com.bta.diplom.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomerResolver {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer resolveByEmail(String email) {
        final Customer customer = customerRepository.findByEmail(email);
        if (customer == null) {
            String message = "Customer with email: " + email + " does not exist in the system!";
            log.warn(message);
            throw new ResolvingException(message);
        }
        return customer;
    }
}
