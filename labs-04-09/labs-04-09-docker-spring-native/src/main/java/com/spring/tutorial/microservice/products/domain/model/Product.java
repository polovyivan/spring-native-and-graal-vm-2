package com.spring.tutorial.microservice.products.domain.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Column
    private String sku;
    @NotNull
    @Column
    private String name;
    @NotNull
    @Column
    private BigDecimal price;
    @NotNull
    @Column
    private String currencyCode;
    @NotNull
    @Column
    private int stock;

    @SuppressWarnings("unused")
    public Product() {
    }
}
