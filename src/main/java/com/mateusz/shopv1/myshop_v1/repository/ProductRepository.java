package com.mateusz.shopv1.myshop_v1.repository;

import com.mateusz.shopv1.myshop_v1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
List<Product> findAllByTitleLike(String filter);
}
