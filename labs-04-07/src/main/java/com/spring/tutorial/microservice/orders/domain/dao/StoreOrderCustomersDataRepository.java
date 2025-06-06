package com.spring.tutorial.microservice.orders.domain.dao;

import com.spring.tutorial.microservice.orders.domain.model.StoreOrderCustomerData;
import org.springframework.data.repository.CrudRepository;

public interface StoreOrderCustomersDataRepository extends CrudRepository<StoreOrderCustomerData, Long> {
}
