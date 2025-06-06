package com.spring.tutorial.microservice.customers.domain.dao;

import com.spring.tutorial.microservice.customers.domain.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomersRepository extends CrudRepository<Customer, Long> {
}
