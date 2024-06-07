package com.myapp.BookingApp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "address")
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String state;
    private String country;
    private String zipcode;

    @OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "order_id", referencedColumnName = "id")
    private MyOrder order;
}
