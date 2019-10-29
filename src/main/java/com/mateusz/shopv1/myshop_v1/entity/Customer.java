package com.mateusz.shopv1.myshop_v1.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    private String mail;

    private String password;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.PERSIST)
    private Adres adres;

}
