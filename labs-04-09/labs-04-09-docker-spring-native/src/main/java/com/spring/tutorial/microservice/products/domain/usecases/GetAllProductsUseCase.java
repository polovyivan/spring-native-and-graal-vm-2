package com.spring.tutorial.microservice.products.domain.usecases;

import com.spring.tutorial.microservice.products.domain.dao.ProductsRepository;
import com.spring.tutorial.microservice.products.domain.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetAllProductsUseCase {

    @Autowired
    private ProductsRepository productsRepository;

    public Iterable<Product> execute() {
        return productsRepository.findAll();
    }
}
