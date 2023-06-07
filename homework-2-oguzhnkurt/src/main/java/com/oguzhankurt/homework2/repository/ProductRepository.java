package com.oguzhankurt.homework2.repository;

import com.oguzhankurt.homework2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
