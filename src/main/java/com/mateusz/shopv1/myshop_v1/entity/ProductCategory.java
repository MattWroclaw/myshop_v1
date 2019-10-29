package com.mateusz.shopv1.myshop_v1.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product_category")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String categoryName;


    @OneToOne
    @JoinColumn(name = "id_product", unique = true)
    private Product product;


//    private ProductCategory productCategory;
}
