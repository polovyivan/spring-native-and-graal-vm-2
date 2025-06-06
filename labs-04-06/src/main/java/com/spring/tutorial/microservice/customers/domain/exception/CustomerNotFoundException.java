package com.spring.tutorial.microservice.customers.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(long customerId) {
        super(String.format("Customer id %d not found", customerId));
    }
}
