package com.spring.tutorial.microservice.orders.infrastructure.network;

import com.spring.tutorial.microservice.orders.domain.dto.Customer;
import com.spring.tutorial.microservice.orders.domain.port.CustomersRemoteService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class CustomersRemoteServiceApiClient implements CustomersRemoteService {

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${SERVICE_URL_CUSTOMERS}")
    private String serviceUrl;

    @Override
    public Customer getCustomer(long customerId) {
        return restTemplate.getForObject(
                serviceUrl + "/customer/api/v1/customers/{customerId}",
                Customer.class,
                Map.of("customerId", customerId)
        );
    }
}
