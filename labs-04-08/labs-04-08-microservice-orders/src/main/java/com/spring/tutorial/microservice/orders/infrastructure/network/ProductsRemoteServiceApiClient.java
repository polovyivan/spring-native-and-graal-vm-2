package com.spring.tutorial.microservice.orders.infrastructure.network;

import com.spring.tutorial.microservice.orders.domain.dto.Product;
import com.spring.tutorial.microservice.orders.domain.port.ProductsRemoteService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class ProductsRemoteServiceApiClient implements ProductsRemoteService {

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${SERVICE_URL_PRODUCTS}")
    private String serviceUrl;

    @Override
    public Product getProduct(long productId) {
        return restTemplate.getForObject(
                serviceUrl + "/product/api/v1/products/{productId}",
                Product.class,
                Map.of("productId", productId)
        );
    }
}
