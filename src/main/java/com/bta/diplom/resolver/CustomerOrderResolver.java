package com.bta.diplom.resolver;

import com.bta.diplom.exception.ResolvingException;
import com.bta.diplom.model.CustomerOrder;
import com.bta.diplom.repository.CustomerOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomerOrderResolver {

    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    public CustomerOrder resolveByOrderNumber(String orderNumber) {
        final CustomerOrder customerOrder = customerOrderRepository.findByOrderNumber(orderNumber);
        if (orderNumber == null) {
            String message = "Order number: " + orderNumber + " dose not exist in the system!";
            log.warn(message);
            throw new ResolvingException(message);
        }
        return customerOrder;
    }
}
