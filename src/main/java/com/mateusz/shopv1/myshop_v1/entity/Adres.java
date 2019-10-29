package com.mateusz.shopv1.myshop_v1.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "customer_adress")
public class Adres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String country;

    private String city;

    private String street;

    private String zipCode;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_customer", unique = true)
    private Customer customer;

}
