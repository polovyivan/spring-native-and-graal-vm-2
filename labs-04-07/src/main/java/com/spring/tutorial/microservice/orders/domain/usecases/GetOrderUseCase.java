package com.spring.tutorial.microservice.orders.domain.usecases;

import com.spring.tutorial.microservice.orders.domain.dao.StoreOrdersRepository;
import com.spring.tutorial.microservice.orders.domain.exception.OrderNotFoundException;
import com.spring.tutorial.microservice.orders.domain.model.StoreOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetOrderUseCase {
    @Autowired
    private StoreOrdersRepository storeOrdersRepository;

    public StoreOrder execute(long orderId) {
        return storeOrdersRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(orderId));
    }
}
