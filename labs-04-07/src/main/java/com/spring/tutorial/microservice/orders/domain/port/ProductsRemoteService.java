package com.spring.tutorial.microservice.orders.domain.port;

import com.spring.tutorial.microservice.orders.domain.dto.Product;

public interface ProductsRemoteService {

    Product getProduct(long productId);
}
