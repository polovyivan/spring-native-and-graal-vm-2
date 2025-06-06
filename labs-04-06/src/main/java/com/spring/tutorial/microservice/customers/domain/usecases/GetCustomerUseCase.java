package com.spring.tutorial.microservice.customers.domain.usecases;

import com.spring.tutorial.microservice.customers.domain.dao.CustomersRepository;
import com.spring.tutorial.microservice.customers.domain.exception.CustomerNotFoundException;
import com.spring.tutorial.microservice.customers.domain.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetCustomerUseCase {

    @Autowired
    private CustomersRepository customersRepository;

    public Customer execute(long customerId) {
        return customersRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));
    }
}
