package com.mateusz.shopv1.myshop_v1.repository;

import com.mateusz.shopv1.myshop_v1.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
