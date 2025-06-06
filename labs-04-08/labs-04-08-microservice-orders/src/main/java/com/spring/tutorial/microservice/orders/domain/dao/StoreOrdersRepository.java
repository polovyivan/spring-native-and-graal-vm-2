package com.spring.tutorial.microservice.orders.domain.dao;

import com.spring.tutorial.microservice.orders.domain.model.StoreOrder;
import org.springframework.data.repository.CrudRepository;

public interface StoreOrdersRepository extends CrudRepository<StoreOrder, Long> {
}
