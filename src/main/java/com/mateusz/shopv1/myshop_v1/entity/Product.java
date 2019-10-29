package com.mateusz.shopv1.myshop_v1.entity;

import lombok.Data;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long id;

    @Size(min = 2)
    @NotBlank
    private String title;

    @Size(min = 2)
    @NotBlank
    private String description;

    private int initialStockAmount;

    private int stockAmount;

    @OneToOne(mappedBy = "product", cascade = CascadeType.PERSIST)
    private ProductCategory productCategory;
}
