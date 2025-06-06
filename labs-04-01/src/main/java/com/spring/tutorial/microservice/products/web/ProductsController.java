package com.spring.tutorial.microservice.products.web;

import com.spring.tutorial.microservice.products.ds.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/api/v1/products")
public class ProductsController {

    @GetMapping("/{productId}")
    public Product getProduct(@PathVariable("productId") long productId) {
        return null;
    }

    @GetMapping
    public Iterable<Product> getAllProducts() {
        return null;
    }
}
