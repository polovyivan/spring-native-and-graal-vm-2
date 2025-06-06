package com.spring.tutorial.microservice.orders.domain.model;

import com.spring.tutorial.microservice.orders.domain.dto.OrderLine;
import com.spring.tutorial.microservice.orders.domain.dto.Product;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Data
public class StoreOrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Column
    private long productId;
    @NotNull
    @Column
    private String sku;
    @NotNull
    @Column
    private String name;
    @NotNull
    @Column
    private String currencyCode;
    @NotNull
    @Column
    private BigDecimal unitPrice;
    @NotNull
    @Column
    private int orderedQuantity;
    @NotNull
    @Column
    private BigDecimal totalValue;

    @SuppressWarnings("unused")
    public StoreOrderLine() {
    }

    public StoreOrderLine(OrderLine orderLine, Product product) {
        productId = product.getId();
        sku = product.getSku();
        name = product.getName();
        currencyCode = product.getCurrencyCode();
        unitPrice = product.getPrice();
        orderedQuantity = orderLine.getQuantity();
        totalValue = product.getPrice().multiply(BigDecimal.valueOf(orderLine.getQuantity()));
    }
}
