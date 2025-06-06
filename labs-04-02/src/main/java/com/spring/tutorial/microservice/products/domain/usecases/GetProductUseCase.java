package com.spring.tutorial.microservice.products.domain.usecases;

import com.spring.tutorial.microservice.products.domain.dao.ProductsRepository;
import com.spring.tutorial.microservice.products.domain.exception.ProductNotFoundException;
import com.spring.tutorial.microservice.products.domain.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetProductUseCase {

    @Autowired
    private ProductsRepository productsRepository;

    public Product execute(long productId) {
        return productsRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId));
    }
}
