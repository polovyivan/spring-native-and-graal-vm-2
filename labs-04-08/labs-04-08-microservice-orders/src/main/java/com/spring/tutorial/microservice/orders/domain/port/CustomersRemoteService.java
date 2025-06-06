package com.spring.tutorial.microservice.orders.domain.port;

import com.spring.tutorial.microservice.orders.domain.dto.Customer;

public interface CustomersRemoteService {

    Customer getCustomer(long customerId);
}
