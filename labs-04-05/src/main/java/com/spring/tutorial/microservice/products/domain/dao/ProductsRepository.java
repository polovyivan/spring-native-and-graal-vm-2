package com.spring.tutorial.microservice.products.domain.dao;

import com.spring.tutorial.microservice.products.domain.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductsRepository extends CrudRepository<Product, Long> {
}
