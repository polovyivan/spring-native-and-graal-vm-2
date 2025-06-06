package com.spring.tutorial.microservice.customers.domain.usecases;

import com.spring.tutorial.microservice.customers.domain.dao.CustomersRepository;
import com.spring.tutorial.microservice.customers.domain.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetAllCustomersUseCase {

    @Autowired
    private CustomersRepository customersRepository;

    public Iterable<Customer> execute() {
        return customersRepository.findAll();
    }
}
