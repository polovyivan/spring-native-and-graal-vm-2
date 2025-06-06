package com.spring.tutorial.microservice.orders.domain.dto;

import lombok.Data;

import java.util.List;

@Data
public class Order {
    private long customerId;
    private List<OrderLine> orderLines;

    public Order() {
    }
}
