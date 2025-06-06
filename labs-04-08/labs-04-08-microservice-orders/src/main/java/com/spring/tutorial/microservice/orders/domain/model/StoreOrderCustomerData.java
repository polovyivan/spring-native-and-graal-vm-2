package com.spring.tutorial.microservice.orders.domain.model;

import com.spring.tutorial.microservice.orders.domain.dto.Customer;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class StoreOrderCustomerData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Column
    private long customerId;
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
    public StoreOrderCustomerData() {
    }

    public StoreOrderCustomerData(Customer customer) {
        customerId = customer.getId();
        firstName = customer.getFirstName();
        lastName = customer.getLastName();
        email = customer.getEmail();
        address = customer.getAddress();
        phoneNumber = customer.getPhoneNumber();
    }
}
