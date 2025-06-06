package com.spring.tutorial.microservice.orders.domain.usecases;

import com.spring.tutorial.microservice.orders.domain.dao.StoreOrderCustomersDataRepository;
import com.spring.tutorial.microservice.orders.domain.dao.StoreOrderLinesRepository;
import com.spring.tutorial.microservice.orders.domain.dao.StoreOrdersRepository;
import com.spring.tutorial.microservice.orders.domain.dto.Customer;
import com.spring.tutorial.microservice.orders.domain.dto.Order;
import com.spring.tutorial.microservice.orders.domain.dto.OrderLine;
import com.spring.tutorial.microservice.orders.domain.dto.Product;
import com.spring.tutorial.microservice.orders.domain.model.StoreOrder;
import com.spring.tutorial.microservice.orders.domain.model.StoreOrderCustomerData;
import com.spring.tutorial.microservice.orders.domain.model.StoreOrderLine;
import com.spring.tutorial.microservice.orders.domain.port.CustomersRemoteService;
import com.spring.tutorial.microservice.orders.domain.port.ProductsRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.collections4.IterableUtils.toList;

@Component
public class ProcessOrderUseCase {

    @Autowired
    private CustomersRemoteService customersRemoteService;
    @Autowired
    private ProductsRemoteService productsRemoteService;
    @Autowired
    private StoreOrdersRepository storeOrdersRepository;
    @Autowired
    private StoreOrderCustomersDataRepository storeOrderCustomersDataRepository;
    @Autowired
    private StoreOrderLinesRepository storeOrderLinesRepository;

    @Transactional
    public StoreOrder execute(Order order) {
        StoreOrderCustomerData orderCustomerData = getStoreOrderCustomerData(order);
        List<StoreOrderLine> orderLines = getOrderLines(order);

        orderCustomerData = storeOrderCustomersDataRepository.save(orderCustomerData);
        orderLines = toList(storeOrderLinesRepository.saveAll(orderLines));

        StoreOrder storeOrder = new StoreOrder(orderCustomerData, orderLines);

        return storeOrdersRepository.save(storeOrder);
    }

    private StoreOrderCustomerData getStoreOrderCustomerData(Order order) {
        Customer customer = customersRemoteService.getCustomer(order.getCustomerId());

        return new StoreOrderCustomerData(customer);
    }

    private List<StoreOrderLine> getOrderLines(Order order) {
        return order.getOrderLines().stream()
                .map(this::getOrderLine)
                .collect(Collectors.toList());
    }

    private StoreOrderLine getOrderLine(OrderLine orderLine) {
        Product product = productsRemoteService.getProduct(orderLine.getProductId());

        return new StoreOrderLine(orderLine, product);
    }
}
