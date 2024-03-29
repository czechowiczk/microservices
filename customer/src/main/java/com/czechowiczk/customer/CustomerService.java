package com.czechowiczk.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        // todo check if email valid
        // todo check if email not taken
        // todo check if fraudster
        customerRepository.saveAndFlush(customer);

        FraudCheckResponse response = restTemplate.getForObject("http://localhost:8082/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId());
        if (response.isFraudster()) {
            throw new IllegalStateException("Fraudster");
        }
        // todo send notification
    }
}
