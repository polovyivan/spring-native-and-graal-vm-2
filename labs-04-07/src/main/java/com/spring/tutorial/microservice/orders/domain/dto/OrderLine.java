package com.spring.tutorial.microservice.orders.domain.dto;

import lombok.Data;

@Data
public class OrderLine {
    private long productId;
    private int quantity;

    public OrderLine() {
    }
}
