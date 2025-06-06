package com.spring.tutorial.microservice.orders.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(long orderId) {
        super(String.format("Order id %d not found", orderId));
    }
}
