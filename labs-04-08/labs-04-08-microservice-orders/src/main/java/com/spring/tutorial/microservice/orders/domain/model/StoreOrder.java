package com.spring.tutorial.microservice.orders.domain.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
public class StoreOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private StoreOrderCustomerData orderCustomerData;
    @OneToMany
    private List<StoreOrderLine> storeOrderLines;
    @NotNull
    @Column
    private BigDecimal totalValue;

    @SuppressWarnings("unused")
    public StoreOrder() {
    }

    public StoreOrder(StoreOrderCustomerData orderCustomerData, List<StoreOrderLine> storeOrderLines) {
        this.orderCustomerData = orderCustomerData;
        this.storeOrderLines = storeOrderLines;
        totalValue = calculateTotalValue(storeOrderLines);
    }

    private BigDecimal calculateTotalValue(List<StoreOrderLine> storeOrderLines) {
        return storeOrderLines.stream()
                .map(StoreOrderLine::getTotalValue)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
