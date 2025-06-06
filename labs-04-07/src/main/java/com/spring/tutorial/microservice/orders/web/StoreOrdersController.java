package com.spring.tutorial.microservice.orders.web;

import com.spring.tutorial.microservice.orders.domain.dto.Order;
import com.spring.tutorial.microservice.orders.domain.model.StoreOrder;
import com.spring.tutorial.microservice.orders.domain.usecases.GetAllOrdersUseCase;
import com.spring.tutorial.microservice.orders.domain.usecases.GetOrderUseCase;
import com.spring.tutorial.microservice.orders.domain.usecases.ProcessOrderUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order/api/v1/orders")
public class StoreOrdersController {
    @Autowired
    private GetAllOrdersUseCase getAllOrdersUseCase;
    @Autowired
    private GetOrderUseCase getOrderUseCase;
    @Autowired
    private ProcessOrderUseCase processOrderUseCase;

    @GetMapping("/{orderId}")
    public StoreOrder getOrder(@PathVariable("orderId") long orderId) {
        return getOrderUseCase.execute(orderId);
    }

    @GetMapping
    public Iterable<StoreOrder> getAllOrders() {
        return getAllOrdersUseCase.execute();
    }

    @PostMapping
    public StoreOrder processOrder(@RequestBody Order order) {
        return processOrderUseCase.execute(order);
    }
}
