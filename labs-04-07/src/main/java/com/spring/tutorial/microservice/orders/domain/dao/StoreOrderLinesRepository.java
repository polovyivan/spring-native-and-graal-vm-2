package com.spring.tutorial.microservice.orders.domain.dao;

import com.spring.tutorial.microservice.orders.domain.model.StoreOrderLine;
import org.springframework.data.repository.CrudRepository;

public interface StoreOrderLinesRepository extends CrudRepository<StoreOrderLine, Long> {
}
