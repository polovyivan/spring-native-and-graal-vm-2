package com.spring.tutorial.microservice.customers.domain.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Column
    private String firstName;
    @NotNull
    @Column
    private String lastName;
    @NotNull
    @Column
    private String email;
    @NotNull
    @Column
    private String address;
    @NotNull
    @Column
    private String phoneNumber;

    @SuppressWarnings("unused")
    public Customer() {
    }
}
