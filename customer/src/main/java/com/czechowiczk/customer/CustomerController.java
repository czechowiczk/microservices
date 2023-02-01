package com.czechowiczk.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customers")
@Slf4j
public record CustomerController(CustomerService customerService) {

    @PostMapping
    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        customerService.registerCustomer(customerRegistrationRequest);
        log.info("New customer registration: {}", customerRegistrationRequest);
    }
}
