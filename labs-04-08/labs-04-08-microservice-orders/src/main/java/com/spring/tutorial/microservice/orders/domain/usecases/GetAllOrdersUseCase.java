package com.spring.tutorial.microservice.orders.domain.usecases;

import com.spring.tutorial.microservice.orders.domain.dao.StoreOrdersRepository;
import com.spring.tutorial.microservice.orders.domain.model.StoreOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetAllOrdersUseCase {
    @Autowired
    private StoreOrdersRepository storeOrdersRepository;

    public Iterable<StoreOrder> execute() {
        return storeOrdersRepository.findAll();
    }
}
